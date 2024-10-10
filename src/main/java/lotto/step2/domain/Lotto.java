package lotto.step2.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_COUNT_LIMIT = 6;
    private static final int LIMIT_LOTTO_NUMBER = 45;

    private final List<Integer> numbers;

    public static Lotto create(LottoNumbersGenerater generater){
        return new Lotto(generater.generate());
    }

    public Lotto(final List<Integer> numbers){
        this.numbers = numbers;
        this.validateNumbers();
    }

    //region [validateNumbers]
    private void validateNumbers() {
        validNumberCount(this.numbers);
        validNumberRange(this.numbers);
        duplicateNumber(this.numbers);
    }

    private void validNumberCount(List<Integer> numbers) {
        if(numbers.size() != LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또 번호를 6개 입력하세요");
        }
    }

    private void validNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if(isNonValidNumber(number)){
                throw new IllegalArgumentException("1-45범위 내의 로또 번호를 입력하세요");
            }
        }
    }

    private boolean isNonValidNumber(int lottoNumber) {
        return lottoNumber <= 0 || lottoNumber > LIMIT_LOTTO_NUMBER;
    }

    private void duplicateNumber(List<Integer> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();

        if(count < LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또번호가 중복됐습니다");
        }
    }
    //endregion

    public boolean hasNumber(Integer winningNumber) {
        return this.numbers.contains(winningNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
