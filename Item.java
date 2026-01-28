public class Item
{
    private String aName;
    private String aDescription;
    private int aPrice;
    
    /**
     * Création d'un nouvel Item
     * constitué d'un nom, d'une description
     * et d'un prix.
     */
    public Item(final String pName, final String pDescription, final int pPrice)
    {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aPrice = pPrice;
    } // Item(final String pDescription, final int pPrice)
    
    /**
     * @return Le nom de l'item.
     */
    public String getName()
    {
        return this.aName;
    } // getName()
    
    /**
     * @return la description de l'item.
     */
    public String getDescription()
    {
        return this.aDescription;
    } // getDescription()
    
    /**
     * @return Le prix de l'item.
     */
    public int getPrice()
    {
        return this.aPrice;
    } // getPrice()
}