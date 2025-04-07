package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    private static final int LOTTO_NUM_COUNT = 6;

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = new HashSet<>(numbers);
    }

    public LottoTicket(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = convertToLottoNumbers(numbers);
    }

    public LottoTicket(String numbersStr) {
        this(parseNumbers(numbersStr));
    }

    private static Set<LottoNumber> parseNumbers(String numbersStr) {
        if (numbersStr == null || numbersStr.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        Set<LottoNumber> numbers = new HashSet<>();
        for (String numberStr : numbersStr.split(",")) {
            numbers.add(new LottoNumber(numberStr));
        }
        return numbers;
    }

    private Set<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 6개의 숫자로 이루어져 있어야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 중복된 숫자를 포함할 수 없습니다.");
        }
    }


    public Set<Integer> getNumbers() {
        return this.numbers.stream()
            .map(LottoNumber::getValue)
            .collect(Collectors.toSet());
    }

    public int countMatches(LottoTicket other) {
        if (other == null) {
            throw new IllegalArgumentException("비교할 번호는 null일 수 없습니다.");
        }

        int count = 0;
        for (LottoNumber number : numbers) {
            if (other.numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }
}
