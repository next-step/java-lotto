package lotto;

import java.util.Arrays;

public class LottoTicket {
    private int NUMBER_DIGITS = 6;
    private int[] numbers = null;
    
    public LottoTicket(int[] numbers) {
        if (numbers == null || numbers.length != NUMBER_DIGITS) {
            new IllegalArgumentException("로또게임 반드시 6개의 숫자로 이루어져야합니다.");
        }
        this.numbers = numbers;
    }

    public int[] getNumbers() {
        Arrays.sort(numbers);
        return Arrays.copyOf(numbers, numbers.length);
    }

}
