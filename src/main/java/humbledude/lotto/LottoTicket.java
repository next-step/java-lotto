package humbledude.lotto;

import java.util.Set;
public class LottoTicket {

    private final LottoNumbers numbers;

    public LottoTicket(LottoNumbers numbers) {
        this.numbers = numbers;
    }

    public Set<Integer> getNumbers() {
        return numbers.getNumbers();
    }
}
