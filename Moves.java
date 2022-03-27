
public class Moves {

    private String name;
    private int attack;
    private int type;
    
    public Moves(int type, int index) {
        this.type = type;
        if (type == 0) {
            if (index == 0) {
                name = "Thunder Punch";
                attack = 20;
            } else if (index == 1) {
                name = "Thunderbolt";
                attack = 30;
            } else if (index == 2) {
                name = "Volt Tackle";
                attack = 20;
            }
            
        } else if (type == 1) {
            if (index == 0) {
                name = "Vine Whip";
                attack = 20;
            } else if (index == 1) {
                name = "Razor Leaf";
                attack = 30;
            } else if (index == 2) {
                name = "Solar Beam";
                attack = 40;
            }
            
        } else if (type == 2) {
            if (index == 0) {
                name = "Bubble Beam";
                attack = 20;
            } else if (index == 1) {
                name = "Water Gun";
                attack = 30;
            } else if (index == 2) {
                name = "Aqua Jet";
                attack = 40;
            }
        }
    }  
    
    public int getMoveAttack() {
        return attack;
    }
    
    public String getMoveName() {
        return name;
    }
    
    public int getMoveType() {
        return type;
    }
}
