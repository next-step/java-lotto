package lotto;

import lotto.domain.LottoNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLottoTicketGenerator {
    private static final int LOTTO_TOTAL_NUM = 45;
    private static final int LOTTO_TICKET_LIMIT_NUM = 6;
    private static final int LOTTO_TICKET_MIN_NUM = 1;

    private final List<Integer> lottoNumbers;

    public UserLottoTicketGenerator() {
        this.lottoNumbers = createNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public void shuffleNum(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    public List<LottoNumber> generateTicket() {
        Collections.sort(lottoNumbers);
        List<LottoNumber> ticket = new ArrayList<>();
        shuffleNum(lottoNumbers);
        for (int i = LOTTO_TICKET_MIN_NUM - 1; i < LOTTO_TICKET_LIMIT_NUM; i++) {
            ticket.add(LottoNumber.getBasicNumber(lottoNumbers.get(i)));
        }
        return ticket;

    }

    private List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = LOTTO_TICKET_MIN_NUM; i <= LOTTO_TOTAL_NUM; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
