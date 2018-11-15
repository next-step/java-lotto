package lotto;

public enum LottoType {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 150000), SIX(6, 200000000);

    private int winningNumber;
    private int reword;

    LottoType(int winningNumber, int reword) {
        this.winningNumber = winningNumber;
        this.reword = reword;
    }

    public static LottoType findLottoType(int winningNumber) {
        switch (winningNumber) {
            case 3:
                return THREE;
            case 4:
                return FOUR;
            case 5:
                return FIVE;
        }
        return SIX;
    }

    public int computeEarning(int winningCount){
        return this.reword * winningCount;
    }

    @Override
    public String toString() {
        return winningNumber + "개 일치 (" + reword + "원)";
    }
}
