package lotto.domain.lotto;

import lotto.domain.PurchaseAmountOfMoney;
import lotto.domain.WinningAndBonusNumbers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos() {
        this.lottos = new ArrayList<>();
    }

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos emptyLottos() {
        return new Lottos();
    }

    public static Lottos valueOf(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public StatisticsOfLottos statistics(WinningAndBonusNumbers winningAndBonusNumbers, PurchaseAmountOfMoney purchaseAmountOfMoney) {
        ResultOfLottos resultOfLottos = resultOfLottos(winningAndBonusNumbers);
        double rateOfReturn = purchaseAmountOfMoney.rateOfReturn(resultOfLottos.totalWinningMoney());

        return StatisticsOfLottos.newLottoResult(resultOfLottos, rateOfReturn);
    }

    private ResultOfLottos resultOfLottos(WinningAndBonusNumbers winningAndBonusNumbers) {
        ResultOfLottos resultOfLottos = new ResultOfLottos();

        lottos.forEach(lotto -> resultOfLottos.increaseNumberOfMatchCount(winningAndBonusNumbers.rankOfLotto(lotto)));

        return resultOfLottos;
    }

    public Lottos bind(Lottos lottos) {
        List<Lotto> newLottos = Stream.of(lottos(), lottos.lottos())
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        return Lottos.valueOf(newLottos);
    }

    public int numberOfLottos() {
        return lottos.size();
    }
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }
}
