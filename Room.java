import java.util.HashMap;
import java.util.Set;

public class Room
{
    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private ItemList aItems;
    
    /**
     * Crée une room décrite par la chaîne 'description'.
     * Au départ, il n'éxiste aucune sortie.
     * 'description' est une chaîne comme 'une cuisine' ou
     * 'une cour de jardin'.
     */
    public Room(final String pDescription, final String pImage)
    {
        this.aDescription = pDescription;
        this.aExits = new HashMap<String, Room>();
        this.aImageName = pImage;
        this.aItems = new ItemList();
    } // Room(final String pDescription, final String pImage, final Item pItem)
    
    /**
     * Définit une sortie pour cette room.
     * @param pDirection La direction de la sortie.
     * @param pNeighbour La salle dans la direction donnée.
     */
    public void setExit(final String pDirection, final Room pNeighbour)
    {
        this.aExits.put(pDirection, pNeighbour);
    } // setExit(final String pDirection, final Room pNeighbour)
    
    /**
     * @return La description de la room
     * (telle que définie par le constructeur).
     */
    public String getShortDescription()
    {
        return this.aDescription;
    } // getShortDescription()
    
    /**
     * Renvoie une description détaillée de cette piéce
     * sous la forme :
     * Vous êtes dans la cuisine.
     * Sorties : nord ouest
     * @return Une description de la room, avec les sorties.
     */
    public String getLongDescription()
    {
        return "Vous êtes " + this.getShortDescription() + ".\n"
                + this.getItemsString()
                + this.getExitString();
    } // getLongDescription()
    
    /**
     * Renvoie la room atteinte si nous nous déplaçons
     * dans la direction 'direction'. S'il n'y a pas de room
     * dans cette direction, renvoie null.
     */
    public Room getExit(final String pDirection)
    {
        return this.aExits.get(pDirection);
    } // getExit(final String pDirection)
    
    /**
     * Renvoie une description des sorties de la
     * room, par exemple, "Sorties : nord ouest".
     * @return Une description des sorties possibles.
     */
    public String getExitString()
    {
        String vReturnString = "Sorties :";
        Set<String> vKeys = this.aExits.keySet();
        for(String vExit: vKeys){vReturnString += " " + vExit;}
        return vReturnString;
    } // getExitString()
    
    /**
     * @return Une String décrivant le nom de l'image de la room.
     */
    public String getImageName()
    {
        return this.aImageName;
    } // getImageName()
    
    /**
     * @return La liste d'items de la pièce.
     */
    public ItemList getItems()
    {
        return this.aItems;
    }
    
    /**
     * @return Une String décrivant les items de la room.
     */
    public String getItemsString()
    {   
        if (this.aItems.getItems().isEmpty()) return "Aucun item ici\n";
        String vStr = "Items : ";
        boolean isFirst = true;
        for(Item vItem: this.aItems.getItems().values())
        {
            if (isFirst)
            {
                isFirst = false;
            }
            else
                vStr += "           ";
            vStr += vItem.getName()
                 + " : $" + vItem.getPrice()
                 + "\n";
        }
        return vStr;
    } // getItemsShortString()
    
    public boolean isExit(final Room pRoom)
    {
        return this.aExits.containsValue(pRoom);
    } // isExit(final Room pRoom)
} //  Room
