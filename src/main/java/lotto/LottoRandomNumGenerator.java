package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomNumGenerator implements LottoNumGenerator {
    private static final int LOTTO_TOTAL_NUM = 45;
    private static final int LOTTO_TICKET_LIMIT_NUM = 6;
    private static final int LOTTO_TICKET_MIN_NUM = 1;
    private final List<Integer> lottoNumbers;

    public LottoRandomNumGenerator() {
        this.lottoNumbers = createNumbers();
    }

    protected void shuffleNum(List<Integer> lottoNumbers) {
        Collections.shuffle(lottoNumbers);
    }

    @Override
    public List<Integer> generateTicket() {
        List<Integer> ticket = new ArrayList<>();
        shuffleNum(lottoNumbers);
        for (int i = 0; i < LOTTO_TICKET_LIMIT_NUM; i++) {
            ticket.add(lottoNumbers.get(i));
        }
        Collections.sort(lottoNumbers);
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
