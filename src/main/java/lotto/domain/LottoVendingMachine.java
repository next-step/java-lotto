package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoVendingMachine {


    private final static int lottoPrice = 1000;


    public List<LottoTicket> receive(int money) {
        return generate(getNumberOfLotto(money));
    }

    public int getNumberOfLotto(int money) {
        return money / lottoPrice;
    }

    private List<LottoTicket> generate(int quantity) {
        return IntStream.range(0, quantity)
                .mapToObj(target -> new LottoTicket())
                .collect(Collectors.toList());
    }

    public LottoResult match(List<LottoTicket> lottoTickets, List<Integer> lastWeekLottoNumber) {
        return new LottoResult(lottoTickets, lastWeekLottoNumber);
    }
}
