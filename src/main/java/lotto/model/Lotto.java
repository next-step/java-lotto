package lotto.model;

import lotto.exception.InvalidLottoException;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_SIZE = 6;
    private final List<LottoNumber> lottoNumbers;

    public Lotto(List<LottoNumber> lottoNumbers) {
        assertLotto(lottoNumbers);

        this.lottoNumbers = lottoNumbers;
    }

    private static void assertLotto(List<LottoNumber> others) {
        assertNullOrEmpty(others);
        assertInvalidSize(others);
    }

    private static void assertNullOrEmpty(List<LottoNumber> others) {
        if (others == null || others.isEmpty()) {
            throw new InvalidLottoException("로또 번호를 입력하세요");
        }
    }

    private static void assertInvalidSize(List<LottoNumber> others) {
        if (others.size() != LOTTO_NUMBER_SIZE) {
            throw new InvalidLottoException(LOTTO_NUMBER_SIZE + "개의 로또 번호를 입력하세요");
        }
    }

    public int matches(List<LottoNumber> others) {
        assertNullOrEmpty(others);

        return others.stream()
                .map(this::match)
                .reduce(0, Integer::sum);
    }

    public int match(LottoNumber other) {
        return (int) this.lottoNumbers.stream()
                .filter(lottoNumber -> lottoNumber.equals(other))
                .count();
    }
}
