package lotto.domain;

public class LottoNum implements Comparable<LottoNum> {
    public static final int LOTTO_NUM_MIN = 1;
    public static final int LOTTO_NUM_MAX = 45;

    private int lottoNum;

    public LottoNum(int lottoNum) {
        this.lottoNum = lottoNum;

        checkNumRange();
    }

    public LottoNum(String lottoNumInput) {
        this(Integer.parseInt(lottoNumInput));
    }

    public LottoNum(int lottoNumInput, String winningLotto) {
        this(lottoNumInput);

        checkOverlaid(winningLotto);
    }

    private void checkNumRange() {
        if (!isProperNumRange()) {
            throw new IllegalArgumentException("Out of range");
        }
    }

    private boolean isProperNumRange() {
        return lottoNum >= LOTTO_NUM_MIN && lottoNum <= LOTTO_NUM_MAX;
    }

    private void checkOverlaid(String winningLotto) {
        LottoTicket winnerTicket = new LottoTicket(LottoTicket.splitNums(winningLotto));
        if (matchNumber(winnerTicket)) {
            throw new IllegalArgumentException("winning lottonum is overlaid");
        }
    }

    @Override
    public int compareTo(LottoNum inputNum) {
        return ascSort(inputNum.getLottoNum());
    }

    private int ascSort(int inputNum) {
        return lottoNum - inputNum;
    }

    public int getLottoNum() {
        return lottoNum;
    }

    public boolean matchNumber(LottoTicket lottoTicket) {
        return lottoTicket.contains(lottoNum);
    }
}
