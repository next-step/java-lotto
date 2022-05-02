package autolotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<LottoNumbers> lottoNumbers = new ArrayList<>();

    public void add(LottoNumbers lottoNumbers) {
        this.lottoNumbers.add(lottoNumbers);
    }

    public Results confirm(WinningLotto winningLotto) {
        Results results = new Results();

        for (LottoNumbers lottoNumber : lottoNumbers) {
            int numberOfWins = lottoNumber.match(winningLotto);
            results.find(numberOfWins).ifPresent(Result::plusWinners);
        }
        return results;
    }

    public int cost() {
        return lottoNumbers.size() * LOTTO_PRICE;
    }

    public int getQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }
}
