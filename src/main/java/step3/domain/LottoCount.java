package step3.domain;

public class LottoCount {

    public static final int THREE_MATCH = 5_000;
    public static final int FOUR_MATCH = 50_000;
    public static final int FIVE_MATCH = 1_500_000;
    public static final int SIX_MATCH = 2_000_000_000;
    public static final int THREE_COUNT = 3;
    public static final int FOUR_COUNT = 4;
    public static final int FIVE_COUNT = 5;
    public static final int SIX_COUNT = 6;

    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int sixCount;

    public LottoCount() {
    }


    public double earningRate(int size) {
        long sum = 0;
        sum += this.threeCount * THREE_MATCH;
        sum += this.fourCount * FOUR_MATCH;
        sum += this.fiveCount * FIVE_MATCH;
        sum += this.sixCount * SIX_MATCH;

        return sum / (double) (size * 1000);

    }

    public void sameCount(int count) {
        if (count == THREE_COUNT) this.threeCount++;
        if (count == FOUR_COUNT) this.fourCount++;
        if (count == FIVE_COUNT) this.fiveCount++;
        if (count == SIX_COUNT) this.sixCount++;
    }


    public int getThreeCount() {
        return threeCount;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getFiveCount() {
        return fiveCount;
    }

    public int getSixCount() {
        return sixCount;
    }
}
