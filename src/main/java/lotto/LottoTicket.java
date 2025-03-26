package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    public static final int PRICE = 1000;
    public static final int DIGIT = 6;

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        if (numbers.size() != DIGIT) {
            throw new IllegalArgumentException("로또는 " + DIGIT + "자리여야 합니다.");
        }

        this.numbers = new ArrayList<>(numbers);
    }
}
