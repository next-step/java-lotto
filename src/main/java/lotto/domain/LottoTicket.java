package lotto.domain;

import java.util.Set;

public class LottoTicket {

    private final Set<Integer> numbers;

    public LottoTicket(Set<Integer> numbers) {
        this.numbers = numbers;
    }
}
