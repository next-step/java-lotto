package lotto.domain;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoGame {
    public static final int LOTTO_PRICE = 1000;

    public List<Rank> match(List<Lotto> lottos, Lotto winningLotto, int bonusNumber) {
        return lottos.stream()
                .map(lotto -> lotto.match(winningLotto, bonusNumber))
                .collect(toList());
    }

    public int purchaseLotto(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매 금액이 로또 한 장 값보다 작을 수 없습니다.");
        }
        return price / LOTTO_PRICE;
    }

    public int getTotalWinnings(List<Rank> winningResults) {
        return winningResults.stream()
                .mapToInt(Rank::getWinningMoney)
                .sum();
    }

    public double getRateOfRevenue(int price, int totalWinnings) {
        return (double) totalWinnings / price;
    }

    public List<Lotto> createLottos(List<Lotto> manualLottoNumbers, int purchaseCount) {
        List<Lotto> autoLottoNumbers = Stream
                .generate(() -> new Lotto(new LottoNumbers().of()))
                .limit(purchaseCount)
                .collect(toList());

        return Stream.of(manualLottoNumbers, autoLottoNumbers)
                .flatMap(Collection::stream)
                .collect(toList());
    }
}
