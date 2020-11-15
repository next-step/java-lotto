package study.lotto.lottery;

import study.lotto.core.Lotto;
import study.lotto.core.LottoNumber;
import study.lotto.core.LottoRank;
import study.lotto.core.WinLottoNumbers;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Lottery {

    private final WinLottoNumbers winLottoNumbers;
    private final List<Lotto> lottos;

    public Lottery(WinLottoNumbers winLottoNumbers, List<Lotto> lottos) {
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
        Map<LottoRank, List<Lotto>> groupByLottoRank = lottos.stream()
                .collect(Collectors.groupingBy(Lotto::getLottoRank));

        groupByLottoRank.remove(LottoRank.NONE);

        return groupByLottoRank;
    }

    private double calcTotalReturnRatio() {
        int totalPrizeAmount = lottos.stream()
                .map(Lotto::getLottoRank)
                .mapToInt(LottoRank::getPrizeAmount)
                .sum();

        int totalPurchaseAmount = lottos.size() * Lotto.PRICE_PER_LOTTO;

        double totalReturnRatio = (double)totalPrizeAmount / totalPurchaseAmount;
        return totalReturnRatio;
    }

}
