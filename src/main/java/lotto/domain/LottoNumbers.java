package lotto.domain;

import lotto.domain.strategy.LottoStrategy;

import java.util.*;

public class LottoNumbers {
    private final static int LOTTO_SIZE = 6;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(LottoStrategy lottoStrategy) {
        this.lottoNumbers = lottoStrategy.makeLottos();
    }

    public LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(String numbers) {
        if (numbers == null || numbers.isBlank()) {
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

    /**
     * 로또가 몇 개 맞았는지 확인
     */
    public int statCount(LottoNumbers lottoNumbers) {
        final List<LottoNumber> target = new ArrayList<>(this.lottoNumbers);
        target.retainAll(lottoNumbers.lottoNumbers);

        return target.size();
    }

    public boolean isBonusBall(LottoNumber bonusBall) {
        return this.lottoNumbers.contains(bonusBall);
    }

    private void checkIsDigit(String number) {
        if (!Character.isDigit(number.charAt(0))) {
            throw new IllegalArgumentException("로또 번호는 숫자만 가능합니다.");
        }
    }

    private void checkSize(List<LottoNumber> lottoNumbers) {
        final Set<LottoNumber> set = new HashSet<>(lottoNumbers);

        if (set.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6자리입니다.");
        }
    }

    List<Integer> getIntegerLottoNumbers() {
        final List<Integer> integersLottoNumbers = new ArrayList<>();

        for (LottoNumber lottoNumber : this.lottoNumbers) {
            integersLottoNumbers.add(lottoNumber.getLottoNumber());
        }

        return integersLottoNumbers;
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
