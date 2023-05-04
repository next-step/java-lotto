package lotto.model;

public enum Win {
    WIN_3(3, 5000),
    WIN_4(4, 50000),
    WIN_5(5, 1500000),
    WIN_6(6, 2000000000);

    private int points;
    private int prize;

    Win(int points, int prize) {
        this.points = points;
        this.prize = prize;
    }

    public int getPoints() {
        return points;
    }

    public int getPrize() {
        return prize;
    }
}
