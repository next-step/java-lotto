package lotto.domain;

import java.util.Set;

public class LottoTicket {

    private final Set<Integer> numbers;

    public LottoTicket(NumberGenerationStrategy generationStrategy) {
        numbers = generationStrategy.generateNumbers();
    }

    @Override
    public String toString() {
        return  numbers.toString();
    }

    public int matchCountWith(Set<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
