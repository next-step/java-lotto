package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final static List<LottoNumber> LottoNumbers = IntStream.range(0, 45)
            .mapToObj(i -> i + 1)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

    private final TreeSet<LottoNumber> numbers;

    public LottoTicket(TreeSet<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        Collections.shuffle(LottoNumbers);
        this.numbers = LottoNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toCollection(TreeSet::new));
    }

    public TreeSet<LottoNumber> getNumbers() {
        return numbers;
    }

    public int getMatchCount(WinningNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
