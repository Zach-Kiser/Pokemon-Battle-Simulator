import java.util.ArrayList;
import java.util.Scanner;

public class GameDriver {
    ArrayList<Pokemon> playerTeam = new ArrayList<Pokemon>();
    ArrayList<Pokemon> opponentTeam;
    boolean isPlayerTurn = true;
    int currentPlayerPokemon = 0;
    int currentOpponentPokemon = 0;
    
    public void playerTurn() {
        // Check if player has at least one Pokemon that is not fainted.
        // If not, end the game.
        for(int i = 0; i < playerTeam.size(); i++) {
            if (!playerTeam.get(i).isFainted()) {
                break;
            }
            if (i == playerTeam.size() - 1) {
                System.out.println("YOU LOST");
            }
        }
        System.out.println("Select a move to use: ");
        System.out.prinln("1" + playerTeam.get(currentPlayerPokemon).
                getMove1());
        System.out.prinln("2" + playerTeam.get(currentPlayerPokemon).
                getMove2());
        System.out.prinln("3" + playerTeam.get(currentPlayerPokemon).
                getMove3());
        System.out.prinln("4" + playerTeam.get(currentPlayerPokemon).
                getMove4());
        System.out.println("Please input the corresponding number and "
                + "then press ENTER.");

        Scanner input = new Scanner(System.in);
        int moveToUse = Integer.parseInt(input.nextLine());
        opponentTeam.get(currentOpponentPokemon).damage(playerTeam.
                get(currentPlayerPokemon).getMove1Damage());
        isPlayerTurn = false;
    }
    
    public void opponentTurn() {
        Pokemon.POSSIBLE_MOVES()
        isPlayerTurn = true;
    }
    
    public void swapPokemon() {
        
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("\u001B[33m" + "                                  ,'\\\n"
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
                + "                                `'                            '-._|" + "\u001B[0m");
        System.out.println("Welcome to the Pokemon Battle Simulator! "
                + "[Press anything to continue]");
        input.nextLine();
        System.out.println("025");
        System.out.println("quu..__\n"
                + " $$$b  `---.__\n"
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
                + "                                   `:.:'\n"
                + "");
        System.out.println("001");
        System.out.println("                                           /\n"
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
                + " `\"^--'..'   '-`-^-'\"--    `-^-'`.''\"\"\"\"\"`.,^.`.--'");
        System.out.println("007");
        System.out.println("               _,........__\n"
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
                + "                                  `---.__,--.'");
        
        System.out.println("Choose a Pokemon to add to your team!"
                + " (Type the corresponding number and press return/enter)");
        int Pokemon1 = Integer.parseInt(input.nextLine());
        System.out.println("Choose a second Pokemon to add to your team!"
                + " (Type the corresponding number and press return/enter)");
        int Pokemon2 = Integer.parseInt(input.nextLine());
        playerTeam.append(new Pokemon());
        playerTeam.append(new Pokemon());
    }
}
