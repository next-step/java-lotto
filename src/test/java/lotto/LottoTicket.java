package lotto;

import java.util.HashSet;
import java.util.Set;

public class LottoTicket {
    private final Set<LottoNumber> numbers;

    public LottoTicket(int[] numbers) {
        if (numbers == null || numbers.length == 0 || numbers.length > 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }

        this.numbers = new HashSet<>();
        for (int number : numbers) {
            this.numbers.add(new LottoNumber(number));
        }
    }

    public int getMatchCount(LottoTicket other) {
        return (int) other.numbers.stream()
                .filter(this.numbers::contains)
                .count();
    }
}
