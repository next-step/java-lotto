package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    public static final int LOTTO_PRICE = 1000;
    public static final int WINNING_STANDARD_NUMBER = 3;
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int paidMoney, LottoGeneratorStrategy lottoGeneratorStrategy) {
        int count = paidMoney / LOTTO_PRICE;
        return new Lottos(
                Stream.generate(() -> Lotto.createLotto(lottoGeneratorStrategy))
                        .limit(count)
                        .collect(Collectors.toList()));
    }
    public static Lottos of(String lottoNumbers) {
        return new Lottos(
                Stream.generate(() -> Lotto.createLotto(lottoNumbers.split(" ")))
                        .limit(1)
                        .collect(Collectors.toList()));
    }

    public List<Rank> getRanks(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> Rank.valueOf(lotto.getWinningCount(winningNumbers), lotto.getBonusMatch(bonusNumber)))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

}
