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
        System.out.println("Select a move to use: ");
        for (int i = 0; i < 3; i++) {
            System.out.println(i + " " + playerPokemon.moves[i].getMoveName());
        }
        System.out.println("Please input the corresponding number and "
                + "then press ENTER.");

        Scanner input = new Scanner(System.in);
        String line = input.nextLine();
        int moveToUse = Integer.parseInt(line);
        Moves move = playerPokemon.moves[moveToUse];
        
        
        System.out.println(playerName + "'s " + playerPokemon.getName() 
            + " used " + move.getMoveName() + "!");
        System.out.println("The enemy " + opponentPokemon.getName() 
            + " took " + move.getMoveAttack() + " damage!");
        System.out.println("[Type anything to continue]");
        
        input.nextLine();
        input.close();
       
        opponentPokemon.takeDamage(playerPokemon.moves[moveToUse]);
        isPlayerTurn = false;
    }

    public static void opponentTurn() {
        int random = (int) (Math.random() * (3 - 1) + 1);
        Moves move = opponentPokemon.moves[random];
        playerPokemon.takeDamage(move);
        System.out.println("The enemy " + opponentPokemon.getName() + " used "
                + move.getMoveName() + "!");
        System.out.println(playerName + "'s " + playerPokemon.getName() 
            + " took " + move.getMoveAttack() + " damage!");
        System.out.println("[Type anything to continue]");
        Scanner input = new Scanner(System.in);
        input.nextLine();
        isPlayerTurn = true;
    }
    
    public static void displayVisuals() {
        // Output a block of text to differentiate different game screens.
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 500; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        // Output a border between the player and the enemy Pokemon.
        String[] border = new String[20];
        for (int j = 0; j < 20; j++) {
            if (j == 10) {
                border[j] = "VS";
            } else {
                border[j] = "*";
            }
        }
        
        outputHelper(playerPokemon.toString().split("\n"), 
                border, opponentPokemon.toString().split("\n"));
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
                
                System.out.print("\u001B[32m" + text2[i]);
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
        
        
        
        System.out.println("Choose a Pokemon to add to your team!"
                + " (Type the corresponding number and press return/enter)");
        
        int pokemon1 = Integer.parseInt(input.nextLine());
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
        
        playerPokemon = new Pokemon(pokemon1Name, pokemon1);
        opponentPokemon = new Pokemon(opponentPokemonName, opponentPokemonNum);
                
        
        while (checkGameStatus()) {
            displayVisuals();
            playerTurn();
            displayVisuals();
            opponentTurn();
        }
    }
}
