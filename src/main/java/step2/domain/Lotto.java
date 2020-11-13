package step2.domain;

import step2.exception.LottoCountBoundException;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {

    private final List<Integer> lottoNumbers;

    public Lotto(List<Integer> lottoNumbers) {

        validLottoCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validLottoCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoCountBoundException();
        }
    }

    public boolean lottoNumbersSize(int size) {
        return lottoNumbers.size() == size;
    }

    public int matchLottoNumbers(List<Integer> matchLottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(matchLottoNumbers::contains)
                .count();
    }

    public String getLottoNumbersToStringList() {
        return lottoNumbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }
}
