package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;

public class LottoTicket {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public static final int NUMBER_OF_LOTTO_NUMBERS = 6;

    private ArrayList<Integer> numbers;

    private LottoTicket(ArrayList<Integer> numbers) {
        validateNumber(numbers);
        validateSize(numbers);
        Collections.sort(numbers);
        
        this.numbers = numbers;
    }

    private void validateSize(ArrayList<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO_NUMBERS) {
            throw new IllegalArgumentException("숫자의 입력값은 6개 여야 합니다.");
        }
    }

    private void validateNumber(ArrayList<Integer> numbers) {
        boolean isOutOfRange = numbers.stream()
                .anyMatch(n -> n < MIN_LOTTO_NUMBER || n > MAX_LOTTO_NUMBER);

        if (isOutOfRange) {
            throw new IllegalArgumentException("1~45 이외의 숫자가 포함되어 있습니다.");
        }
    }

    public static LottoTicket createLottoTicketByAuto() {
        ArrayList<Integer> fullLotteNumbers = new ArrayList<>();

        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            fullLotteNumbers.add(i);
        }

        Collections.shuffle(fullLotteNumbers);

        return new LottoTicket(new ArrayList<>(fullLotteNumbers.subList(0, NUMBER_OF_LOTTO_NUMBERS)));
    }

    public static LottoTicket createLottoTicketByManual(ArrayList<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public int getMatchCount(ArrayList<Integer> inputNumbers) {
        return (int) numbers.stream().filter(inputNumbers::contains).count();
    }

    public String toString() {
        return numbers.toString();
    }
}

