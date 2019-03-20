package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;

    private Lotto winningNumbers;

    public void initWinningNumbers(Integer ...number) {
        winningNumbers = new Lotto(number);
    }

    public List<Lotto> purchase(int money) {
        int count = money / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }

        return lottos;
    }

    public List<Rank> calculateRanks(List<Lotto> lottos){
        List<Rank> ranks = new ArrayList<>();
        lottos.stream()
            .map(this::calculateRank)
            .forEach(ranks::add);

        return ranks;
    }

    public Rank calculateRank(Lotto lotto) {
        return Rank.calculate(winningNumbers.matchCount(lotto));
    }

    public Lotto getWinningNumbers() {
        return winningNumbers;
    }
}
