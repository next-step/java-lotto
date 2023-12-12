package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Lotto {

    public static final int LOTTO_PRICE = 1000;

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

    public static List<Lotto> puchaseAuto(int count) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottos.add(new Lotto(new LottoNumbers()));
        }
        return lottos;
    }

    public static List<Lotto> puchaseManual(List<String> lottoNumbers) {
        List<Lotto> lottos = new ArrayList<>();
        for (String lottoNumber : lottoNumbers) {
            lottos.add(new Lotto(new LottoNumbers(lottoNumber)));
        }
        return lottos;
    }

    @Override
    public String toString() {
        return this.lottoNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
