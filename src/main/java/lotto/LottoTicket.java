package lotto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LottoTicket {
    private List<LottoNumber> numbers;
    private LottoNumber bonus;

    // for lotto machine
    public LottoTicket(List<LottoNumber> numbers, LottoNumber bonus) {
        this.numbers = numbers;
        this.bonus = bonus;
    }

    // for buyer
    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public int countMatches(LottoTicket other) {
        Set<LottoNumber> foo = new HashSet<>(numbers);
        Set<LottoNumber> bar = new HashSet<>(other.numbers);

        foo.retainAll(bar);
        return foo.size();
    }

    public boolean bonusMatches(LottoTicket other) {
        Set<LottoNumber> bar = new HashSet<>(other.numbers);
        return bar.contains(bonus);
    }

    public boolean includeNumber(LottoNumber number) {
        return numbers.indexOf(number) != -1;
    }

    // 티켓 한 장의 정보를 출력
    public List<Integer> getLottoNumbers() {
        List<Integer> ticketNumbers = new ArrayList<>();
        for (LottoNumber number : numbers) {
            ticketNumbers.add(number.getLottoNumber());
        }
        return ticketNumbers;
    }

    public LottoNumber getBonusNumber() {
        return bonus;
    }
}
