package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto autoGenerate() {
        List<LottoNo> autoNumbers = new ArrayList<>(LottoNumbers.ALL_NUMBERS);
        Collections.shuffle(autoNumbers);
        autoNumbers = autoNumbers.subList(0, LottoNumbers.CHOICE_COUNT);
        return new Lotto(new LottoNumbers(autoNumbers));
    }

    public static Lotto manualGenerate(LottoNumbers lottoNumbers) {
        List<LottoNo> manualNumbers = lottoNumbers.getValues();
        return new Lotto(new LottoNumbers(manualNumbers));
    }

    public LottoNumbers numbers() {
        return lottoNumbers;
    }

    public boolean hasNumber(LottoNo bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
