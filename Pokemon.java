public class Pokemon {

    Moves[] moves = new Moves[3];
    private int type;
    private String name;
    private int HP = 100;
    private boolean isFainted = false;
    private final static int tackle = 50;

    public Pokemon(String name, int type) {
        this.type = type;
        this.name = name;
        for (int i = 0; i < moves.length; i++) {
            moves[i] = new Moves(type, i);
        }    
    }

    // Needs to be finished! Needs the class for the moves array, this only uses
    // "tackle" with 20 damage.
    public boolean takeDamage(Moves move) {
        double chance = Math.random() * (10 - 1 - 1);
        if (chance <= 6) {
            HP = HP - move.getMoveAttack();
            if (HP <= 0) {
                isFainted = true;
                return true;
            }
        }
        return false;
    }

    

    public boolean getIsFainted() {
        return isFainted;
    }

    public int getHP() {
        return HP;
    }

    public String getName() {
        return name;
    }

}
