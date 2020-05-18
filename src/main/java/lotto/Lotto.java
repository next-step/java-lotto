package lotto;


public class Lotto {
    private final LottoNums lottoNums;

    public Lotto(LottoNums lottoNums) {
        this.lottoNums = lottoNums;
    }

    public int getMatchCount(LottoNums lottoNums) {
        return this.lottoNums.getMatchCount(lottoNums);
    }
}
