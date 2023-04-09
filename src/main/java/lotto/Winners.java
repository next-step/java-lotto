package lotto;

import configuration.WinnerType;

public class Winners {
    private WinnerType winnerType;
    private int first = 0;
    private int second = 0;
    private int third = 0;
    private int forth = 0;
    private int fifth = 0;
    private int none = 0;

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public int getThird() {
        return third;
    }

    public int getForth() {
        return forth;
    }

    public int getFifth() {
        return fifth;
    }

    public void setWinners(WinnerType inputType) {
        if (inputType.equals(winnerType.FIRST)) {
            first++;
        }
        if (inputType.equals(winnerType.SECOND)) {
            second++;
        }
        if (inputType.equals(winnerType.THIRD)) {
            third++;
        }
        if (inputType.equals(winnerType.FORTH)) {
            forth++;
        }
        if (inputType.equals(winnerType.FIFTH)) {
            fifth++;
        }
        if (inputType.equals(winnerType.NONE)) {
            none++;
        }
    }

    public int getProfit() {
        return  first * 2000000000 +
                second * 30000000 +
                third * 1500000 +
                forth * 50000 +
                fifth * 5000;
    }
}
