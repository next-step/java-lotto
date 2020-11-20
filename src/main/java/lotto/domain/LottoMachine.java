package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {

    private LottoNumberGenerator lottoNumberGenerator = LottoNumberGenerator.simple();

    public LottoMachine() {
    }

    public List<Lotto> issue(int purchaseAmount) {
        int howManyLottosCanIBuy = purchaseAmount / Lotto.PRICE;

        return IntStream.range(0, howManyLottosCanIBuy)
                .mapToObj(it -> generateLotto())
                .collect(Collectors.toList());
    }

    public PrizeWinningResult checkPrizeWinning(Lottos lottos, WinningNumber winningNumber) {
        return PrizeWinningResult.builder()
                .paidMoney(lottos.getPaidMoney())
                .rankedLottos(lottos.checkRanking(winningNumber))
                .build();
    }

    private Lotto generateLotto() {
        return new Lotto(lottoNumberGenerator.generate());
    }


}
