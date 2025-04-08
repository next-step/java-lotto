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
    private final List<LottoNumber> numbers;
    private final LottoNumber bonusNumber;


    public WinningNumbers(String numbers, int bonusNumber) {
        validate(numbers, bonusNumber);
        this.numbers = parse(numbers);
        this.bonusNumber = LottoNumber.valueOf(bonusNumber);
    }

    private void validate(String numbers, int bonus) {
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
        LottoNumber bonusNumber = LottoNumber.valueOf(bonus);
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
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

    public List<MatchResult> match(LottoTicket ticket) {
        return ticket.lottoList().stream()
                .map(this::match)
                .collect(Collectors.toUnmodifiableList());

    }

    private MatchResult match(Lotto lotto) {
        long matchCount = this.numbers.stream()
                .filter(lotto::contains)
                .count();
        return new MatchResult(matchCount, lotto.contains(this.bonusNumber));
    }

    public Summary summarize(LottoTicket ticket) {
        List<MatchResult> matchResults = match(ticket);
        return new Summary(matchResults);
    }
}
