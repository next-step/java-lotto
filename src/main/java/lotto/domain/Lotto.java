package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers numbers) {
        this.lottoNumbers = numbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        return this.lottoNumbers.matchCount(winningNumbers);
    }

    public Optional<Rank> rank(LottoNumbers winningNumbers, LottoNumber bonusNumber) {
        return this.lottoNumbers.rank(winningNumbers, bonusNumber);
    }

    public static List<Lotto> puchase(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; ++i) {
            lottos.add(new Lotto(new LottoNumbers()));
        }
        return lottos;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }
}
