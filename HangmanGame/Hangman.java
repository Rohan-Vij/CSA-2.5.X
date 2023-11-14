import java.util.Scanner;

class Hangman {
    private Player player1;
    private Player player2;
    private Board board;
    private boolean ended;

    public Hangman() {
        restart();
    }

    public void restart() {
        player1 = new Player(getInput("Player 1's Name > "));
        player2 = new Player(getInput("Player 2's Name > "));
        board = new Board();
        ended = false;
    }

    private String getInput(String prompt) {
        Scanner scanner = new Scanner(System.in);
        System.out.print(prompt);
        return scanner.nextLine();
    }

    public void play() {
        int turn = 0;
        while (true) {
            boolean guessCorrectly = doTurn(turn);
            if (ended) break;
            if (!guessCorrectly) turn = (turn + 1) % 2;
        }

        printScores();
    }

    public boolean doTurn(int turn) {
        Player player = (turn == 0) ? player1 : player2;
        System.out.println(player.getName() + "'s Turn.");
        System.out.println("Current state: " + board.getState());

        boolean isLetter;
        while (true) {
            String typeGuess = getInput("Guess letter or whole phrase? (l/p) > ").toLowerCase();
            if (typeGuess.equals("l") || typeGuess.equals("p")) {
                isLetter = typeGuess.equals("l");
                break;
            }
        }

        if (isLetter) {
            char guess = getInput("Guess your letter > ").charAt(0);
            int score = guessLetter(guess);
            player.addScore(score);

            if (board.isComplete()) {
                System.out.println("Correct! You won.");
                ended = true;
            }

            return score > 0;
        }

        String guess = getInput("Guess the phrase > ");
        boolean isCorrect = guessPhrase(guess);

        if (isCorrect) {
            System.out.println("Correct! You won.");
            player.addScore(10);
            ended = true;
            return true;
        }

        System.out.println("Incorrect guess!");
        return false;
    }

    public int guessLetter(char letter) {
        StringBuilder state = new StringBuilder(board.getState());
        int numLettersGot = 0;

        for (int i = 0; i < state.length(); i++) {
            if (board.guessLetter(letter, i)) {
                state.setCharAt(i, letter);
                numLettersGot++;
            }
        }

        board.setState(state.toString());
        return numLettersGot;
    }

    public boolean guessPhrase(String text) {
        if (board.isPhraseCorrect(text)) {
            board.setState(text);
            return true;
        }

        return false;
    }

    public void printScores() {
        System.out.println(player1.getName() + " had score: " + player1.getScore());
        System.out.println(player2.getName() + " had score: " + player2.getScore());
    }

    public Board getBoard() {
        return board;
    }

    public boolean hasEnded() {
        return ended;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
