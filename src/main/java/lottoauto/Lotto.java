package lottoauto;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private static List<LottoNumber> lottoNumbersCache = LottoNumber.fixedRangeClosed().mapToObj(LottoNumber::of).collect(Collectors.toList());

    private final List<LottoNumber> lottoNumbers;

    private Lotto(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createAuto() {
        Collections.shuffle(lottoNumbersCache);
        List<LottoNumber> lottoNumbers = lottoNumbersCache.stream()
                .limit(LOTTO_SIZE)
                .collect(Collectors.toList());
        Collections.sort(lottoNumbers);
        return new Lotto(lottoNumbers);
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

    @Override
    public String toString() {
        return "Lotto{" +
                "lottoNumbers=" + lottoNumbers +
                '}';
    }
}
