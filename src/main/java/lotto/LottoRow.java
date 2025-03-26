package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoRow {
    private final List<LottoNumber> lottoNumber = new ArrayList<>();
    public LottoRow(List<Integer> randomNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(randomNumbers);
        Collections.sort(sortedNumbers);

        for (Integer randomNumber : sortedNumbers) {
            this.lottoNumber.add(new LottoNumber(randomNumber));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoRow lottoRow = (LottoRow) o;
        return Objects.equals(lottoNumber, lottoRow.lottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumber);
    }
}
