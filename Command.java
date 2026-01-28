public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    /**
     * Initialise les attributs :
     * le mot de commande et le deuxième mot.
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    } // Command(final String pCommandWord, final String pSecondWord)
    
    /**
     * @return le mot de commande.
     */
    public String getCommandWord()
    {
        return this.aCommandWord;
    } // getCommandWord()
    
    /**
     * @return Le deuxième mot.
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    } // getSecondWord()
    
    /**
     * @return L'existence du deuxième mot.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    } // hasSecondWord()
    
    /**
     * @return L'inexistence du mot de commande.
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == null;
    } // isUnknown()
    
} // Command
