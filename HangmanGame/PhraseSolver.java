/*
 * Activity 2.5.2
 *
 *  The PhraseSolver class the PhraseSolverGame
 */
import java.util.Scanner;
  
public class PhraseSolver
{
  /* your code here - attributes */
  private Player player1; 
  private Player player2; 
  private Board game; 
  private int playerGuessPhrase;

  /* your code here - constructor(s) */
  public PhraseSolver() {
    player1 = new Player();
    player2 = new Player();
    game = new Board();
  } 

  /* your code here - accessor(s) */
  
  /* your code here - mutator(s)  */

  public void play()
  {
    boolean solved = false;
    int currentPlayer = 1;

    Scanner input = new Scanner(System.in);
    
    while (!solved) 
    {
      /* your code here - game logic */
      String guess = "";

      while (currentPlayer == 1) {
          System.out.println("Current player information:");
          System.out.println("  Name: " + player1.getName());
          System.out.println("  Points: " + player1.getPoints());

          System.out.println("\nPhrase solved " + game.getSolvedPhrase());
          System.out.println("Point value of next guess: " + game.getCurrentLetterValue());

          System.out.println("\nType in a guess(type in a letter, for guessing theentire phrase or when it is revealed, type in \" try phrase\"): ");

          guess = input.nextLine();
          boolean isCorrect = game.guessLetter(guess);
          if (isCorrect) {
            System.out.println("Correct!");
            System.out.println("Adding " + game.getCurrentLetterValue() + " points!");
            game.setLetterValue();

            if (game.getSolvedPhrase().indexOf("_") == -1) {
                solved = true;
                System.out.println("Game over! You have correctly guessed the phrase:");
                System.out.print(game.getSolvedPhrase());

                if (player1.getPoints() > player2.getPoints()) {
                    System.out.println(player1.getName() + " wins with the highestscore!");
                } else if (player1.getPoints() < player2.getPoints()) {
                    System.out.println(player1.getName() + " wins with the highestscore!");
                } else {
                    System.out.println("It's a tie between " + player1.getName() + " and " + player2.getName() + "!");
                }
            }
          }
      }
      
      
      /* your code here - determine how game ends */
      solved = true; 
    } 
   
  }
  
}