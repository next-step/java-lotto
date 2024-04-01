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

    public LottoResult match(List<LottoTicket> lottoTickets, List<Integer> lastWeekLottoNumber) {
        return new LottoResult(lottoTickets, lastWeekLottoNumber);
    }
}
