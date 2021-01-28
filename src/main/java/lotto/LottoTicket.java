package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LottoTicket {
    private List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int countMatches(LottoTicket other) {
        Set<LottoNumber> foo = new HashSet<>(numbers);
        Set<LottoNumber> bar = new HashSet<>(other.numbers);

        foo.retainAll(bar);
        return foo.size();
    }

    public boolean includeNumber(LottoNumber number) {
        return numbers.indexOf(number) != -1;
    }
}
