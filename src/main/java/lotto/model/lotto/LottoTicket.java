package lotto.model.lotto;

import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoTicket {
    private SortedSet<LottoNumber> numbers;

    public LottoTicket(SortedSet<LottoNumber> inputNumbers) {
        this.numbers = inputNumbers;
    }

    public LottoTicket() {
        this.numbers = new TreeSet<>();
    }

    public LottoTicket intersect(LottoTicket lottoTicket) {
        SortedSet<LottoNumber> inputNumbers = lottoTicket.getNumbers();

        SortedSet<LottoNumber> intersectNumbers = numbers.stream()
                .filter(inputNumbers::contains)
                .collect(Collectors.toCollection(TreeSet::new));

        return new LottoTicket(intersectNumbers);
    }

    public void add(LottoNumber number) {
        numbers.add(number);
    }

    public boolean contain(LottoNumber number) {
        return numbers.contains(number);
    }

    public void remove(LottoNumber number) {
        numbers.remove(number);
    }

    public SortedSet<LottoNumber> getNumbers() {
        return numbers;
    }

    public int size() {
        return numbers.size();
    }
}
