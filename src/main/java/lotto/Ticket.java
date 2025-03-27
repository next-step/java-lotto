package lotto;

import java.util.List;

public class Ticket {

    private final List<Integer> numbers;

    public Ticket(NumberGenerationStrategy generationStrategy) {
        numbers = generationStrategy.generateNumbers();
    }


}
