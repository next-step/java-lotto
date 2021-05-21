package lotto.domain;

import lotto.utils.LottoNumberGenerator;
import lotto.utils.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int countOfLottoTicket;
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    private LottoWallet(int countOfLottoTicket) {
        this.countOfLottoTicket = countOfLottoTicket;
    }

    public static LottoWallet create(Money money) {
        int userMoney = money.value();

        if (userMoney < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("최소 구입금액은 1000원입니다.");
        }

        int couldBuyTicketAmount = calculateCouldBuyTicketAmount(userMoney);
        return new LottoWallet(couldBuyTicketAmount);
    }

    private static int calculateCouldBuyTicketAmount(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    public void buyingLotto() {
        for (int i = 0; i < countOfLottoTicket; i++) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(RandomNumberGenerator.randomSixNumbers());
            LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

            lottoTickets.add(lottoTicket);
        }
    }

    public int getTicketCount() {
        return countOfLottoTicket;
    }

    public List<LottoTicket> takeOutLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
