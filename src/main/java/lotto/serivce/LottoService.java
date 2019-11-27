package lotto.serivce;

import lotto.domain.*;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.LOTTO_PRICE;

public class LottoService {
    private static final int MIN_LOTTO_COUNT = 0;

    public static LottoTickets buyTickets(int purchaseAmount, List<String> manualLottos) {
        Price price = new Price(purchaseAmount);

        int autoCount = price.countLotto() - manualLottos.size();

        System.out.println(autoCount);

        List<LottoTicket> tickets = manualLottos.stream()
                .map(LottoTicket::ofString)
                .collect(Collectors.toList());

        if (autoCount > MIN_LOTTO_COUNT) {
            tickets.addAll(buyTickets(autoCount * LOTTO_PRICE));
        }

        return new LottoTickets(tickets);
    }

    public static List<LottoTicket> buyTickets(int inputPrice) {
        Price price = new Price(inputPrice);

        int lottoCount = price.countLotto();

        return new LottoTickets(lottoCount).getLottoTickets();
    }

    public static Winner match(LottoTickets lottoTickets, WinningLotto winningLotto) {
        int lottoTicketsSize = lottoTickets.size();

        Winner winner = new Winner(lottoTickets, winningLotto);
        return winner.ofProfit(lottoTicketsSize);
    }
}
