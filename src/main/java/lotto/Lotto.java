package lotto;

import lotto.utils.LottoGenerator;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {
    public static final int DEFAULT_LOTTO_SIZE = 6;

    private final Set<LottoNumber> value;

    /*
        CONSTRUCTOR
     */
    public Lotto(List<Integer> lottoNumberList) {
        this(lottoNumberList.stream()
                .map(LottoGenerator::lottoNumber)
                .collect(Collectors.toSet()));
    }

    public Lotto(Set<LottoNumber> value) {
        validateSize(value);

        this.value = value;
    }

    /*
        FUNCTION
     */
    private void validateSize(Set<LottoNumber> value) {
        if (value.size() != DEFAULT_LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 중복되지 않은 6개의 번호를 가지고 있어야합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(value, lotto.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
