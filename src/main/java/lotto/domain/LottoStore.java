package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketGroup;
import lotto.domain.lotto.LottoTicketGroupFactory;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class LottoStore {
    public static final String NOT_ENOUGH_MONEY_TO_BUY_LOTTO = "not enough money to buy lotto";
    
    public static LottoTicketGroup sell(final Money money) {
        return sell(money, LottoTicketGroup.EMPTY);
    }

    /**
     * 로또 판매
     *
     * @param money                지불 금액
     * @param manualLottoTicketGroup 수동으로 구매하기 원하는 로또
     * @return
     */
    public static LottoTicketGroup sell(final Money money, final LottoTicketGroup manualLottoTicketGroup) {
        if (Objects.isNull(manualLottoTicketGroup)) {
            return sellByQuickPicks(money, 0);
        }

        final int manualLottoCount = manualLottoTicketGroup.size();
        final LottoTicketGroup quickPickLottoTicketGroup = sellByQuickPicks(money, manualLottoCount);

        return LottoTicketGroup.combine(manualLottoTicketGroup, quickPickLottoTicketGroup);
    }

    private static LottoTicketGroup sellByQuickPicks(final Money money, final int manualLottoCount) {
        if (Objects.isNull(money)) {
            return LottoTicketGroup.EMPTY;
        }

        final long lottoTotalCount = money.divideWithoutRemainder(LottoTicket.getPrice());
        checkArgument(lottoTotalCount >= manualLottoCount, NOT_ENOUGH_MONEY_TO_BUY_LOTTO);

        final long quickPicksLottoCount = lottoTotalCount - manualLottoCount;
        return LottoTicketGroupFactory.create(quickPicksLottoCount);
    }

}
