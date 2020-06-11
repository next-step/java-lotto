package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    private static final int LOTTO_TICKET_NUMBER_COUNT = 6;
    private static final int COMPARE_SAME_NUMBER_COUNT = 1;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    public List<LottoTicket> extractLottoTicketsByCount(int lottoCount) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottoTicketList.add(extractLottoTicket());
        }

        return lottoTicketList;
    }

    public List<Integer> checkLottoWinning(LottoTicket winningNumberTicket, List<LottoTicket> lottoTicketList) {
        return lottoTicketList.stream().map(lottoTicket -> compareLottoNumber(winningNumberTicket, lottoTicket)).collect(Collectors.toList());
    }

    private int compareLottoNumber(LottoTicket winningNumberTicket, LottoTicket lottoTicket) {
        List<Integer> myLottoNumbers = lottoTicket.getNumbers();
        List<Integer> winningNumbers = winningNumberTicket.getNumbers();

        return (int) winningNumbers.stream().filter(winningNumber
                -> compareLottoNumber(winningNumber, myLottoNumbers)).count();
    }

    private boolean compareLottoNumber(int winningNumber, List<Integer> myLottoNumbers) {
        return COMPARE_SAME_NUMBER_COUNT == myLottoNumbers.stream().filter(myLottoNumber
                                                -> myLottoNumber == winningNumber).count();
    }

    private LottoTicket extractLottoTicket() {
        List<Integer> lottoNumbers = this.lottoNumbers.getNumbers();
        this.shuffleNumbers(lottoNumbers);
        List<Integer> myLottoTicketNumbers = this.extract6Numbers(lottoNumbers);
        this.sortNumbers(myLottoTicketNumbers);

        return LottoTicket.makeLottoTicket(myLottoTicketNumbers);
    }

    private void shuffleNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    private List<Integer> extract6Numbers(List<Integer> numbers) {
         return numbers.stream().map(Integer::new).limit(LOTTO_TICKET_NUMBER_COUNT).collect(Collectors.toList());
    }
}
