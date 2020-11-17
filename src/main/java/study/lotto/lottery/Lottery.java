package study.lotto.lottery;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.core.LottoRank;
import study.lotto.core.WinLottoNumbers;
import study.lotto.dispenser.Lottos;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Lottery {

    private final WinLottoNumbers winLottoNumbers;
    private final Lottos lottos;

    public Lottery(WinLottoNumbers winLottoNumbers, Lottos lottos) {
        this.winLottoNumbers = winLottoNumbers;
        this.lottos = lottos;
    }

    public LotteryResult checkLotto() {
        // 당첨 번호 확인 및 분류
        for (Lotto lotto : lottos) {
            winLottoNumbers.match(lotto);
        }

        return new LotteryResult(groupByLottoRank(), calcTotalReturnRatio());
    }

    private Map<LottoRank, List<Lotto>> groupByLottoRank() {
        Map<LottoRank, List<Lotto>> groupByLottoRank = lottos.groupByLottoRank();
        groupByLottoRank.remove(LottoRank.NONE);
        return groupByLottoRank;
    }

    private double calcTotalReturnRatio() {
        int totalPrizeAmount = lottos.getTotalPrizeAmount();
        int totalPurchaseAmount = lottos.getTotalPurchaseAmount();
        double totalReturnRatio = (double)totalPrizeAmount / totalPurchaseAmount;
        return totalReturnRatio;
    }

}
