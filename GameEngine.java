import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class GameEngine
{
    private ArrayList<Player> aListPlayer;
    private Parser aParser;
    private ArrayList<Room> aListRoom;
    private Room aFirstRoom;
    private UserInterface aGui;
    private int aMaxAction;
    
    /**
     * Lance la création des salles du jeu
     * et initialise un analyseur.
     */
    public GameEngine()
    {
        this.createRooms();
        this.aListPlayer = new ArrayList<>();
        this.aParser = new Parser();
        this.aMaxAction = 50;
    } // GameEngine()
    
    /**
     * Ajoute un joueur à la partie.
     */
    private void newPlayer()
    {
        String vName = this.getPlayerName();
        Player vNewPlayer = new Player(this.aListPlayer.size(), vName, this.aFirstRoom);
        this.aListPlayer.add(vNewPlayer);
    } // newPlayer()
    
    /**
     * Demande le nom du joueur.
     */
    private String getPlayerName()
    {
        String vName = null;
        vName = javax.swing.JOptionPane.showInputDialog( "Quel est ton prenom ?" );
        this.aGui.println("> " + vName);
        return vName;
    } // getPlayerName()
    
    /**
     * Crée des salles du jeu
     * et des liens entre les Rooms.
     * Place des items dans les Rooms.
     * Initialise la Room de départ.
     */
    private void createRooms()
    {
        Room vPlaceA = new Room("à la place A", "Images/placeA.png");
        Room vPlaceB = new Room("à la place B", "Images/placeB.png");
        Room vPlaceC = new Room("à la place C", "Images/placeC.png");
        Room vPlaceD = new Room("à la place D", "Images/placeD.png");
        Room vPlaceE = new Room("à la place E", "Images/placeE.png");
        Room vPlaceF = new Room("à la place F", "Images/placeF.png");
        Room vPlaceG = new Room("à la place G", "Images/placeG.png");
        Room vPlaceH = new Room("à la place H", "Images/placeH.png");
        Room vEntreeEgouts = new Room("l'entrée des égouts", "Images/egouts.png");
        Room vEgout1 = new Room("dans l'égout 1", "Images/egouts.png");
        Room vEgout2 = new Room("dans l'égout 2", "Images/egouts.png");
        Room vEgout3 = new Room("dans l'égout 3", "Images/egouts.png");
        Room vEgout4 = new Room("dans l'égout 4", "Images/egouts.png");
        Room vEgout5 = new Room("dans l'égout 5", "Images/egouts.png");
        Room vEntreeMairie = new Room("dans l'entrée de la mairie", "Images/mairie.png");
        Room vAccueilMairie = new Room("à l'accueil de la mairie", "Images/mairie.png");
        Room vSecretariat = new Room("au secrétariat", "Images/mairie.png");
        Room vMaison = new Room("à votre maison", "Images/maison.png");
        
        this.aListRoom = new ArrayList<>();
        aListRoom.add(vPlaceA);
        aListRoom.add(vPlaceB);
        aListRoom.add(vPlaceC);
        aListRoom.add(vPlaceD);
        aListRoom.add(vPlaceE);
        aListRoom.add(vPlaceF);
        aListRoom.add(vPlaceG);
        aListRoom.add(vPlaceH);
        aListRoom.add(vEntreeEgouts);
        aListRoom.add(vEgout1);
        aListRoom.add(vEgout2);
        aListRoom.add(vEgout3);
        aListRoom.add(vEgout4);
        aListRoom.add(vEgout5);
        aListRoom.add(vEntreeMairie);
        aListRoom.add(vAccueilMairie);
        aListRoom.add(vSecretariat);
        aListRoom.add(vMaison);
        
        vPlaceA.setExit("est", vPlaceB);
        vPlaceA.setExit("égouts", vEntreeEgouts);
        vEntreeEgouts.setExit("sud", vEgout3);
        vEntreeEgouts.setExit("est", vEgout2);
        vEntreeEgouts.setExit("ouest", vEgout1);
        vEntreeEgouts.setExit("sortie", vPlaceA);
        vEgout1.setExit("est", vEntreeEgouts);
        vEgout2.setExit("ouest", vEntreeEgouts);
        vEgout2.setExit("porte", vEgout4);
        vEgout3.setExit("nord", vEntreeEgouts);
        vEgout3.setExit("sud", vEgout5);
        vEgout3.setExit("est", vEgout4);
        vEgout4.setExit("ouest", vEgout3);
        vEgout5.setExit("nord", vEgout3);
        vEgout5.setExit("porte", vEgout4);
        vPlaceB.setExit("sud", vPlaceC);
        vPlaceB.setExit("est", vPlaceE);
        vPlaceB.setExit("ouest", vPlaceA);
        vPlaceC.setExit("nord", vPlaceB);
        vPlaceC.setExit("sud", vPlaceD);
        vPlaceC.setExit("est", vPlaceG);
        vPlaceC.setExit("mairie", vEntreeMairie);
        vEntreeMairie.setExit("accueil", vAccueilMairie);
        vEntreeMairie.setExit("sortie", vPlaceC);
        vEntreeMairie.setExit("1er-étage", vSecretariat);
        vAccueilMairie.setExit("entrée", vEntreeMairie);
        vSecretariat.setExit("rez-de-chaussée", vEntreeMairie);
        vPlaceD.setExit("nord", vPlaceC);
        vPlaceE.setExit("nord", vPlaceF);
        vPlaceE.setExit("sud", vPlaceG);
        vPlaceE.setExit("est", vPlaceH);
        vPlaceE.setExit("ouest", vPlaceB);
        vPlaceF.setExit("sud", vPlaceE);
        vPlaceG.setExit("nord", vPlaceE);
        vPlaceG.setExit("ouest", vPlaceC);
        vPlaceH.setExit("ouest", vPlaceE);
        
        vEntreeEgouts.getItems().addNewItem("t-shirt", "", 3);
        vEntreeEgouts.getItems().addNewItem("short", "", 3);
        vEgout1.getItems().addNewItem("lunettes", "Elles sont un peu rayées", 4);
        vEgout2.getItems().addNewItem("chaussures", "La semelle se décolle...", 3);
        vEgout3.getItems().addNewItem("caillou", "Très beau caillou !", 0);
        vEgout4.getItems().addNewItem("casquette", "Sympa", 2);
        vEgout5.getItems().addNewItem("chaussettes", "C'est mieux pour mettre des chaussures", 1);
        vPlaceE.getItems().addNewItem("billet", "Quelle chance !", 5);
        vPlaceB.getItems().addNewItem("cookie", "Quelle chance !", 0);
        
        this.aFirstRoom = vEntreeEgouts;
    } // CreateRooms()
    
    /**
     * Innitialise l'interface graphique.
     */
    public void setGUI(final UserInterface pUserInterface)
    {
        this.aGui = pUserInterface;
        this.newPlayer();
        this.printWelcome();
    } // setGUI(final UserInterface pUserInterface)
    
    /**
     * Affiche la description de la salle atuelle
     * et des sorties disponibles.
     */
    private void printLocationInfo()
    {
        Player vPlayer = this.aListPlayer.get(0);
        this.aGui.println(vPlayer.getLocationInfo());
    } // printLocationInfo()
    
    /**
     * Affiche le message d'accueil au joueur.
     */
    private void printWelcome()
    {
        this.aGui.println("--------------------------");
        this.aGui.println("--------------------------");
        this.aGui.println("Wow...");
        this.aGui.println("...où suis-je ?");
        this.aGui.println("Mais qui suis-je ?");
        this.aGui.println("Je ne vois rien içi.");
        this.aGui.println("");
        this.printLocationInfo();
        this.aGui.println("Tappez 'aide' si besoin");
        this.aGui.println("");
        Player vPlayer = this.aListPlayer.get(0);
        if (vPlayer.getCurrentRoom().getImageName() != null)
            this.aGui.showImage(vPlayer.getCurrentRoom().getImageName());
    } // printWelcome()
    
    /**
     * Execution d'une commande tapée par le joueur.
     */
    public void interpretCommand(final String pCommandLine)
    {
        this.aGui.println("> " + pCommandLine);
        Command vCommand = this.aParser.getCommand(pCommandLine);

        if (vCommand.isUnknown())
        {
            this.aGui.println("Je ne comprends pas cette commande...");
            this.aGui.println("");
            return;
        }
        
        final String vCommandWord = vCommand.getCommandWord();
        Player vPlayer = this.aListPlayer.get(0);
        if (vCommandWord.equals("aller"))
        {
            int vGoRoomExecution = vPlayer.goRoom(vCommand);
            if (vGoRoomExecution == 0)
            {
                this.printLocationInfo();
                if (vPlayer.getCurrentRoom().getImageName() != null)
                     this.aGui.showImage(vPlayer.getCurrentRoom().getImageName());
            }
            else if (vGoRoomExecution == 1)
                this.aGui.println("Aller où ?");
            else if (vGoRoomExecution == 2)
                this.aGui.println("Cette direction n'existe pas !");
        }
        else if (vCommandWord.equals("aide"))
            this.printHelp(vCommand); 
        else if (vCommandWord.equals("regarder"))
            this.look(vCommand);
        else if (vCommandWord.equals("manger"))
        {
            int vEatExecution = vPlayer.eat(vCommand);
            if (vEatExecution == 0)
            {
                this.aGui.println("Cookie magique !!!");
                this.aGui.println("Vous pouvez à présent contenir 2 fois");
                this.aGui.println("plus de valeurs dans votre inventaire");
            }
            else if (vEatExecution == 1)
                this.aGui.println("Manger quoi ?");
            else if (vEatExecution == 2)
                this.aGui.println("Vous n'avez pas de cookie...");
            else if (vEatExecution == 3)
                this.aGui.println("Vous ne pouvez manger que des cookies");
        }
        else if (vCommandWord.equals("quitter"))
            this.quit(vCommand);
        else if (vCommandWord.equals("reculer"))
        {
            int vBackExecution = vPlayer.back(vCommand);
            if (vBackExecution == 0)
            {
                this.printLocationInfo();
                if (vPlayer.getCurrentRoom().getImageName() != null)
                     this.aGui.showImage(vPlayer.getCurrentRoom().getImageName());
            }
            else if (vBackExecution == 1)
                this.aGui.println("Vous ne pouvez pas plus reculer");
            else if (vBackExecution == 2)
                this.aGui.println("Cette commande ne prend pas de deuxième mot");
        }
        else if (vCommandWord.equals("tester"))
        {
            this.test(vCommand);
            return; // Pour éviter d'avoir 2 sauts de ligne à la fin du test
        }
        else if (vCommandWord.equals("ramasser"))
        {
            int vTakeExecution = vPlayer.take(vCommand);
            if (vTakeExecution == 0)
            {
                Item vItem = vPlayer.getInventory().getItems().get(vCommand.getSecondWord());
                this.aGui.println("Vous avez ramassé : " + vCommand.getSecondWord());
                if (!vItem.getDescription().equals(""))
                    this.aGui.println(vItem.getDescription());
            }
            else if (vTakeExecution == 1)
                this.aGui.println("Ramasser quoi ?");
            else if (vTakeExecution == 2)
                this.aGui.println("Mais de quel item parlez-vous ?");
            else if (vTakeExecution == 3)
            {
                this.aGui.println("Trop de valeur dans ton inventaire...");
                this.aGui.println("Tu ne peux pas dépasser $" + vPlayer.getMaxValue());
            }
        }
        else if (vCommandWord.equals("lâcher"))
        {
            int vDropExecution = vPlayer.drop(vCommand);
            if (vDropExecution == 0)
                this.aGui.println("Vous avez lâché : " + vCommand.getSecondWord());
            else if (vDropExecution == 1)
                this.aGui.println("Lâcher quoi ?");
            else if (vDropExecution == 2)
                this.aGui.println("Mais de quel item parlez-vous ?");
        }
        else if (vCommandWord.equals("inventaire"))
            this.aGui.println(vPlayer.getInventoryString(vCommand));
        else
        {
            System.out.println("Erreur du programmeur : commande non reconnue !");
            this.endGame();
        }
        vPlayer.addNumberAction();
        if (vPlayer.getNumberAction() >= this.aMaxAction)
        {
            this.aGui.println("Perdu !!");
            this.aGui.println("Nombre d'actions possibles dépassé");
            this.endGame();
        }
        this.aGui.println("");
    } // processCommand(final Command pCommand)
    
    /**
     * Affiche une aide au joueur.
     */
    private void printHelp(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            this.aGui.println("Observez mieux !");
            this.aGui.println("Vous pouvez toujours demander à des passants.");
            this.aGui.println("");
            this.aGui.println("Les commandes sont :");
            this.aGui.println(aParser.getCommandList());
        }
        else
            this.aGui.println("Cette commande ne prend pas de deuxième mot");
    } // printHelp(final Command pCommand)
    
    /**
     * Affiche les informations
     * de la Room actuelle.
     */
    private void look(final Command pCommand)
    {
        if (pCommand.hasSecondWord())
        {
            this.aGui.println("Vous ne savez pas encore regarder quelque chose en particulier");
        }
        else
        {
            Room vPlayerCurrentRoom = this.aListPlayer.get(0).getCurrentRoom();
            this.aGui.println(vPlayerCurrentRoom.getLongDescription());
        }
    } // look(final Command pCommand)
    
    /**
     * Teste un fichier.
     */
    private void test(final Command pCommand)
    {
        if (pCommand.hasSecondWord())
        {
            Scanner vSc;
            String vFileName = "Tests/" + pCommand.getSecondWord() + ".txt";
            try
            {
                vSc = new Scanner(new File(vFileName));
                while (vSc.hasNextLine())
                {
                    interpretCommand(vSc.nextLine());
                }
                vSc.close();
            }
            catch(final FileNotFoundException pFNFE)
            {
                this.aGui.println("Fichier non trouvé");
            }
        }
        else
            this.aGui.println("Tester quoi ?");
    } // test(final Command pCommand)
    
    /**
     * Le joueur quitte la partie.
     */
    private void quit(final Command pCommand)
    {
        if (pCommand.hasSecondWord())
            this.aGui.println("Quitter quoi ?");
        else
            this.endGame();
    } // quit(final Command pCommand)
    
    /**
     * Termine la partie.
     */
    private void endGame()
    {
        this.aGui.println("Merci d'avoir joué. A bientôt!");
        this.aGui.enable(false);
    } // endGame()
} //  GameEngineEngine
