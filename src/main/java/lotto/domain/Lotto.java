package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static lotto.domain.LottoNumber.LOTTO_LENGTH;

public class Lotto {
    private final Set<LottoNumber> lotto = new HashSet<>();

    public Lotto(List<Integer> lotto) {
        for (Integer number : lotto) {
            this.lotto.add(LottoNumber.of(number));
        }

        if(this.lotto.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("중복없는 6자리의 수를 입력해주세요.");
        }
    }

    public long match(Lotto winningLotto) {
        return lotto.stream().filter(winningLotto::contains).count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return this.lotto.contains(lottoNumber);
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
        return Objects.hash(lotto);
    }

    public List<Integer> getLotto() {
        return this.lotto.stream().map(LottoNumber::getNumber)
                .collect(Collectors.toList());
    }
}
