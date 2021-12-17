package lotto.domain;

import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;

public class LottoTicketsFactory {

    private LottoTicketsFactory() {
    }

    public static LottoTickets buyWithMoney(String moneyString) {
        int money = toInt(moneyString);
        return buyWithMoney(money);
    }

    private static int toInt(String moneyString) {
        try {
            return Integer.parseInt(moneyString);
        } catch (NumberFormatException e) {
            throw new LottoException("구입할 로또 가격을 숫자로 입력해야합니다.");
        }
    }

    public static LottoTickets buyWithMoney(int money) {
        int numberOfLotto = money / LottoTicketFactory.getLottoPrice();
        List<LottoTicket> lottoTicketList = generateLotto(numberOfLotto);
        return new LottoTickets(new LottoWinningRules(), lottoTicketList, numberOfLotto * LottoTicketFactory.getLottoPrice());
    }

    private static List<LottoTicket> generateLotto(int numberOfLotto) {
        List<LottoTicket> lottoTicketList = new ArrayList<>();
        for (int i = 0; i < numberOfLotto; i++) {
            LottoTicket lottoTicket = LottoTicketFactory.generate();
            lottoTicketList.add(lottoTicket);
        }
        return lottoTicketList;
    }

}
