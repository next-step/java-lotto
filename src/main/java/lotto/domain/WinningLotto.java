package lotto.domain;

public class WinningLotto extends Lotto{

    private static final int MISS_HIT_COUNT = 0;
    private static final int INIT_COUNT = 0;
    private static final int CUT_LINE_COUNT = 3;

    public WinningLotto(String input) {
        super(input);
    }

    public Rank compareLottoAndReturnResult(Lotto lotto) {
        int matchingCount = 0;
        for(LottoNumber lottoNumber : super.lottoNumbers) {
            if(lotto.containsLottoNumber(lottoNumber)) {
                matchingCount++;
            }
        }
        return Rank.returnRank(matchingCount);
    }

}
