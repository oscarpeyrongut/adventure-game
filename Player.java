import java.util.Stack;
import java.util.HashMap;

public class Player
{
    private int aID;
    private String aName;
    private Room aCurrentRoom;
    private Stack<Room> aRoomHistoric;
    private ItemList aInventory;
    private int aMaxValue;
    private int aNumberAction;
    
    /**
     * Créer un joueur doté
     * d'un ID, d'un nom,
     * d'une Room dans laquelle il se trouve,
     * d'un historique des rooms visitées
     * et d'un inventaire d'items.
     */
    public Player(final int pID, final String pName, final Room pCurrentRoom)
    {
        this.aID = pID;
        this.aName = pName;
        this.aCurrentRoom = pCurrentRoom;
        this.aRoomHistoric = new Stack<>();
        this.aInventory = new ItemList();
        this.aMaxValue = 10;
        this.aNumberAction = 0;
    } // Player()
    
    /**
     * @return La Room actuelle du joueur.
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    } // getCurrentRoom()
    
    /**
     * @return L'historique des rooms visitées par le joueur.
     */
    public Room getRoomHistoric()
    {
        return this.aCurrentRoom;
    } // getRoomHistoric()
    
    /**
     * @return Une String comportant
     * une description longue de la room actuelle du joueur.
     */
    public String getLocationInfo()
    {
        return this.aCurrentRoom.getLongDescription();
    } // getLocationInfo()
    
    /**
     * @return L'inventaire d'items du joueur.
     */
    public ItemList getInventory()
    {
        return this.aInventory;
    } // getInventory()
    
    /**
     * @return La valeur maximale que le joueur peut contenir dans son inventaire
     */
    public int getMaxValue()
    {
        return this.aMaxValue;
    } // getMaxValue()
    
    public int getNumberAction()
    {
        return this.aNumberAction;
    } // getNumberAction()
    
    public void addNumberAction()
    {
        this.aNumberAction ++;
    } // addNumberAction()
    
    /**
     * Essai de déplacement dans une direction.
     * Si une sortie existe, entrer dans la nouvelle room,
     * sinon afficher un message d'erreur.
     */
    public int goRoom(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            return 1;
        }
        String vDirection = pCommand.getSecondWord();
        Room vNextRoom = this.aCurrentRoom.getExit(vDirection);
        if (vNextRoom == null)
        {
            return 2;
        }
        else
        {
            this.aRoomHistoric.push(this.aCurrentRoom);
            this.executeRoomChangement(vNextRoom);
            return 0;
        }
    } // goRoom(final Command pCommand)
    
    /**
     * Change de room après vérification de la possibilité de le faire.
     */
    private void executeRoomChangement(final Room pNextRoom)
    {
        this.aCurrentRoom = pNextRoom;
    } // executeRoomChangement(final Room pNextRoom)
    
    /**
     * Fais revenir le joueur à la room précédente.
     */
    public int back(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            if (!this.aRoomHistoric.empty()
                && this.aCurrentRoom.isExit(this.aRoomHistoric.peek()))
            {
                Room vFormerRoom = this.aRoomHistoric.pop();
                this.executeRoomChangement(vFormerRoom);
                return 0;
            }
            else
                return 1;
        }
        else
            return 2;
    } // back(final Command pCommand)
    
    /**
     * Attraper un item
     * placé dans la room actuelle au joueur.
     */
    public int take(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
            return 1;
        else
        {
            String vItemName = pCommand.getSecondWord();
            if (this.aCurrentRoom.getItems().getItems().containsKey(vItemName))
            {
                Item vItem = this.aCurrentRoom.getItems().getItems().get(vItemName);
                if (vItem.getPrice() + this.aInventory.getTotalValue() > this.aMaxValue)
                    return 3;
                else
                {
                    this.aInventory.addItem(vItem);
                    this.aCurrentRoom.getItems().removeItem(vItemName);
                    return 0;
                }
            }
            return 2;
        }
    } // take(final Command pCommand)
    
    /**
     * Lâcher un item contenu dans l'inventaire de joueur
     * dans la room actuelle.
     */
    public int drop(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
            return 1;
        else
        {
            String vItemName = pCommand.getSecondWord();
            if (this.aInventory.getItems().containsKey(vItemName))
            {
                Item vItem = this.aInventory.getItems().get(vItemName);
                this.aCurrentRoom.getItems().addItem(vItem);
                this.aInventory.removeItem(vItemName);
                return 0;
            }
            return 2;
        }
    } // take(final Command pCommand)
    
    /**
     * Affiche
     * "Hmmmm ! C'est bon le " + deuxième mot.
     */
    public int eat(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
        {
            return 1;
        }
        else if (pCommand.getSecondWord().equals("cookie"))
        {
            if (this.aInventory.getItems().containsKey("cookie"))
            {
                this.aInventory.removeItem("cookie");
                this.aMaxValue *= 2;
                return 0;
            }
            return 2;
        }
        return 3;
    } // eat(final Command pCommand)
    
    /**
     * @return String de l'inventaire
     */
    public String getInventoryString(final Command pCommand)
    {
        if (!pCommand.hasSecondWord())
            {
                if (!this.aInventory.getItems().isEmpty())
                {
                   return this.aInventory.getItemsString()
                            + "\nValeur totale : $"
                            + this.aInventory.getTotalValue()
                            + "\nValeur max : $"
                            + this.getMaxValue();
                }
                else
                    return "Aucun objet dans l'inventaire"
                            + "\nValeur max : $"
                            + this.getMaxValue();
            }
            else
                return "Cette commande ne prend pas de deuxième mot";
    } // getInventoryString(final Command pCommand)
}