package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class LottoMaker {

    public static final int LOTTO_START_NUMBER = 1;
    public static final int LOTTO_LAST_NUMBER = 45;
    public static final int LOTTO_PICK_COUNT = 6;

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoMaker() {
        setNumbers(lottoNumbers);
    }

    private void setNumbers(List<Integer> lottoNumbers) {
        IntStream.rangeClosed(LOTTO_START_NUMBER, LOTTO_LAST_NUMBER).forEach(lottoNumbers::add);
    }

    public int getLottoTicketCount(int amount) {
        return amount / 1000;
    }

    public LottoTicket buySingleLottoTicket() {
        Collections.shuffle(lottoNumbers);
        List<Integer> numbers = new ArrayList<>(lottoNumbers.subList(0, LOTTO_PICK_COUNT));
        Collections.sort(numbers);

        return new LottoTicket(numbers);
    }

    public List<LottoTicket> buyLottoTickets(int ticketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < ticketCount; i++) {
            lottoTickets.add(buySingleLottoTicket());
        }
        return lottoTickets;
    }

}
