package BL;

public class BL {

    private int height;
    private int width;
    private Player[][] loc;
    private Player currentPlayer = Player.one;
    private Player winner = Player.empty;

    public BL(int width, int height) {
        this.height = height;
        this.width = width;
        loc = new Player[width][height];
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                loc[w][h] = Player.empty;
            }
        }
    }

    public void makeMove(int x) throws Exception {
        if (winner != Player.empty) {
            throw new Exception("The Game is over!");
        }
        for (int i = height - 1; i >= 0; i--) {
            if (loc[x][i] == Player.empty) {
                loc[x][i] = currentPlayer;
                this.checkWinner();
                if (currentPlayer == Player.one) {
                    currentPlayer = Player.two;
                } else {
                    currentPlayer = Player.one;
                }
                break;
            }
        }
    }

    public Player getWinner() {
        return winner;
    }

    public void checkWinner() {
        //checks horizontal
        for (int x = 0; x < width - 3; x++) {
            for (int y = 0; y < height; y++) {
                boolean won = true;
                for (int i = 0; i < 4; i++) {
                    if (loc[x + i][y] != currentPlayer) {
                        won = false;
                    }
                }
                if (won) {
                    winner = currentPlayer;
                }
            }
        }
        //checks vertical
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height - 3; y++) {
                boolean won = true;
                for (int i = 0; i < 4; i++) {
                    if (loc[x][y + i] != currentPlayer) {
                        won = false;
                    }
                }
                if (won) {
                    winner = currentPlayer;
                }
            }
        }
        //checks diagonal to the right
        for (int x = 0; x < width - 3; x++) {
            for (int y = 0; y < height - 3; y++) {
                boolean won = true;
                for (int i = 0; i < 4; i++) {
                    if (loc[x + i][y + i] != currentPlayer) {
                        won = false;
                    }
                }
                if (won) {
                    winner = currentPlayer;
                }
            }
        }
        //checks diagonal to the left
        for (int x = 3; x < width; x++) {
            for (int y = 0; y < height - 3; y++) {
                boolean won = true;
                for (int i = 0; i < 4; i++) {
                    if (loc[x - i][y + i] != currentPlayer) {
                        won = false;
                    }
                }
                if (won) {
                    winner = currentPlayer;
                }
            }
        }
    }

    public Player getPalyerAt(int x, int y) {
        return loc[x][y];
    }
}
