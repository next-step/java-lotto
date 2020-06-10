package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_TICKET_NUMBER_COUNT = 6;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    public List<LottoTicket> extractLottoTicketsByCount(int lottoCount) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTicketList.add(extractLottoTicket());
        }

        return lottoTicketList;
    }

    private LottoTicket extractLottoTicket() {
        List<Integer> lottoNumbers = this.lottoNumbers.getNumbers();
        this.shuffleNumbers(lottoNumbers);
        List<Integer> myLottoTicketNumbers = this.extract6Numbers(lottoNumbers);
        this.sortNumbers(myLottoTicketNumbers);

        return new LottoTicket(myLottoTicketNumbers);
    }

    private void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private List<Integer> extract6Numbers(List<Integer> numbers) {
        //Stream<Integer> sixNumbers = numbers.stream().limit(LOTTO_TICKET_NUMBER_COUNT);

        return numbers.subList(0, LOTTO_TICKET_NUMBER_COUNT);
    }
}
