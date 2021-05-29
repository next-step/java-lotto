package lotto;

import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public boolean isContainsNumber(LottoNumber lottoNumber) {
        return lottoNumbers.stream()
                .anyMatch(number -> number.equals(lottoNumber));
    }

    public boolean lottoSize(int expectedSize) {
        return lottoNumbers.size() == expectedSize;
    }

    public int countMatchWinLottoNumber(Lotto winLotto) {
        int countMatchNumber = 0;
        for (LottoNumber lottoNumber : lottoNumbers) {
            countMatchNumber += winLotto.matchNumber(lottoNumber);
        }
        return countMatchNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (LottoNumber lottoNumber : lottoNumbers) {
            stringBuilder.append(lottoNumber.toString());
            stringBuilder.append(", ");
        }
        stringBuilder.replace(stringBuilder.length() - 2, stringBuilder.length(), "]");
        return stringBuilder.toString();
    }
}
