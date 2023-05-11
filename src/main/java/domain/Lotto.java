package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<LottoNumber> lottoNumbers;
    public static final Number needLottoNumberCount = new Number(6);

    public Lotto(List<LottoNumber> lottoNumbers) {
        if (!isValidLottoNumbers(lottoNumbers)) {
            throw new IllegalArgumentException("Lotto must have 6 numbers, but " + lottoNumbers.size() + " numbers.");
        }

        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    private boolean isValidLottoNumbers(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.size() == needLottoNumberCount.value();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public int matchCount(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::contains)
                .count();
    }

    @Override
    public String toString() {
        return "[" + lottoNumbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ")) + "]";
    }
}
