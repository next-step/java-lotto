package lotto.domain.number;

import lotto.constant.ErrorMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {

    private static final String DELIMITER = ",";
    public static final int LOTTO_NUMBER_SIZE = 6;

    private final Set<LottoNumber> lotto;

    public Lotto(String lottoString) {
        this(getLottoNumbers(lottoString));
    }

    public Lotto(List<LottoNumber> lotto) {
        this(new HashSet<>(lotto));
    }

    public Lotto(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
        }
        this.lotto = Set.copyOf(lotto);
    }

    private static Set<LottoNumber> getLottoNumbers(String lottoString) {
        if (lottoString.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NEED_DISTINCT_SIX_NUMBERS.getMessage());
        }

        return Arrays.stream(Objects.requireNonNull(lottoString).split(DELIMITER))
                .map(String::trim)
                .map(str -> LottoNumber.of(Integer.parseInt(str)))
                .collect(Collectors.toSet());
    }

    public static Lotto create() {
        return new Lotto(LottoGenerator.generate());
    }

    public int match(Lotto compared) {
        int match = 0;
        for (LottoNumber number : compared.lotto) {
            match += compare(number);
        }
        return match;
    }

    private int compare(LottoNumber compared) {
        return lotto.contains(compared) ? 1 : 0;
    }

    @Override
    public String toString() {
        return lotto.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto1 = (Lotto) o;
        return Objects.equals(lotto, lotto1.lotto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(lotto);
    }
}
