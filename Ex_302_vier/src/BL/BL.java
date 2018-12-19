package BL;

public class BL {

    private int height;
    private int width;
    private Players currentPlayer = Players.one;
    private Players[][] loc;

    public BL(int width, int height) {
        this.height = height;
        this.width = width;
        loc = new Players[width][height];
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                loc[w][h] = Players.empty;
            }
        }
    }

    public void makeMove(int x) {
        for (int i = height - 1; i >= 0; i--) {
            if (loc[x][i] == Players.empty) {
                loc[x][i] = currentPlayer;
                if (currentPlayer == Players.one) {
                    currentPlayer = Players.two;
                } else {
                    currentPlayer = Players.one;
                }
                break;
            }

        }
    }

    public Players getPalyerAt(int x, int y) {
        return loc[x][y];
    }
}
