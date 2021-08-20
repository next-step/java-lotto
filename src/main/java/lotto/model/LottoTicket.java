package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int SIZE = 6;
    private static final String SIZE_ERROR_MSG = "%d개의 번호가 필요합니다.";
    private static final String DUPLICATE_ERROR_MSG = "번호는 중복되면 안됩니다.";
    public static final String DELIMITER = ",";

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers.stream()
                .map(LottoNumber::of)
                .collect(Collectors.toSet());
    }

    public static LottoTicket of(List<Integer> numbers) {
        return new LottoTicket(numbers);
    }

    public static LottoTicket of(String numbers) {
        return new LottoTicket(Arrays.stream(numbers.split(DELIMITER))
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
    }

    public List<Integer> getNumbers(){
        return numbers.stream()
                .map(LottoNumber::getNumber)
                .sorted()
                .collect(Collectors.toList());
    }

    private void validateNumbers(List<Integer> numbers) {
        checkSize(numbers);
        checkDuplication(numbers);
    }

    private void checkSize(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(String.format(SIZE_ERROR_MSG, SIZE));
        }
    }

    private void checkDuplication(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != SIZE) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MSG);
        }
    }


    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public boolean contains(int number) {
        return this.contains(LottoNumber.of(number));
    }

    public int compareTicket(LottoTicket ticket) {
        return Math.toIntExact(numbers.stream()
                .filter(ticket::contains)
                .count());
    }

}
