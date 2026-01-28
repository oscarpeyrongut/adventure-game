import java.util.StringTokenizer;

public class Parser 
{
    private CommandWords aValidCommands;

    /**
     * Constructeur par defaut
     * qui cree les 2 objets prévus pour les attributs.
     */
    public Parser() 
    {
        this.aValidCommands = new CommandWords();
    } //  Parser()

    /**
     * @return La prochaine commande de l'utilisateur.
     */
    public Command getCommand(final String pInputLine) 
    {
        String vWord1 = null;
        String vWord2 = null;

        StringTokenizer tokenizer = new StringTokenizer(pInputLine);

        if ( tokenizer.hasMoreTokens() )
            vWord1 = tokenizer.nextToken();
        else
            vWord1 = null;

        if ( tokenizer.hasMoreTokens() )
            vWord2 = tokenizer.nextToken();
        else
            vWord2 = null;

        if ( this.aValidCommands.isCommand( vWord1 ) )
        {
            return new Command( vWord1, vWord2 );
        }
        else
            return new Command( null, null );
    } //  getCommand()
    
    /**
     * @return une liste des commandes valides.
     */
    public String getCommandList()
    {
        return aValidCommands.getCommandList();
    }//  getCommandList()
} //  Parser
