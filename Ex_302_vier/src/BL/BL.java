package BL;

public class BL {

    private int height;
    private int width;
    private int length = 4;
    private Players[][] loc;

    public BL(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void makeMove(int x) {
        for (int i = height - 1; i >= 0; i--) {
            if (loc[x][i] == Players.empty) {
                loc[x][i] = Players.one;
                break;
            }

        }
    }
}
