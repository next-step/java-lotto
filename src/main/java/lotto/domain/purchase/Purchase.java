package lotto.domain.purchase;

import lotto.domain.lotto.generate.Generate;
import lotto.domain.lotto.ticket.LottoTicket;
import lotto.domain.lotto.ticket.LottoTickets;

public class Purchase {
    private final Money money;
    private final PassivityLottoCount passivityLottoCount;
    private final Generate lottoGenerate;
    private final LottoTickets lottoTickets;

    public Purchase(int money,Generate lottoGenerate, LottoTickets lottoTickets) {
        this(new Money(money), new PassivityLottoCount(0), lottoGenerate, lottoTickets);
    }

    public Purchase(int money, int passivityLottoCount, Generate lottoGenerate, LottoTickets lottoTickets) {
        this(new Money(money), new PassivityLottoCount(passivityLottoCount), lottoGenerate, lottoTickets);
    }

    public Purchase(Money money, PassivityLottoCount passivityLottoCount, Generate lottoGenerate, LottoTickets lottoTickets) {
        this.money = money;
        this.passivityLottoCount = passivityLottoCount;
        this.lottoGenerate = lottoGenerate;
        this.lottoTickets = lottoTickets;
    }

    public int purchaseAutoLottoCount() {
        return passivityLottoCount.autoLottoCount(this.money.purchaseLottoCount());
    }

    public int purchasePassivityLottoCount() {
        return passivityLottoCount.getPassivityLottoCount();
    }

    public int purchaseAllLottoCount() {
        return this.money.purchaseLottoCount();
    }

    public LottoTickets purchaseAutoLotto() {
        int purchaseAutoLottoCount = purchaseAutoLottoCount();
        for (int i = 0; i < purchaseAutoLottoCount; i++) {
            LottoTicket ticket = lottoGenerate.generate();
            add(ticket);
        }

        return this.lottoTickets;
    }

    private void add(LottoTicket ticket) {
        lottoTickets.add(ticket);
    }





}
