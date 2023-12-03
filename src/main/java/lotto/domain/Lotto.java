package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;

    private final LottoNumbers lottoNumbers;

    private int matchCount;

    public Lotto(LottoNumbers numbers) {
        matchCount = 0;
        this.lottoNumbers = numbers;
    }

    public int matchCount(LottoNumbers winningNumbers) {
        matchCount = this.lottoNumbers.matchCount(winningNumbers);
        return matchCount;
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
