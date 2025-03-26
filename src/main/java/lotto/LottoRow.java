package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoRow {
    private final List<LottoNumber> lottoNumber = new ArrayList<>();
    public LottoRow(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 한줄의 번호 개수는 6개여야합니다");
        }

        for (Integer number : numbers) {
            this.lottoNumber.add(new LottoNumber(number));
        }
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumber.stream()
            .map(LottoNumber::getNumber)
            .collect(Collectors.toList());
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

    public int isContainCount(LottoRow winningNumbers) {
        List<Integer> winningList = winningNumbers.getLottoNumbers();

        return (int) this.getLottoNumbers().stream()
            .filter(winningList::contains)
            .count();
    }
}
