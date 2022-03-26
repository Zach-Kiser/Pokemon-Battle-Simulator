
public class Pokemon {


  private String name;  
  private int HP = 100;
  private boolean isFainted = false;
  private final static int tackle = 20;
  
  public Pokemon(String name) {
      this.name = name;
  }
  
  
  
  // Needs to be finished! Needs the class for the moves array, this only uses "tackle" with 20 damage.
  public boolean attacked() {
      double chance = Math.random()*(10 - 1 - 1);
      if (chance <= 6) {
          HP = HP - tackle;
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
