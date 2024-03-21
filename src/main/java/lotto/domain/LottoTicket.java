package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LottoTicket {
    private final static List<LottoNumber> LOTTO_NUMBERS = IntStream.range(0, 45)
            .mapToObj(i -> i + 1)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private final Set<LottoNumber> numbers;

    public LottoTicket(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        this(automaticLottery());
    }

    public LottoTicket(Integer... numbers) {
        this(toSet(numbers));
    }

    private static TreeSet<LottoNumber> toSet(Integer... numbers) {
        return Stream.of(numbers)
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

    public int getMatchCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public WinnerPrize rank(WinningNumbers winningNumbers, LottoNumber bonusBall) {
        return WinnerPrize.valueOf(getMatchCount(winningNumbers), numbers.contains(bonusBall));
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
