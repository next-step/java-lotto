package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;

public class Lotto {
    private static final int LOTTO_COUNT_LIMIT = 6;

    private final Set<LottoNumber> numbers;

    public static Lotto create(LottoNumbersGenerater generater){
        return new Lotto(generater.generate());
    }

    public Lotto(final List<LottoNumber> numbers){
        this(new HashSet<>(numbers));
    }

    public Lotto(final int... numbers){
        this(convertIntToLottoNumber(numbers));
    }

    public Lotto(final Set<LottoNumber> numbers){
        this.numbers = numbers;
        this.validateNumbers();
    }

    private static Set<LottoNumber> convertIntToLottoNumber(int[] winningNumbers) {
        return Arrays.stream(winningNumbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(toSet());
    }

    //region [validateNumbers]
    private void validateNumbers() {
        validNumberCount(this.numbers);
        duplicateNumber(this.numbers);
    }

    private void validNumberCount(Set<LottoNumber> numbers) {
        if(numbers.size() != LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또 번호를 6개 입력하세요");
        }
    }

    private void duplicateNumber(Set<LottoNumber> lottoNumbers) {
        if(lottoNumbers.size() < LOTTO_COUNT_LIMIT){
            throw new IllegalArgumentException("로또번호가 중복됐습니다");
        }
    }
    //endregion

    public boolean hasNumber(int winningNumber) {
        LottoNumber lottoNumber = LottoNumber.valueOf(winningNumber);
        return hasNumber(lottoNumber);
    }

    public boolean hasNumber(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
