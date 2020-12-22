package lotto.domain;

import java.util.Arrays;

public class LottoNumbers {

    private final Integer[] numbers;

    public LottoNumbers(Integer[] numbers) {
        if (numbers.length != 6) {
            throw new IllegalArgumentException("로또의 숫자는 6개입니다.");
        }
        Arrays.stream(numbers).forEach(number -> {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또 번호는 1부터 45까지 입니다.");
            }
        });
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return Arrays.asList(this.numbers).contains(number);
    }

    public int matchingNumbers(Lotto luckyLotto) {
        return (int) Arrays.stream(this.numbers)
                .filter(luckyLotto::contains).count();
    }

    public void print() {
        System.out.println(Arrays.toString(this.numbers));
    }

}
