package lotto.domain;

import java.util.List;

public class LottoTicket {

    private final List<Integer> numbers;

    public LottoTicket(NumberGenerationStrategy generationStrategy) {
        numbers = generationStrategy.generateNumbers();
    }


}
