package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoStrategy lottoStrategy) {
        this.lottoNumbers = lottoStrategy.lottoNumbers();
    }

    private LottoNumbers(String numbers) {
        if (numbers == null) {
            throw new IllegalArgumentException("빈 값은 올 수 없습니다.");
        }

        final List<LottoNumber> lottoNumbers = this.splitToLottoNumber(numbers);
        this.checkSize(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers winningNumbers(String numbers) {
        return new LottoNumbers(numbers);
    }

    private List<LottoNumber> splitToLottoNumber(String numbers) {
        final String[] splitNumber = numbers.replaceAll(" ", "").split(",");

        final List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : splitNumber) {
            this.checkIsDigit(number);
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number)));
        }

        return lottoNumbers;
    }

    private void checkIsDigit(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("로또 번호는 숫자만 가능합니다.");
        }
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        if (lottoNumbers == null || lottoNumbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6자리입니다.");
        }
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
}
