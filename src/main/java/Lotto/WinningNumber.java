package Lotto;

import java.util.Arrays;

import static Lotto.LotterNumbers.LOTTO_COUNT;
import static Lotto.RandomNumberGenerator.LOTTO_MAX_NUMBER;
import static Lotto.RandomNumberGenerator.LOTTO_MIN_NUMBER;

public class WinningNumber {
    private String[] numbers;


    public WinningNumber(String[] numbers) {
        if (numbers.length > LOTTO_COUNT) {
            throw new IllegalArgumentException();
        }
        this.numbers = checkLottoNumber(numbers);
    }

    public static WinningNumber of(String[] numbers) {
        return new WinningNumber(numbers);
    }

    public int getSize() {
        return numbers.length;
    }

    public String[] checkLottoNumber(String[] numbers) {
        Arrays.stream(numbers)
                .map(number -> (Integer.parseInt(number) < LOTTO_MIN_NUMBER || Integer.parseInt(number) > LOTTO_MAX_NUMBER))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());

        return numbers;
    }

    public Integer[] convertInteger() {

        int[] numbers = Arrays.asList(this.numbers)
                .stream().mapToInt(Integer::parseInt).toArray();


        return Arrays.stream(numbers).boxed().toArray(Integer[]::new);

    }
}
