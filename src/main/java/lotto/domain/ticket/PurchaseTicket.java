package lotto.domain.ticket;

import java.util.List;
import lotto.domain.LottoGameManager;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.machine.RandomLottoGenerator;

public class PurchaseTicket {

    private static final String MANUAL_TICKET_COUNT_ERROR_LOG = "수동으로 구매할 로또 수는 전체 금액을 초과할 수 없습니다.";
    private static final String TICKET_ERROR_MESSAGE = "최소 구매 금액은 1,000원입니다.";
    private static final int TICKET_PRICE = 1000;

    private final int buyTotalCount;
    private int buyManualCount;

    public PurchaseTicket(final Money money) {
        if (money.getValue() < TICKET_PRICE) {
            throw new IllegalArgumentException(TICKET_ERROR_MESSAGE);
        }
        this.buyTotalCount = money.getValue() / TICKET_PRICE;
    }

    public PurchaseTicket(final Money money, int buyManualCount) {
        this(money);
        validateManualCount(buyManualCount, buyTotalCount);
        this.buyManualCount = buyManualCount;
    }

    private void validateManualCount(final int manualCount, final int totalCount) {
        if (manualCount > totalCount) {
            throw new IllegalArgumentException(MANUAL_TICKET_COUNT_ERROR_LOG);
        }
    }

    public Lottos purchase(final List<Lotto> getManualLottos) {
        List<Lotto> lottoGames = getManualLottos;
        lottoGames.addAll(LottoGameManager.getLottosByAuto(new RandomLottoGenerator(), getBuyAutoCount()));
        return new Lottos(lottoGames);
    }

    public int getBuyManualCount() {
        return this.buyManualCount;
    }

    public int getBuyAutoCount() {
        return this.buyTotalCount - this.buyManualCount;
    }

    public int getBuyCash() {
        return this.buyTotalCount * TICKET_PRICE;
    }

    public int getBuyTotalCount() {
        return this.buyTotalCount;
    }
}
