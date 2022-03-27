public class Pokemon {

    Moves[] moves = new Moves[3];
    private int type;
    private String name;
    private String image;
    private int HP = 100;
    private int previousHP = 100;
    private boolean isFainted = false;
//    private final static int tackle = 50;

    public Pokemon(String name, int type) {
        this.type = type;
        this.name = name;
        for (int i = 0; i < moves.length; i++) {
            moves[i] = new Moves(type, i);
        }
        if (this.name.equals("Pikachu")) {
            image = PokemonUtil.PIKACHU;
        } else if (this.name.equals("Bulbasaur")) {
            image = PokemonUtil.BULBASAUR;
        } else if (this.name.equals("Squirtle")) {
            image = PokemonUtil.SQUIRTLE;
        }
    }

    // 60% chance that the Pokemon will take damage.
    // Return true if the Pokemon took damage, false if not.
    public boolean takeDamage(Moves move) {
        double chance = Math.random() * (10 - 1 - 1);
        if (chance <= 6) {
            
            // Store the previous HP so that you can get the difference later.
            previousHP = HP;
            
            // Gets the effectiveness of a move based on type matchups
            // and multiples the damage accordinly.
            double multiplier = checkMoveEffectiveness(move);

            HP = (int) (HP - (move.getMoveAttack() * multiplier));
            if (HP <= 0) {
                isFainted = true;
            }
            return true;
        }
        return false;
    }

    
    // Return whether move was not very effective or super effective.
    public double checkMoveEffectiveness(Moves move) {
        double returnNum = 1; 
        if (move.getMoveType() == 0) {
            if (name.equals("Pikachu")) {
                returnNum = 0.5;
                System.out.println("The move was not very effective...");
            } else if (name.equals("Squirtle")) {
                returnNum = 2;
                System.out.println("The move was super effective!");
            } else if (name.equals("Bulbasaur")) {
                returnNum = 0.5;
                System.out.println("The move was not very effective...");
            } 
        } else if (move.getMoveType() == 1) {
            if (name.equals("Pikachu")) {
                returnNum = 1;
            } else if (name.equals("Squirtle")) {
                returnNum = 2;
                System.out.println("The move was super effective!");
            } else if (name.equals("Bulbasaur")) {
                returnNum = 0.5;
                System.out.println("The move was not very effective...");
            } 
        } else if (move.getMoveType() == 2) {
            if (name.equals("Pikachu")) {
                returnNum = 0.5;
                System.out.println("The move was not very effective...");
            } else if (name.equals("Squirtle")) {
                returnNum = 0.5;
                System.out.println("The move was not very effective...");
            } else if (name.equals("Bulbasaur")) {
                returnNum = 0.5;
                System.out.println("The move was not very effective...");
            } 
        }
        return returnNum;
    }
    
    
    

    public boolean getIsFainted() {
        return isFainted;
    }

    public int getHP() {
        return HP;
    }
    
    public int getPreviousHP() {
        return previousHP;
    }

    public String getName() {
        return name;
    }
    
    public String toString() {
        return image;
    }    

}
