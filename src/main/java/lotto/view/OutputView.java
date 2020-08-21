package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.WinningPrize;

import java.util.*;

public class OutputView {

    public OutputView() {
    }

    public OutputView printPurchaseTicketCount(int ticketCount) {
        System.out.println(String.format("총 %d 장의 로또 티켓을 구매했습니다.", ticketCount));
        return this;
    }

    public OutputView printLottoNumbers(Set<LottoTicket> lottoTickets) {
        for (LottoTicket lottoTicket : lottoTickets) {
            List<Integer> sortedLottoNumbers = sortLottoNumber(lottoTicket.getLottoTicketNumbers());
            System.out.println(sortedLottoNumbers);
        }
        System.out.println();
        return this;
    }

    private List<Integer> sortLottoNumber(Set<LottoNumber> lottoNumbers) {
        List<Integer> sortedLottoNumbers = new ArrayList<>();
        lottoNumbers.stream().sorted(Comparator.comparing(LottoNumber::getLottoNumber)).forEach(lottoNumber -> sortedLottoNumbers.add(lottoNumber.getLottoNumber()));
        return sortedLottoNumbers;
    }

    public OutputView printLottoResults(Map<WinningPrize, Integer> lottoResult) {
        System.out.println("[당첨 통계]\n" + "========================");
        lottoResult.entrySet().forEach(result -> {
            System.out.print(result.getKey().getMessage());
            System.out.println(String.format("(%d 원) - %d 개", result.getKey().getPrize(), result.getValue()));
        });
        System.out.println();
        return this;
    }

    public OutputView printPrizeRate(int calculatePrizeRate) {
        System.out.println(String.format("총 수익률은 %d", calculatePrizeRate) + "% 입니다.");
        return this;
    }
}
