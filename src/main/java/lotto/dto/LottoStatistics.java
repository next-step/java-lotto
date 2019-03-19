package lotto.dto;

import lotto.domain.LottoPrize;
import lotto.vo.LottoMatchCount;

public class LottoStatistics {

    private LottoProfit lottoProfit;

    private LottoMatchCount lottoMatchCount;

    public LottoStatistics(LottoProfit lottoProfit, LottoMatchCount lottoMatchCount) {
        this.lottoProfit = lottoProfit;
        this.lottoMatchCount = lottoMatchCount;
    }

    /**
     * 등수별 개수 체크
     *
     * @param prize 등수
     */
    public LottoMatchCount incrementPrizeCnt(LottoPrize prize) {
        switch (prize) {
            case FIRST:
                lottoMatchCount.incrementFirstCount();
                break;
            case SECOND:
                lottoMatchCount.incrementSecondCount();
                break;
            case THIRD:
                lottoMatchCount.incrementThirdCount();
                break;
            case FORTH:
                lottoMatchCount.incrementForthCount();
                break;
            case FIFTH:
                lottoMatchCount.incrementFifthCount();
                break;
            default:
                break;
        }

        return lottoMatchCount;
    }

    public LottoProfit getLottoProfit() {
        return lottoProfit;
    }

    public LottoMatchCount getLottoMatchCount() {
        return lottoMatchCount;
    }
}
