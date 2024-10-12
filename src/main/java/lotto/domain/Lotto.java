package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private static final int LOTTO_COUNT_LIMIT = 6;

    private final List<LottoNumber> numbers;

    public static Lotto create(LottoNumbersGenerater generater){
        return new Lotto(generater.generate());
    }

    public Lotto(final int... numbers){
        this(convertIntToLottoNumber(numbers));
    }

    public Lotto(final List<LottoNumber> numbers){
        this.numbers = numbers;
        this.validateNumbers();
    }

    private static List<LottoNumber> convertIntToLottoNumber(int[] winningNumbers) {
        List<LottoNumber> numbers = new ArrayList<>();
        for (int winningNumber : winningNumbers) {
            numbers.add(new LottoNumber(winningNumber));
        }
        return numbers;
    }

    //region [validateNumbers]
    private void validateNumbers() {
        validNumberCount(this.numbers);
        duplicateNumber(this.numbers);
    }

    private void validNumberCount(List<LottoNumber> numbers) {
        if(numbers.size() != LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또 번호를 6개 입력하세요");
        }
    }

    private void duplicateNumber(List<LottoNumber> lottoNumbers) {
        long count = lottoNumbers.stream()
                .distinct()
                .count();

        if(count < LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또번호가 중복됐습니다");
        }
    }
    //endregion

    public boolean hasNumber(int winningNumber) {
        return this.numbers.contains(new LottoNumber(winningNumber));
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
