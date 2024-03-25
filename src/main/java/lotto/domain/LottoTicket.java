package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicket {
    private final static int LOTTO_NUMBER_COUNT = 6;
    private final static List<LottoNumber> LOTTO_NUMBERS = IntStream.rangeClosed(LottoNumber.LOTTO_MIN_NUMBER, LottoNumber.LOTTO_MAX_NUMBER)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("6개의 숫자를 입력하세요.");
        }
        this.numbers = numbers;
    }

    public LottoTicket() {
        this(automaticLottery());
    }

    public LottoTicket(List<Integer> numbers) {
        this(toSet(numbers));
    }

    public LottoTicket(String... numbers) {
        this(toSet(toIntArray(numbers)));
    }

    private static List<Integer> toIntArray(String[] numbers) {
        return Stream.of(numbers)
                .map(LottoTicket::toInt)
                .collect(Collectors.toList());
    }

    private static int toInt(String input) {
        int number;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수만 입력할 수 있습니다.");
        }

        return number;
    }

    private static TreeSet<LottoNumber> toSet(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNumber::new)
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    private static Set<LottoNumber> automaticLottery() {
        Collections.shuffle(LOTTO_NUMBERS);
        return LOTTO_NUMBERS.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public Set<LottoNumber> getNumbers() {
        return numbers;
    }

    public int getMatchCount(LottoTicket winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public WinnerPrize rank(WinningTicket winningTicket) {
        return WinnerPrize.valueOf(getMatchCount(winningTicket.getWinningNumbers()),
                numbers.contains(winningTicket.getBonusNumber()));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
