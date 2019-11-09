package lotto.data;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.Wallet;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(Wallet wallet) {
        lottos = initLottos(wallet);
    }

    public int getCount() {
        return lottos.size();
    }

    public List<Rank> rankLottos(LottoNumbers winningNumbers, int bonus) {
        return lottos.stream()
                     .map(lotto -> Rank.valueOf(lotto.matchCount(winningNumbers), lotto.isMatchBonus(bonus)))
                     .collect(toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private List<Lotto> initLottos(Wallet wallet) {
        List<Lotto> lottos = new ArrayList<>();

        while (wallet.isEnoughBudget()) {
            lottos.add(new Lotto());
        }

        return lottos;
    }
}
