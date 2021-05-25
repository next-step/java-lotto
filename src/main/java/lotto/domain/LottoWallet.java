package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoWallet {

    private static final int LOTTO_TICKET_PRICE = 1000;

    private int countOfAutoLottoTicket;
    private List<LottoTicket> lottoTickets = new ArrayList<>();

    private LottoWallet(int countOfAutoLottoTicket) {
        this.countOfAutoLottoTicket = countOfAutoLottoTicket;
    }

    public static LottoWallet create(Money money, int countOfManualLottoTicket) {
        int userMoney = money.value();
        validationForMoney(userMoney);

        int couldBuyTicketAmount = calculateCouldBuyTicketAmount(userMoney);
        validationTicketCount(countOfManualLottoTicket, couldBuyTicketAmount);

        int countOfAutoLottoTicket = couldBuyTicketAmount - countOfManualLottoTicket;
        return new LottoWallet(countOfAutoLottoTicket);
    }

    private static void validationTicketCount(int countOfManualLottoTicket, int couldBuyTicketAmount) {
        if (couldBuyTicketAmount < countOfManualLottoTicket) {
            throw new IllegalArgumentException("수동구입 갯수가 전체 구입가능갯수를 초과할수 없습니다.");
        }
    }

    private static void validationForMoney(int userMoney) {
        if (userMoney < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException("최소 구입금액은 1000원입니다.");
        }
    }

    private static int calculateCouldBuyTicketAmount(int money) {
        return money / LOTTO_TICKET_PRICE;
    }

    public void buyingLotto(NumberGeneratorStrategy numberGeneratorStrategy, List<List<String>> manualNumbers) {
        buyingManualLottoTicket(manualNumbers);
        buyingAutoLottoTicket(numberGeneratorStrategy);
    }

    private void buyingManualLottoTicket(List<List<String>> manualNumbers) {
        for (List<String> lottoNumberText : manualNumbers) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(lottoNumberText);

            LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);
            lottoTickets.add(lottoTicket);
        }
    }

    private void buyingAutoLottoTicket(NumberGeneratorStrategy numberGeneratorStrategy) {
        for (int i = 0; i < countOfAutoLottoTicket; i++) {
            LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
            List<LottoNumber> lottoNumbers = lottoNumberGenerator.generator(numberGeneratorStrategy.generator());
            LottoTicket lottoTicket = LottoTicket.create(lottoNumbers);

            lottoTickets.add(lottoTicket);
        }
    }

    public int getAutoTicketCount() {
        return countOfAutoLottoTicket;
    }

    public int getManualTicketCount() {
        return lottoTickets.size() - countOfAutoLottoTicket;
    }

    public List<LottoTicket> takeOutLottoTickets() {
        return Collections.unmodifiableList(lottoTickets);
    }
}
