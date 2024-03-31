package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoVendingMachine {


    private final static int lottoPrice = 1000;
    

    public List<LottoTicket> receive(int money) {
        return generate(getNumberOfLotto(money));
    }

    public int getNumberOfLotto(int money) {
        return money / lottoPrice;
    }

    private List<LottoTicket> generate(int quantity) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            lottoTickets.add(new LottoTicket());
        }
        return lottoTickets;
    }


    public Map<WinningInfo, Long> checkIfWinningEntry(List<LottoTicket> lottoTickets, List<Integer> winingNumberOfLastWeek) {
        List<WinningInfo> matchInfos = new ArrayList<>();

        for (LottoTicket lottoTicket : lottoTickets) {

            List<Integer> collect = lottoTicket.lottoNumbers.stream().map(LottoNumber::getNumber).collect(Collectors.toList());

            int result = getNumberOfMatch(winingNumberOfLastWeek, collect);
            WinningInfo matchInfo = WinningInfo.checkMatch(result);

            matchInfos.add(matchInfo);
        }

        return lottoTickets.stream()
                .map(ticket -> getNumberOfMatch(ticket.getLottoNumbers().stream().map(LottoNumber::getNumber).collect(Collectors.toList()), winingNumberOfLastWeek))
                .collect(Collectors.groupingBy(
                        matches -> WinningInfo.checkMatch(matches),
                        Collectors.counting()
                ));
    }

    public static int getNumberOfMatch(List<Integer> winingNumberOfLastWeek, List<Integer> userNumber) {
        return (int) winingNumberOfLastWeek.stream()
                .filter(userNumber::contains)
                .count();
    }
}
