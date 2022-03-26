import java.util.ArrayList;
import java.util.Scanner;

public class GameDriver {
    private static Pokemon playerPokemon;
    private static Pokemon opponentPokemon;
    private static boolean isPlayerTurn = true;
    private static int currentPlayerPokemon = 0;
    private static int currentOpponentPokemon = 0;
    private static boolean gameOver = false;

    public static void playerTurn() {
        System.out.println("Select a move to use: ");
        System.out.println(
                "1" + playerPokemon.getMove1());
        System.out.println(
                "2" + playerPokemon.getMove2());
        System.out.println(
                "3" + playerPokemon.getMove3());
        System.out.println(
                "4" + playerPokemon.getMove4());
        System.out.println("Please input the corresponding number and "
                + "then press ENTER.");

        Scanner input = new Scanner(System.in);
        int moveToUse = Integer.parseInt(input.nextLine());
        
        
        // Implement using the move, ex: the opponent taking damage.
        
        
        isPlayerTurn = false;
    }

    public static void opponentTurn() {
        Pokemon.POSSIBLE_MOVES()
        isPlayerTurn = true;
    }
    
    public static void displayVisuals() {
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 500; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        System.out.println(playerPokemon);
        System.out.println();
        System.out.println("********************VS***********************");
        System.out.println();
        System.out.println(opponentPokemon);
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


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\u001B[33m"
                + "                                  ,'\\\n"
                + "    _.----.        ____         ,'  _\\   ___    ___     ____\n"
                + "_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.\n"
                + "\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |\n"
                + " \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |\n"
                + "   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |\n"
                + "    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |\n"
                + "     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |\n"
                + "      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |\n"
                + "       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |\n"
                + "        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |\n"
                + "                                `'                            '-._|"
                + "\u001B[0m");
        System.out.println("Welcome to the Pokemon Battle Simulator! "
                + "[Press anything to continue]");
        input.nextLine();
        System.out.println("1");
        System.out.println("\u001B[33m" + "quu..__\n" + " $$$b  `---.__\n"
                + "  \"$$b        `--.                          ___.---uuudP\n"
                + "   `$$b           `.__.------.__     __.---'      $$$$\"              .\n"
                + "     \"$b          -'            `-.-'            $$$\"              .'|\n"
                + "       \".                                       d$\"             _.'  |\n"
                + "         `.   /                              ...\"             .'     |\n"
                + "           `./                           ..::-'            _.'       |\n"
                + "            /                         .:::-'            .-'         .'\n"
                + "           :                          ::''\\          _.'            |\n"
                + "          .' .-.             .-.           `.      .'               |\n"
                + "          : /'$$|           .@\"$\\           `.   .'              _.-'\n"
                + "         .'|$u$$|          |$$,$$|           |  <            _.-'\n"
                + "         | `:$$:'          :$$$$$:           `.  `.       .-'\n"
                + "         :                  `\"--'             |    `-.     \\\n"
                + "        :##.       ==             .###.       `.      `.    `\\\n"
                + "        |##:                      :###:        |        >     >\n"
                + "        |#'     `..'`..'          `###'        x:      /     /\n"
                + "         \\                                   xXX|     /    ./\n"
                + "          \\                                xXXX'|    /   ./\n"
                + "          /`-.                                  `.  /   /\n"
                + "         :    `-  ...........,                   | /  .'\n"
                + "         |         ``:::::::'       .            |<    `.\n"
                + "         |             ```          |           x| \\ `.:``.\n"
                + "         |                         .'    /'   xXX|  `:`M`M':.\n"
                + "         |    |                    ;    /:' xXXX'|  -'MMMMM:'\n"
                + "         `.  .'                   :    /:'       |-'MMMM.-'\n"
                + "          |  |                   .'   /'        .'MMM.-'\n"
                + "          `'`'                   :  ,'          |MMM<\n"
                + "            |                     `'            |tbap\\\n"
                + "             \\                                  :MM.-'\n"
                + "              \\                 |              .''\n"
                + "               \\.               `.            /\n"
                + "                /     .:::::::.. :           /\n"
                + "               |     .:::::::::::`.         /\n"
                + "               |   .:::------------\\       /\n"
                + "              /   .''               >::'  /\n"
                + "              `',:                 :    .'\n"
                + "                                   `:.:'\n" + "\u001B[0m"
                + "");
        System.out.println("2");
        System.out.println("\u001B[32m"
                + "                                           /\n"
                + "                        _,.------....___,.' ',.-.\n"
                + "                     ,-'          _,.--\"        |\n"
                + "                   ,'         _.-'              .\n"
                + "                  /   ,     ,'                   `\n"
                + "                 .   /     /                     ``.\n"
                + "                 |  |     .                       \\.\\\n"
                + "       ____      |___._.  |       __               \\ `.\n"
                + "     .'    `---\"\"       ``\"-.--\"'`  \\               .  \\\n"
                + "    .  ,            __               `              |   .\n"
                + "    `,'         ,-\"'  .               \\             |    L\n"
                + "   ,'          '    _.'                -._          /    |\n"
                + "  ,`-.    ,\".   `--'                      >.      ,'     |\n"
                + " . .'\\'   `-'       __    ,  ,-.         /  `.__.-      ,'\n"
                + " ||:, .           ,'  ;  /  / \\ `        `.    .      .'/\n"
                + " j|:D  \\          `--'  ' ,'_  . .         `.__, \\   , /\n"
                + "/ L:_  |                 .  \"' :_;                `.'.'\n"
                + ".    \"\"'                  \"\"\"\"\"'                    V\n"
                + " `.                                 .    `.   _,..  `\n"
                + "   `,_   .    .                _,-'/    .. `,'   __  `\n"
                + "    ) \\`._        ___....----\"'  ,'   .'  \\ |   '  \\  .\n"
                + "   /   `. \"`-.--\"'         _,' ,'     `---' |    `./  |\n"
                + "  .   _  `\"\"'--.._____..--\"   ,             '         |\n"
                + "  | .\" `. `-.                /-.           /          ,\n"
                + "  | `._.'    `,_            ;  /         ,'          .\n"
                + " .'          /| `-.        . ,'         ,           ,\n"
                + " '-.__ __ _,','    '`-..___;-...__   ,.'\\ ____.___.'\n"
                + " `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--'"
                + "\u001B[0m");
        System.out.println("3");
        System.out.println("\u001B[34m" + "               _,........__\n"
                + "            ,-'            \"`-.\n"
                + "          ,'                   `-.\n"
                + "        ,'                        \\\n"
                + "      ,'                           .\n"
                + "      .'\\               ,\"\".       `\n"
                + "     ._.'|             / |  `       \\\n"
                + "     |   |            `-.'  ||       `.\n"
                + "     |   |            '-._,'||       | \\\n"
                + "     .`.,'             `..,'.'       , |`-.\n"
                + "     l                       .'`.  _/  |   `.\n"
                + "     `-.._'-   ,          _ _'   -\" \\  .     `\n"
                + "`.\"\"\"\"\"'-.`-...,---------','         `. `....__.\n"
                + ".'        `\"-..___      __,'\\          \\  \\     \\\n"
                + "\\_ .          |   `\"\"\"\"'    `.           . \\     \\\n"
                + "  `.          |              `.          |  .     L\n"
                + "    `.        |`--...________.'.        j   |     |\n"
                + "      `._    .'      |          `.     .|   ,     |\n"
                + "         `--,\\       .            `7\"\"' |  ,      |\n"
                + "            ` `      `            /     |  |      |    _,-'\"\"\"`-.\n"
                + "             \\ `.     .          /      |  '      |  ,'          `.\n"
                + "              \\  v.__  .        '       .   \\    /| /              \\\n"
                + "               \\/    `\"\"\\\"\"\"\"\"\"\"`.       \\   \\  /.''                |\n"
                + "                `        .        `._ ___,j.  `/ .-       ,---.     |\n"
                + "                ,`-.      \\         .\"     `.  |/        j     `    |\n"
                + "               /    `.     \\       /         \\ /         |     /    j\n"
                + "              |       `-.   7-.._ .          |\"          '         /\n"
                + "              |          `./_    `|          |            .     _,'\n"
                + "              `.           / `----|          |-............`---'\n"
                + "                \\          \\      |          |\n"
                + "               ,'           )     `.         |\n"
                + "                7____,,..--'      /          |\n"
                + "                                  `---.__,--.'"
                + "\u001B[0m");

        
        
        
        
        
        
        System.out.println("Choose a Pokemon to add to your team!"
                + " (Type the corresponding number and press return/enter)");
        
        int Pokemon1 = Integer.parseInt(input.nextLine());
        String pokemon1Name = "";
        if (Pokemon1 == 1) {
            pokemon1Name = "Pikachu";
        } else if (Pokemon1 == 2) {
            pokemon1Name = "Bulbasaur";
        } else if (Pokemon1 == 3) {
            pokemon1Name = "Squirtle";
        }
        
        
        
        
        
        // Randomly sets the opposing Pokemon.
        double opponentPokemonNum = (int) (Math.random() * (3 - 1) + 1);
        String opponentPokemonName = "";
        
        if (opponentPokemonNum == 1) {
            opponentPokemonName = "Pikachu";
        } else if (opponentPokemonNum == 2) {
            opponentPokemonName = "Bulbasaur";
        } else if (opponentPokemonNum == 3) {
            opponentPokemonName = "Squirtle";
        }
        
        playerPokemon = new Pokemon(pokemon1Name);
        opponentPokemon = new Pokemon(opponentPokemonName);
        
        
        
        // Main game loop.
        displayVisuals();
        
//        while (checkGameStatus) {
//            playerTurn();
//            opponentTurn();
//        }
    }
}
