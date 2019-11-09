package lotto.domain2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BasicLottoMachine implements LottoMachine {
    private final List<LottoNumber> baseLottoNumbers;

    public BasicLottoMachine() {
        this.baseLottoNumbers = new ArrayList<>();

        for (int no = LottoNumber.MIN; no <= LottoNumber.MAX; no++) {
            baseLottoNumbers.add(LottoNumber.of(no));
        }
    }

    public Lottos issue(final int countOfLotto) {
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            Collections.shuffle(baseLottoNumbers);
            Lotto lotto = new Lotto(Collections.unmodifiableList(baseLottoNumbers.subList(0, Lotto.NUMBER_COUNT)));
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BasicLottoMachine that = (BasicLottoMachine) o;
        return Objects.equals(baseLottoNumbers, that.baseLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseLottoNumbers);
    }
}
