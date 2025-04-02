package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 당첨 번호
 */
public class WinningNumbers {
    private static final String DELIMITER = ",";
    private static final int MAX = 45;
    private static final int MIN = 1;
    public List<LottoNumber> numbers;

    public WinningNumbers(String numbers) {
        validate(numbers);
        this.numbers = parse(numbers);
    }

    private void validate(String numbers) {
        if (numbers == null || numbers.isBlank()) {
            throw new IllegalArgumentException("공백이 입력되었습니다. 다시 입력해주세요.");
        }
        if (!numbers.matches("^(\\d+,){5}\\d+$")) {
            throw new IllegalArgumentException("쉼표(,)로 구분된 6개의 숫자를 입력해주세요.");
        }
        if (!isInRange(numbers)) {
            throw new IllegalArgumentException("1에서 45 사이의 숫자만 입력해주세요.");
        }
        List<LottoNumber> lottoNumbers = parse(numbers);
        if (hasDuplicates(lottoNumbers)) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }

    private List<LottoNumber> parse(String numbers) {
        return Arrays.stream(numbers.split(DELIMITER))
                .map(it -> LottoNumber.valueOf(Integer.parseInt(it)))
                .collect(Collectors.toUnmodifiableList());
    }

    private boolean isInRange(String input) {
        String[] numbers = input.split(DELIMITER);
        for (String number : numbers) {
            if (Integer.parseInt(number) < MIN || Integer.parseInt(number) > MAX) {
                return false;
            }
        }
        return true;
    }

    private boolean hasDuplicates(List<LottoNumber> numbers) {
        Set<LottoNumber> container = new HashSet<>();
        for (LottoNumber number : numbers) {
            if (!container.add(number)) {
                return true;
            }
        }
        return false;
    }

    public List<MatchCount> match(LottoTicket ticket) {
        return ticket.lottoList().stream()
                .map(this::match)
                .collect(Collectors.toUnmodifiableList());

    }

    private MatchCount match(Lotto lotto) {
        long matchCount = this.numbers.stream()
                .filter(it -> lotto.numbers().contains(it))
                .count();
        return new MatchCount(matchCount);
    }

    public Summary summarize(LottoTicket ticket) {
        List<MatchCount> matchCounts = match(ticket);
        return new Summary(matchCounts);
    }
}
