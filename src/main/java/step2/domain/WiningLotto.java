package step2.domain;

import step2.utils.Lotto;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WiningLotto {
    private final Lottos lottos;
    private final LottoNumbers winningNumbers;
    private final int bonusNumber;

    public WiningLotto(Lottos lottos, LottoNumbers winningNumbers, int bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public int[] getWinner() {

        return lottos.getStream().mapToInt(lotto -> {
            lotto.getLotto()
                    .getNumbers()
                    .retainAll(this.winningNumbers.getNumbers());
            return lotto.getLotto()
                    .getNumbers()
                    .size();
        }).sorted().toArray();
    }

    public Map<RankPrice, Long> getWinners() {
        List<Lotto> winnerLottos = sortWinners();

        Map<RankPrice, Long> winnerInventorySecondPlace = winnerLottos.stream()
                .filter(lotto -> lotto.getLotto().getNumbers().size() == 5)
                .filter(lotto -> lotto.getLotto().getNumbers().contains(this.bonusNumber))
                .map(lotto -> RankPrice.SECOND_PLACE)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<RankPrice, Long> winnerInventoryAllPlace = winnerLottos.stream()
                .map(lotto -> RankPrice.valueOf(lotto.getLotto().getNumbers().size()))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Stream.concat(winnerInventorySecondPlace.entrySet().stream(), winnerInventoryAllPlace.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private List<Lotto> sortWinners() {
        lottos.getStream().forEach(
                lotto -> lotto.getLotto()
                .getNumbers()
                .retainAll(this.winningNumbers.getNumbers()));

        return lottos.getStream().filter(lotto -> lotto.getLotto().getNumbers().size() > 2).collect(Collectors.toList());
    }
}
