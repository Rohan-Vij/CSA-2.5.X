/*
 * Activity 2.5.2
 * 
 * A Player class the PhraseSolverGame
 */
import java.util.Scanner;

public class Player
{
  /* your code here - attributes */
  private String name;
  private int points;

  /* your code here - constructor(s) */ 
  public Player(String userName) {
      name = userName;
      points = 0;
  }


  /* your code here - accessor(s) */ 
  public String getName() {
      return name;
  }

  public int getPoints() {
      return points;
  }

  /* your code here - mutator(s) */ 
  public void setName(String newName) {
      name = newName;
  }

  public void setpoints(int newpoints) {
      name = newpoints;
  }
}