package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_LENGTH = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(final List<LottoNumber> lottoNumbers) {
        validateLotto(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static Lotto createManualLotto(final List<Integer> lottoNumbers) {
        List<LottoNumber> createLottoNumber = lottoNumbers.stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
        return new Lotto(createLottoNumber);
    }

    private void validateLotto(final List<LottoNumber> lottoNumbers) {
        validateLottoLength(lottoNumbers);
        validateDuplicateLottoNumber(lottoNumbers);
    }

    private void validateLottoLength(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("로또 번호는 " + LOTTO_LENGTH + "개이여야 합니다");
        }
    }

    private void validateDuplicateLottoNumber(final List<LottoNumber> lottoNumbers) {
        long distinctLength = lottoNumbers.stream()
            .distinct()
            .count();
        if (lottoNumbers.size() != distinctLength) {
            throw new IllegalArgumentException("로또 넘버는 중복되면 안됩니다.");
        }
    }

    public boolean isContain(final LottoNumber lottoNumber) {
        return lottoNumbers.contains(lottoNumber);
    }

    public List<LottoNumber> getLottoNumbers() {
        return new ArrayList<>(this.lottoNumbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(lottoNumbers, lotto.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }

}
