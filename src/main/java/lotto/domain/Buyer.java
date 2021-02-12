package lotto.domain;

import lotto.wrapper.Count;
import lotto.wrapper.Money;

import java.util.List;

public class Buyer {
    private List<LottoTicket> tickets;
    private Count lottosManual;
    private Money randomAmount;
    private Count lottosRandom;

    public Count getLottosManual() {
        return lottosManual;
    }

    public void setLottosManual(Count lottosManual) {
        this.lottosManual = lottosManual;
    }

    public Count getLottosRandom() {
        return lottosRandom;
    }

    public List<LottoTicket> getTickets() {
        return tickets;
    }

    public Count matchPriceAndPayment(Money input) {
        return new Count(input.getMoney() / Lotto.LOTTO_PRICE.getMoney());
    }

    public void splitManual(Money amount, Count lottos, Count lottosManual) {
        randomAmount = Money.subManual(amount, lottosManual);
        lottosRandom = Count.split(lottos, lottosManual); // lottos에 전체 수량 - 수동 수량 을 해 주는 메서드 생성. 메서드는 new Count(res)를 반환.
    }

    public void buyTicketsManual(List<String> lottosManualRaw) {
        tickets = LottoGenerator.rawToTickets(lottosManualRaw); // 수동으로 입력하기.
    }

    public void buyTicketsRandom() {
        Count lottoCount = matchPriceAndPayment(randomAmount);
        for (int i = 0; i < lottoCount.getCount(); i++) {
            tickets.add(LottoGenerator.generateLotto(i));
        }
    }

}
