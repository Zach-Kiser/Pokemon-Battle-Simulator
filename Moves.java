
public class Moves {

    private String name;
    private int attack;
    
    public Moves(int type, int index) {
        if (type == 0) {
            if (index == 0) {
                name = "Tackle";
                attack = 20;
            } else if (index == 1) {
                name = "Thunderbolt";
                attack = 30;
            } else if (index == 2) {
                name = "Iron Tail";
                attack = 20;
            }
            
        } else if (type == 1) {
            if (index == 0) {
                name = "Tackle";
                attack = 20;
            } else if (index == 1) {
                name = "Razor Leaf";
                attack = 30;
            } else if (index == 2) {
                name = "Earthquake";
                attack = 40;
            }
            
        } else if (type == 2) {
            if (index == 0) {
                name = "Tackle";
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
}
