package domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    public static final Integer LOTTO_PRICE = 1000;

    private WinningNumbers winningNumbers;

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
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
        return Rank.calculate(calculateMatchCount(lotto));
    }

    // fixme private 으로 변경하고 싶음
    public int calculateMatchCount(Lotto lotto) {
        return (int)lotto.getLottoNumbers().stream()
            .filter(winningNumbers::contains)
            .count();
    }
}
