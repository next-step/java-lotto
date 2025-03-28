package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(NumberGenerationStrategy generationStrategy) {
        numbers = generationStrategy.generateNumbers();
    }

    @Override
    public String toString() {
        return  numbers.toString();
    }

    public int matchCountWith(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }
}
