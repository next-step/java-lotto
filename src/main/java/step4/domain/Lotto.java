package step4.domain;

import step4.exception.LottoCountBoundException;
import step4.exception.LottoNumberDuplicateException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lotto {

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public Lotto(List<Integer> lottoNumbers) {

        validLottoCount(lottoNumbers);

        this.lottoNumbers = lottoNumbers.stream()
                .sorted()
                .map(this::init)
                .collect(Collectors.toList());

    }

    private void validLottoCount(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new LottoCountBoundException();
        }
    }

    public int matchLottoNumbers(Lotto lotto) {
        return (int) lottoNumbers.stream()
                .filter(lotto::has)
                .count();
    }

    public String getLottoNumbersToStringList() {
        return lottoNumbers.stream()
                .map(LottoNumber::getLottoNumber)
                .map(Object::toString)
                .collect(Collectors.joining(", "));
    }

    public boolean has(LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public Stream<LottoNumber> stream() {
        return lottoNumbers.stream();
    }

    private LottoNumber init(int lottoNum) {
        LottoNumber lottoNumber = new LottoNumber(lottoNum);
        validDuplicatedNumber(lottoNumber);

        return lottoNumber;
    }

    private void validDuplicatedNumber(LottoNumber lottoNumber) {
        if (lottoNumbers.contains(lottoNumber)) {
            throw new LottoNumberDuplicateException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
