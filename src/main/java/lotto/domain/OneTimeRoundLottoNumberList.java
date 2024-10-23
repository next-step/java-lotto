package lotto.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class OneTimeRoundLottoNumberList {
    private final List<LottoNumber> oneTimeRoundLottoNumberList;

    public OneTimeRoundLottoNumberList(List<Integer> oneTimeRoundLottoNumberList) {
        this.oneTimeRoundLottoNumberList = oneTimeRoundLottoNumberList.stream()
                .map(LottoNumber::new).collect(Collectors.toList());
        checkLottoNumberListSize();
    }

    private void checkLottoNumberListSize() {
        if (oneTimeRoundLottoNumberList.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> convertLottoNumberList() {
        return oneTimeRoundLottoNumberList.stream()
                .map(LottoNumber::getLottoNumber).collect(Collectors.toList());
    }


    public boolean compareNumber(int insertLottoNumber) {
        return oneTimeRoundLottoNumberList.stream()
                .anyMatch(lottoNumber -> lottoNumber.compareNumber(insertLottoNumber));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OneTimeRoundLottoNumberList that = (OneTimeRoundLottoNumberList) o;
        return Objects.equals(oneTimeRoundLottoNumberList, that.oneTimeRoundLottoNumberList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(oneTimeRoundLottoNumberList);
    }
}
