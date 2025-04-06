package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoTicket {

    public static final int PRICE_PER_TICKET = 1000;
    private static final int LOTTO_NUM_COUNT = 6;

    private final Set<LottoNumber> numbers;
    private final LottoNumber bonusNumber;

    public LottoTicket(List<Integer> numbers) {
        this(numbers, null);
    }

    public LottoTicket(List<Integer> numbers, Integer bonusNumber) {
        validateNumbers(numbers);
        this.numbers = convertToLottoNumbers(numbers);
        this.bonusNumber = createBonusNumber(numbers, bonusNumber);
    }

    public LottoTicket(String numbersStr, String bonusNumberStr) {
        this(parseNumbers(numbersStr), parseNumber(bonusNumberStr));
    }

    private static List<Integer> parseNumbers(String numbersStr) {
        if (numbersStr == null || numbersStr.isBlank()) {
            throw new IllegalArgumentException("입력값이 없습니다.");
        }

        List<Integer> numbers = new ArrayList<>();
        for (String numberStr : numbersStr.split(",")) {
            numbers.add(parseNumber(numberStr));
        }
        return numbers;
    }

    private static int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또 번호는 숫자여야 합니다.");
        }
    }

    private Set<LottoNumber> convertToLottoNumbers(List<Integer> numbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }

    private LottoNumber createBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (bonusNumber == null) {
            return null;
        }
        validateBonusNumber(numbers, bonusNumber);
        return new LottoNumber(bonusNumber);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 6개의 숫자로 이루어져 있어야 합니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_NUM_COUNT) {
            throw new IllegalArgumentException("로또 티켓은 중복된 숫자를 포함할 수 없습니다.");
        }
    }

    private void validateBonusNumber(List<Integer> numbers, Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또 번호와 중복될 수 없습니다.");
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
}
