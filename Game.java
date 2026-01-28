public class Game
{
    private UserInterface aGui;
    private GameEngine aEngine;

    /**
     * Créer le jeu et initialiser sa map interne.
     * Créer l'interface et y accéder.
     */
    public Game()
    {
        this.aEngine = new GameEngine();
        this.aGui = new UserInterface(this.aEngine);
        this.aEngine.setGUI(this.aGui);
    } // Game()
} // Game