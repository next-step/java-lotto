package step2.domain;

public class LottoNum implements Comparable<LottoNum>{
    public static final int LOTTO_NUM_MIN = 1;
    public static final int LOTTO_NUM_MAX = 45;

    private int lottoNum;

    public LottoNum(int lottoNum) {
        this.lottoNum = lottoNum;
        checkNumRange(lottoNum);
    }

    public static void checkNumRange(int lottoNum) {
        if (!isProperNumRange(lottoNum)) {
            throw new IllegalArgumentException("Out of range");
        }
    }

    private static boolean isProperNumRange(int lottoNum) {
        return lottoNum >= LOTTO_NUM_MIN && lottoNum <= LOTTO_NUM_MAX;
    }

    @Override
    public int compareTo(LottoNum inputNum) {
        return ascSort(inputNum.getLottoNum());
    }

    public int ascSort(int inputNum) {
        return lottoNum - inputNum;
    }

    public int getLottoNum() {
        return lottoNum;
    }
}
