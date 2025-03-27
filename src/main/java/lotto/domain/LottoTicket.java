package lotto.domain;

import java.util.*;

public class LottoTicket {
    private static final Random RANDOM = new Random();
    private static final int NUMBER_SIZE = 6;
    private static final int NUMBER_UPPER_BOUND = 45;
    private static final int NUMBER_LOWER_BOUND = 1;
    private final List<Integer> numbers;

    public LottoTicket() {
        numbers = new ArrayList<>();
        for(int i=0; i<6; i++) {
            int number = generateNumber();
            while (numbers.contains(number)) {
                number = generateNumber();
            }
            numbers.add(number);
        }
    }

    public LottoTicket(List<Integer> numbers) {
        validateNumberSize(numbers);
        validateNumberBound(numbers);
        validateNotDuplicate(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateNumberSize(List<Integer> numbers) {
        if(numbers.size() != NUMBER_SIZE)
            throw new IllegalArgumentException("number size should be 6.");
    }

    private void validateNotDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size())
            throw new IllegalArgumentException("number should not be duplicate.");
    }

    private void validateNumberBound(List<Integer> numbers) {
        for (Integer number : numbers) {
            if(number == null || number < NUMBER_LOWER_BOUND || number > NUMBER_UPPER_BOUND)
                throw new IllegalArgumentException(String.format("number should be between %d and %d.", NUMBER_LOWER_BOUND, NUMBER_UPPER_BOUND));
        }
    }

    private static int generateNumber() {
        return RANDOM.nextInt(NUMBER_UPPER_BOUND-NUMBER_LOWER_BOUND+1) + NUMBER_LOWER_BOUND;
    }

    public LottoRank rank(LottoTicket winningTicket) {
        int matchCount = 0;
        for(Integer number : winningTicket.numbers) {
            if(numbers.contains(number)) matchCount++;
        }
        return LottoRank.of(matchCount);
    }
}
