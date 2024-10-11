package step3.model;

import step3.ganerator.RandomGenerator;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private final static int LOTTO_NUM_SIZE = 6;
    private final static String LOTTO_NUM_SIZE_MESSAGE = "로또 번호는 6자리이여만 합니다.";

    private final Set<LottoNumber> lotto;

    public Lotto(Set<LottoNumber> lotto) {
        confirmLottoNumberSize(lotto);
        this.lotto = sortLotto(lotto);
    }

    //로또번호가 이미 존재하지는 확인한다.
    public boolean confirmExistLottoNum(int num) {
        return this.lotto.stream().anyMatch(l -> l.confirmLottoNum(num));
    }

    public Set<LottoNumber> getLotto() {
        return lotto;
    }

    //로또를 오름차순 정렬한다.
    private Set<LottoNumber> sortLotto(Set<LottoNumber> lotto) {
        return lotto.stream()
                .sorted()
                .collect(Collectors.toCollection(LinkedHashSet::new));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(this.lotto, lotto.getLotto());
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lotto);
    }

    //로또번호의 갯수를 확인한다.
    private void confirmLottoNumberSize(Set<LottoNumber> lotto) {
        if (lotto.size() != LOTTO_NUM_SIZE) {
            throw new IllegalArgumentException(LOTTO_NUM_SIZE_MESSAGE);
        }
    }

}
