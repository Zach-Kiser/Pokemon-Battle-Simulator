import java.util.ArrayList;
import java.util.Scanner;

public class GameDriver {
    private static Pokemon playerPokemon;
    private static Pokemon opponentPokemon;
    private static boolean isPlayerTurn = true;
    private static int currentPlayerPokemon = 0;
    private static int currentOpponentPokemon = 0;
    private static boolean gameOver = false;
    private static String playerName = "Player";

    public static void playerTurn() {
        System.out.println("\u001B[0m" + "\t\t\tHP: " + playerPokemon.getHP() 
            + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tHP: " 
                + opponentPokemon.getHP());
        System.out.println("Select a move to use: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " " + playerPokemon.moves[i].getMoveName());
        }

        Scanner input = new Scanner(System.in);
        
        String line = "";
        while(!(line.equals("0") || line.equals("1") || 
                line.equals("2"))) {
            System.out.println("Please input the corresponding number and "
                    + "then press ENTER.");
            line = input.nextLine();
        }
        int moveToUse = Integer.parseInt(line);
        Moves move = playerPokemon.moves[moveToUse];
        
        
        for (int i = 0; i < 238; i++) {
            System.out.print("*");
        }
        System.out.println();
        
        System.out.println(playerName + "'s " + playerPokemon.getName() 
            + " used " + move.getMoveName() + "!");
        
        boolean didMoveHit = opponentPokemon.
                takeDamage(playerPokemon.moves[moveToUse]);
        
        if (didMoveHit) {
            System.out.println("The enemy " + opponentPokemon.getName() 
            + " took " + (opponentPokemon.getPreviousHP() 
                    - opponentPokemon.getHP()) + " damage!");
        } else {
            System.out.println("The move missed!");
        }
        System.out.println("[Type anything to continue]");
        input.nextLine();
        
        isPlayerTurn = false;
    }

    public static void opponentTurn() {
        System.out.println("\u001B[0m"+ "\t\t\tHP: " + playerPokemon.getHP() 
        + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tHP: " 
            + opponentPokemon.getHP());
        int random = (int) (Math.random() * (3 - 1) + 1);
        Moves move = opponentPokemon.moves[random];
        
        System.out.println("\u001B[0m"+ "The enemy " 
                + opponentPokemon.getName() + " used " 
                + move.getMoveName() + "!");
        
        boolean didMoveHit = playerPokemon.takeDamage(move);

        if (didMoveHit) {
            System.out.println(playerName + "'s " + playerPokemon.getName() 
                + " took " + (playerPokemon.getPreviousHP() 
                        - playerPokemon.getHP()) + " damage!");
        } else {
            System.out.println("The attack missed!");
        }
        System.out.println("[Type anything to continue]");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        isPlayerTurn = true;
    }
    
    public static void displayVisuals() {
        // Output a block of text to differentiate different game screens.
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 238; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        for (int i = 0; i < 16; i++) {
            System.out.println();
        }
        
        System.out.println();
        System.out.println("\t\t" + playerName + "'s " + playerPokemon.getName()
                + "\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t Enemy's " 
                + opponentPokemon.getName());
        
        
        // Output a border between the player and the enemy Pokemon.
        String[] border = new String[28];
        for (int j = 0; j < 28; j++) {
            if (j == 10) {
                border[j] = "VS";
            } else {
                border[j] = "*";
            }
        }
        
        outputHelper(playerPokemon.toString().split("\n"), 
                border, opponentPokemon.toString().split("\n"));
        
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
        
    }
    

    

    
    public static boolean checkGameStatus() {
        if (playerPokemon.getIsFainted()) {
            System.out.println("YOU LOST");
            System.exit(1);
        }
        if (opponentPokemon.getIsFainted()) {
            System.out.println("YOU WON!!!");
            System.exit(1);
        }
        return true;
    }

    
    public static void outputHelper(String[] text1, String[] text2,
            String[] text3) {

        // Get the max height and width dimensions to format all pokemon.
        int maxLineWidth = 0;
        int maxHeight = 0;
        int height = 0;
        
        for (int i = 0; i < text1.length; i++) {
            if (text1[i].length() > maxLineWidth) {
                maxLineWidth = text1[i].length();
            }
            height++;
        }
        
        
        if (height > maxHeight) {
            maxHeight = height;
        }
        height = 0;
        
        for (int i = 0; i < text2.length; i++) {
            if (text2[i].length() > maxLineWidth) {
                maxLineWidth = text2[i].length();
            }
            height++;
        }
        
        if (height > maxHeight) {
            maxHeight = height;
        }
        height = 0;
        
        
        for (int i = 0; i < text3.length; i++) {
            if (text3[i].length() > maxLineWidth) {
                maxLineWidth = text3[i].length();
            }
            height++;
        }
        
        if (height > maxHeight) {
            maxHeight = height;
        }
        height = 0;
        
        
        
        // Print characters side by side.
        for (int i = 0; i < maxHeight; i++) {
            
            //First check if this character's height has already been output.
            int firstPokemonHeight = text1.length;
            
            if (i >= firstPokemonHeight) {
                for (int j = 0; j < maxLineWidth; j++) {
                    System.out.print(" ");
                }
            } else {
            
                
                // Check if character's width has been completely output.
                int firstPokemonLineWidth = text1[i].length();
                
                System.out.print("\u001B[33m" + text1[i]);
                while (firstPokemonLineWidth < maxLineWidth) {
                    System.out.print(" ");
                    firstPokemonLineWidth++;
                }
            }

            
            
            
            
            
            //First check if this character's height has already been output.
            int secondPokemonHeight = text2.length;
            
            if (i >= secondPokemonHeight) {
                for (int j = 0; j < maxLineWidth; j++) {
                    System.out.print(" ");
                }
            } else {
            
            
                // Check if character's width has been completely output.
                int secondPokemonLineWidth = text2[i].length();
                
                System.out.print("\u001B[0m" + text2[i]);
                while (secondPokemonLineWidth < maxLineWidth) {
                    System.out.print(" ");
                    secondPokemonLineWidth++;
                }
            }
            
            
            //First check if this character's height has already been output.
            int thirdPokemonHeight = text3.length;
            
            if (i >= thirdPokemonHeight) {
                for (int j = 0; j < maxLineWidth; j++) {
                    System.out.print(" ");
                }
            } else {
                
                
                // Check if character's width has been completely output.
                int thirdPokemonLineWidth = text3[i].length();
                
                System.out.print("\u001B[34m" + text3[i]);
                while (thirdPokemonLineWidth < maxLineWidth) {
                    System.out.print(" ");
                    thirdPokemonLineWidth++;
                }
                
            }
            
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println(PokemonUtil.LOGO);
        System.out.println("Welcome to the Pokemon Battle Simulator! "
                + "[Press anything to continue]");
        input.nextLine();
        System.out.println("Please enter your name and press ENTER"
                + " to continue:");
        playerName = input.nextLine();
        

        String[] firstPokemon = PokemonUtil.PIKACHU.split("\n");
        String[] secondPokemon = PokemonUtil.BULBASAUR.split("\n");
        String[] thirdPokemon = PokemonUtil.SQUIRTLE.split("\n");
        

        outputHelper(firstPokemon, secondPokemon, thirdPokemon);
        
        System.out.println("\u001B[0m" + "\t\t\t 1 \t\t\t\t\t\t\t\t 2 "
                + "\t\t\t\t\t\t\t\t\t\t\t 3");
        System.out.println();
        System.out.println();
        
        
        
        String line = "";
        while(!(line.equals("1") || line.equals("2") || 
                line.equals("3"))) {
            System.out.println("Choose a Pokemon to add to your team!"
                    + " (Type the corresponding number "
                    + "and press return/enter)");
            line = input.nextLine();
        }
        
        int pokemon1 = Integer.parseInt(line);
        String pokemon1Name = "";
        if (pokemon1 == 1) {
            pokemon1Name = "Pikachu";
        } else if (pokemon1 == 2) {
            pokemon1Name = "Bulbasaur";
        } else if (pokemon1 == 3) {
            pokemon1Name = "Squirtle";
        }
        
        
        
        
        
        // Randomly sets the opposing Pokemon.
        int opponentPokemonNum = (int) (Math.random() * (3 - 1) + 1);
        String opponentPokemonName = "";
        
        if (opponentPokemonNum == 1) {
            opponentPokemonName = "Pikachu";
        } else if (opponentPokemonNum == 2) {
            opponentPokemonName = "Bulbasaur";
        } else if (opponentPokemonNum == 3) {
            opponentPokemonName = "Squirtle";
        }
        
        playerPokemon = new Pokemon(pokemon1Name, pokemon1 - 1);
        opponentPokemon = new Pokemon(opponentPokemonName, 
                opponentPokemonNum - 1);
                
        // Main game loop, displays the game screen and alternates between
        // the player and the opponent.
        while (checkGameStatus()) {
            displayVisuals();
            playerTurn();
            checkGameStatus();
            displayVisuals();
            opponentTurn();
        }
    }
}
