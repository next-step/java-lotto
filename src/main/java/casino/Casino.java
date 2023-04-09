package casino;

import order.LottoOrder;
import configuration.LottoConfiguration;
import configuration.WinnerType;
import exception.CasinoException;
import lotto.*;

import java.util.ArrayList;
import java.util.List;

public class Casino {

    public Casino() {}

    public static List<Lotto> buyLottery(int money) {
        int enableTicketCount = payForLotto(money);
        return publishAutoLotto(enableTicketCount);
    }

    public static List<Lotto> buyLotteryWithManual(LottoOrder order, List<List<Integer>> manualLottoNumber) {
        int enableTicketCount = payForLotto(order.getMoney());
        List<Lotto> lottoTickets = new ArrayList<>();
        int enableAutoLottoCount = enableTicketCount - order.getManualTicketCounts();
        lottoTickets.addAll(publishManualLotto(order.getManualTicketCounts(), manualLottoNumber));
        lottoTickets.addAll(publishAutoLotto(enableAutoLottoCount));
        return lottoTickets;
    }

    private static int payForLotto(int money) {
        CasinoException.validatePay(money);
        return money/LottoConfiguration.LOTTO_UNIT;
    }

    private static List<Lotto> publishAutoLotto(int count) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i=0; i < count; i++ ) {
            lottoTickets.add(LottoFactory.auto());
        }
        return lottoTickets;
    }

    private static List<Lotto> publishManualLotto(int count, List<List<Integer>> manualLottoNumber) {
        CasinoException.validateManualTicketsCounts(count, manualLottoNumber.size());
        List<Lotto> lottoTickets = new ArrayList<>();
        for(int i=0; i < count; i++ ) {
            lottoTickets.add(LottoFactory.manualLotto(manualLottoNumber.get(i)));
        }
        return lottoTickets;
    }


    public static WinnerType match(Lotto userLotto, WinningLotto winningLotto) {
        return LottoGame.match(userLotto, winningLotto);
    }
}
