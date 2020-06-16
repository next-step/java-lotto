package step3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int number = 6;
    private final List<Integer> numbers = new ArrayList<>();

    public LottoNumbers() {
        for (int i = 1 ; i <= 45 ; i++) {
            numbers.add(i);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public List<LottoTicket> extractLottoTicketsByCount(int lottoCount) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTicketList.add(extractLottoTicket());
        }

        return lottoTicketList;
    }

    private LottoTicket extractLottoTicket() {
        Collections.shuffle(numbers);
        List<Integer> myLottoTicketNumbers = this.extract6Numbers(numbers);
        Collections.sort(myLottoTicketNumbers);

        return LottoTicket.newLottoTicket(myLottoTicketNumbers);
    }

    private List<Integer> extract6Numbers(List<Integer> numbers) {
        return numbers.stream().map(Integer::new).limit(number).collect(Collectors.toList());
    }
}
