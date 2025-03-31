package lotto.domain;

import java.util.List;

import lotto.exception.LottoPriceException;
import lotto.service.LottoFactoryService;
import lotto.strategy.LottoAutoStrategy;
import lotto.strategy.LottoManualStrategy;
import lotto.vo.LottoManualTicket;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;
    private final int money;
    private final List<LottoManualTicket> tickets;

    public LottoMachine(int money, List<LottoManualTicket> tickets) {
        validateMoney(money);
        validateTickets(money, tickets);

        this.money = money;
        this.tickets = tickets;
    }

    private void validateMoney(int money) {
        if (money < LOTTO_PRICE) {
            throw new LottoPriceException("로또 구매금액은 최소 1000원 이상이어야 합니다.");
        }

        if (money % LOTTO_PRICE != 0) {
            throw new LottoPriceException("로또 구매금액은 1000원 단위로 가능합니다.");
        }
    }

    private void validateTickets(int money, List<LottoManualTicket> tickets) {
        if (money / LOTTO_PRICE < tickets.size()) {
            throw new LottoPriceException("수동 로또는 구매금액을 초과할 수 없습니다.");
        }
    }

    public List<Lotto> buyLottos() {
        List<Lotto> lottos = getManualLottos(tickets);
        lottos.addAll(getAutoLottos());
        return lottos;
    }

    private List<Lotto> getAutoLottos() {
        return new LottoFactoryService(new LottoAutoStrategy(getAutoLottoCount())).generateLottos();
    }

    private int getAutoLottoCount() {
        int totalLottoCount = money / LOTTO_PRICE;
        return totalLottoCount - tickets.size();
    }

    private List<Lotto> getManualLottos(List<LottoManualTicket> tickets) {
        return new LottoFactoryService(new LottoManualStrategy(tickets)).generateLottos();
    }
}
