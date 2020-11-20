package lotto.domain;

import lotto.domain.lotto.LottoTicket;
import lotto.domain.lotto.LottoTicketGroup;
import lotto.domain.lotto.LottoTicketsFactory;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class LottoStore {

    public static LottoTicketGroup sell(final Money money) {
        return sell(money, LottoTicketGroup.EMPTY);
    }

    /**
     * 로또 판매
     *
     * @param money                지불 금액
     * @param slipLottoTicketGroup 수동으로 구매하기 원하는 로또
     * @return
     */
    public static LottoTicketGroup sell(final Money money, final LottoTicketGroup slipLottoTicketGroup) {
        if (Objects.isNull(slipLottoTicketGroup)) {
            return sellByQuickPicks(money, 0);
        }

        final int slipLottoCount = slipLottoTicketGroup.size();
        final LottoTicketGroup quickPickLottoTicketGroup = sellByQuickPicks(money, slipLottoCount);

        return LottoTicketGroup.combine(slipLottoTicketGroup, quickPickLottoTicketGroup);
    }

    private static LottoTicketGroup sellByQuickPicks(final Money money, final int slipLottoCount) {
        if (Objects.isNull(money)) {
            return LottoTicketGroup.EMPTY;
        }

        final int lottoTotalCount = money.divideWithoutRemainder(LottoTicket.getPrice());
        checkArgument(lottoTotalCount >= slipLottoCount, "");

        final int quickPicksLottoCount = lottoTotalCount - slipLottoCount;
        return LottoTicketsFactory.create(quickPicksLottoCount);
    }

}
