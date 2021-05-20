package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoTicket {
    private static final String LOTTO_DIGIT_EXCEPTION = "로또는 6자리 숫자로 구성되어야합니다.";

    List<Integer> lottoTicket;

    public LottoTicket(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new RuntimeException(LOTTO_DIGIT_EXCEPTION);
        }
        lottoTicket = new ArrayList<>(numbers);
    }

    public List<Integer> getLottoTicket() {
        return this.lottoTicket;
    }
}
