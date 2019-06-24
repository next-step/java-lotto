package step2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LuckyNumber {
    private List<LottoNumber> luckyNumber;

    LuckyNumber(List<LottoNumber> luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

    public static LuckyNumber from(List<Integer> lottoNumbers) {
        return new LuckyNumber(lottoNumbers
                .stream()
                .map(LottoNumber::from)
                .collect(Collectors.toList()));
    }

    public List<LottoNumber> getLuckyNumber() {
        return Collections.unmodifiableList(luckyNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LuckyNumber that = (LuckyNumber) o;
        return Objects.equals(luckyNumber, that.luckyNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(luckyNumber);
    }

    @Override
    public String toString() {
        return "LuckyNumber{" +
                "luckyNumber=" + luckyNumber +
                '}';
    }
}
