package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int matchNumbers(List<Integer> winNumbers) {
        int hit = 0;
        for (Integer winNumber : winNumbers) {
            hit = countHit(hit, winNumber);
        }
        return hit;
    }

    private int countHit(int hit, Integer winNumber) {
        if (numbers.contains(winNumber)) {
            hit++;
        }
        return hit;
    }
}
