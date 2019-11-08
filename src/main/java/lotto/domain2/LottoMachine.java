package lotto.domain2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoMachine {
    private final List<LottoNumber> baseLottoNumbers;

    public LottoMachine() {
        this.baseLottoNumbers = new ArrayList<>();
        for (int no = LottoNumber.MIN; no <= LottoNumber.MAX; no++) {
            baseLottoNumbers.add(LottoNumber.of(no));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMachine that = (LottoMachine) o;
        return Objects.equals(baseLottoNumbers, that.baseLottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseLottoNumbers);
    }
}
