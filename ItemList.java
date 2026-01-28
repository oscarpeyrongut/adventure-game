import java.util.HashMap;

public class ItemList
{
    private HashMap<String, Item> aItems;
    private int aTotalValue;
    
    /**
     * Créer une nouvelle HashMap d'items référencée par leur noms.
     */
    public ItemList()
    {
        this.aItems = new HashMap<>();
        this.aTotalValue = 0;
    }
    
    /**
     * @return la HashMap des items.
     */
    public HashMap<String, Item> getItems()
    {
        return this.aItems;
    } // getImageName()
    
    /**
     * Ajoute un item.
     */
    public void addNewItem(final String pName, final String pDescription, final int pPrice)
    {
        this.aTotalValue += pPrice;
        this.aItems.put(pName, new Item(pName, pDescription, pPrice));
    } // addItem(final String pName, final String pDescription, final int pPrice)
    
    /**
     * Ajoute un item déja existant.
     */
    public void addItem(final Item pItem)
    {
        this.aTotalValue += pItem.getPrice();
        this.aItems.put(pItem.getName(), pItem);
    } // addItem(final Item pItem)
    
    /**
     * Retire un item.
     */
    public void removeItem(final String pName)
    {
        this.aTotalValue -= this.aItems.get(pName).getPrice();
        this.aItems.remove(pName);
    } // removeItem(final String pName)
    
    /**
     * @return La somme des valeurs des objets de la liste
     */
    public int getTotalValue()
    {
        return this.aTotalValue;
    } // getTotalValue()
    
    /**
     * @return String de la liste d'objet
     */
    public String getItemsString()
    {
        String vStr = "";
        boolean vIsFirst = true;
        int vI = 0;
        for (String vItemName : this.aItems.keySet())
        {
            if (!vIsFirst)
            {
                vStr += " ";
            }
            else
                vIsFirst = false;
            if (vI == 2)
            {
                vI = 0;
                vStr += "\n";
            }
            vStr += vItemName;
            vI ++;
        }
        return vStr;
    } // getItemsString()
}