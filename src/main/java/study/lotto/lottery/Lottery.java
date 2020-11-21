package study.lotto.lottery;

import study.lotto.core.*;
import study.lotto.dispenser.Lottos;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Lottery {

    private final WinLottoNumbers winLottoNumbers;
    private final Lottos lottos;

    private List<WinningLotto> winningLottos = new ArrayList<>();

    public Lottery(WinLottoNumbers winLottoNumbers, Lottos lottos) {
        this.winLottoNumbers = Optional.ofNullable(winLottoNumbers)
                .orElse(WinLottoNumbers.empty());
        this.lottos = Optional.ofNullable(lottos)
                .orElse(new Lottos(new ArrayList<>()));
    }

    public LotteryResult checkLotto() {
        // 당첨 번호 확인 및 분류
        for (Lotto lotto : lottos) {
            winningLottos.add(lotto.lottery(winLottoNumbers));
        }

        return new LotteryResult(getOnlyWinningLottos(), calcTotalReturnRatio());
    }

    private List<WinningLotto> getOnlyWinningLottos() {
        return this.winningLottos.stream()
                .filter(winningLotto -> winningLotto.getLottoRank() != LottoRank.NONE)
                .collect(Collectors.toList());
    }

    private BigDecimal calcTotalReturnRatio() {
        BigDecimal totalPrizeAmount = winningLottos.stream()
                .map(WinningLotto::getPrize)
                .map(BigDecimal::new)
                .reduce(BigDecimal.ZERO, (a, b) -> a.add(b));

        BigDecimal totalPurchaseAmount = BigDecimal.valueOf(lottos.getTotalPurchaseAmount());

        return totalPrizeAmount.divide(totalPurchaseAmount);
    }

}
