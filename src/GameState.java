public class GameState {
    private volatile boolean isGameOver = false;
    private volatile int winnerNumber = -1;

    // Checks if the game is over and won
    public synchronized boolean isGameOver() {
        return isGameOver;
    }

    // Sets the game to be over and declares the winner
    public synchronized void setGameOver(boolean isGameOver) {
        this.isGameOver = isGameOver;
    }

    // Gets the winner number
    public synchronized int getWinnerNumber() {
        return winnerNumber;
    }

    // Sets the winner number
    public synchronized void setWinnerNumber(int winnerNumber) {
        this.winnerNumber = winnerNumber;
    }

    // Declares the winner
    public synchronized boolean declareWinner(int playerNumber) {
        if (isGameOver) {
            return false;
        }
        setGameOver(true);
        setWinnerNumber(playerNumber);
        return true;
    }
}
