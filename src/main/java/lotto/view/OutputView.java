package lotto.view;

import lotto.LottoNumber;
import lotto.LottoTicket;

import java.util.*;

public class OutputView {

    public OutputView() {
    }

    public static void printLottoTicketCount(int ticketCount) {
        System.out.println(String.format("총 %d 장의 로또 티켓을 구매했습니다.", ticketCount));
    }

    public static void printLottoNumbers(Set<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            List<Integer> sortedLottoNumbers = sortLottoNumber(lottoTicket.getLottoTicketNumbers());
            System.out.println(sortedLottoNumbers);
        }
        System.out.println();
    }

    private static List<Integer> sortLottoNumber(Set<LottoNumber> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>();
        lottoNumbers.stream().sorted(Comparator.comparing(LottoNumber::getLottoNumber))
                .forEach(lottoNumber -> sortedLottoNumbers.add(lottoNumber.getLottoNumber()));
        return sortedLottoNumbers;
    }
}
