import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.net.URL;

public class UserInterface implements ActionListener
{
    private GameEngine aEngine;
    private JFrame aMyFrame;
    private JTextField aEntryField;
    private JTextArea aLog;
    private JLabel aImage;
    private JButton aHelpButton;

    /**
     * Construie une interface utilisateur.
     * En tant que paramètre, un moteur de jeu
     * (un objet traitant et exécutant les commandes du jeu) est
     * nécessaire.
     * 
     * @param pGameEngine L'objet GameEngine implémentant la logique du jeu.
     */
    public UserInterface(final GameEngine pGameEngine)
    {
        this.aEngine = pGameEngine;
        this.createGUI();
    } // UserInterface(final GameEngine pGameEngine)

    /**
     * Imprime du texte dans la zone de texte.
     */
    public void print(final String pText)
    {
        this.aLog.append(pText);
        this.aLog.setCaretPosition(this.aLog.getDocument().getLength());
    } // print(final String pText)

    /**
     * Imprime du texte dans la zone de texte, suivi d'un saut de ligne.
     */
    public void println(final String pText)
    {
        this.print(pText + "\n");
    } // println(final String pText)

    /**
     * Affiche un fichier image dans l'interface.
     */
    public void showImage(final String pImageName)
    {
        String vImagePath = "" + pImageName; // to change the directory
        URL vImageURL = this.getClass().getClassLoader().getResource(vImagePath);
        if (vImageURL == null)
            System.out.println("Image not found : " + vImagePath);
        else {
            ImageIcon vIcon = new ImageIcon(vImageURL);
            this.aImage.setIcon(vIcon);
            this.aMyFrame.pack();
        }
    } // showImage(final String pImageName)

    /**
     * Active ou désactive la saisie dans le champ de saisie.
     */
    public void enable(final boolean pOnOff)
    {
        this.aEntryField.setEditable(pOnOff); // enable/disable
        if (pOnOff) { // enable
            this.aEntryField.getCaret().setBlinkRate(500); // cursor blink
            this.aEntryField.addActionListener(this); // reacts to entry
        }
        else { // disable
            this.aEntryField.getCaret().setBlinkRate(0); // cursor won't blink
            this.aEntryField.removeActionListener(this); // won't react to entry
        }
    } // enable(final boolean pOnOff)

    /**
     * Configure l'interface utilisateur graphique.
     */
    private void createGUI()
    {
        // titre fenêtre
        this.aMyFrame = new JFrame("Jeu d'aventure");
        this.aEntryField = new JTextField(34);
        
        // zone texte
        this.aLog = new JTextArea();
        this.aLog.setEditable(false);
        JScrollPane vListScroller = new JScrollPane(this.aLog);
        vListScroller.setPreferredSize(new Dimension(200, 200));
        vListScroller.setMinimumSize(new Dimension(100,100));
        
        // image affichée
        this.aImage = new JLabel();
        
        // bouton aide
        this.aHelpButton = new JButton("Aide");

        
        JPanel vPanel = new JPanel();
        vPanel.setLayout(new BorderLayout()); // ==> only five places
        vPanel.add(this.aImage, BorderLayout.NORTH);
        vPanel.add(vListScroller, BorderLayout.CENTER);
        vPanel.add(this.aEntryField, BorderLayout.SOUTH);
        vPanel.add(this.aHelpButton, BorderLayout.WEST);

        this.aMyFrame.getContentPane().add(vPanel, BorderLayout.CENTER);

        // add some event listeners to some components
        this.aEntryField.addActionListener(this);
        this.aHelpButton.addActionListener(this);

        // to end program when window is closed
        this.aMyFrame.addWindowListener(
            new WindowAdapter() { // anonymous class
                @Override public void windowClosing(final WindowEvent pE)
                {
                    System.exit(0);
                }
        });

        this.aMyFrame.pack();
        this.aMyFrame.setVisible(true);
        this.aEntryField.requestFocus();
    } // createGUI()

    /**
     * L'interface ActionListener pour le champ de saisie.
     */
    @Override
    public void actionPerformed(final ActionEvent pE) 
    {
        if (pE.getActionCommand() == "Aide")
        {
            this.aEngine.interpretCommand("aide");
        }
        else
        this.processCommand();
    } // actionPerformed(final ActionEvent pE)

    /**
     * Une commande a été saisie dans le champ de saisie.  
     * Lit la commande et effectuez les opérations nécessaires
     * pour la traiter.
     */
    private void processCommand()
    {
        String vInput = this.aEntryField.getText();
        this.aEntryField.setText("");

        this.aEngine.interpretCommand(vInput);
    } // processCommand()
} // UserInterface 