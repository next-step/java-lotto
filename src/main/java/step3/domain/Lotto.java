package step3.domain;

import java.util.List;

public class Lotto {

    private final List<LottoNumber> numbers;
    private static final int LOTTO_SIZE = 6;

    public Lotto(List<LottoNumber> numbers) {
        inputCheck(numbers);
        this.numbers = numbers;
    }

    private void inputCheck(List<LottoNumber> numbers) {
        if(numbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 6개만 가능합니다.");
        }

        if(numbers.stream().distinct().count() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }
    }

    public List<LottoNumber> lottoNumbers() {
        return this.numbers;
    }

    public int matchCount(Lotto winningNumbersLotto) {
        return (int) numbers.stream()
                .filter(winningNumbersLotto.numbers::contains)
                .count();
    }


    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
