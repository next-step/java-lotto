package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoRow {
    private Set<LottoNumber> lottoNumber = new HashSet<>();

    public LottoRow(List<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 한줄의 번호 개수는 6개여야합니다");
        }

        Set<LottoNumber> tmp = new HashSet<>(numbers);
        if (tmp.size() != 6) {
            throw new IllegalArgumentException("로또 번호에 중복된 숫자가 있습니다");
        }

        this.lottoNumber = tmp;
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

    public Boolean isContainBonusNumber(LottoNumber bonusNumber) {
        return this.getLottoNumbers().contains(bonusNumber.getNumber());
    }
}
