public class CommandWords
{
    private static final String aValidCommands[]
        = {"aller", "quitter", "aide"
            , "regarder", "manger", "reculer"
            , "tester", "ramasser", "lâcher", "inventaire"};

    public CommandWords()
    {} // CommandWords()

    /**
     * Vérifie si une String donnée est un mot de commande valide. 
     * @return true si la chaîne donnée est une commande valide,
     * false si ce n'est pas le cas.
     */
    public boolean isCommand( final String pString )
    {
        for (int vI=0; vI<this.aValidCommands.length; vI++)
        {
            if ( this.aValidCommands[vI].equals( pString ) )
                {return true;}
        }
        return false;
    } // isCommand( final String pString )
    
    /**
    * @return Toutes les commandes valides.
    */
    public String getCommandList()
    {
        String vStr = "    ";
        int vIterator = 0;
        for(String command: aValidCommands)
        {
            if (vIterator == 3)
            {
                vIterator = 0;
                vStr += "\n    ";
            }
            vStr += command + " ";
            vIterator ++;
        }  
        return vStr;
    } // getCommandList()
} // CommandWords
