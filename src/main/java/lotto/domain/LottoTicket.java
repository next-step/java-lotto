package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicket {
    private final static List<Integer> LottoNumbers = IntStream.range(0, 45)
            .mapToObj(i -> i + 1)
            .collect(Collectors.toList());

    private final List<Integer> numbers;

    public LottoTicket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket() {
        Collections.shuffle(LottoNumbers);
        this.numbers = LottoNumbers.subList(0, 6)
                .stream()
                .sorted()
                .collect(Collectors.toList());
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
