package auto_lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VendingMachine {


     private final static int lottoPrice = 1000;
    private int count;

    public LottoTickets insert(int money) {
        int available = available(money);
        return printLotto(available);
    }

    public int available(int money) {
        return money / lottoPrice;
    }

    public LottoTickets printLotto(int numberOfLotto) {

        LottoTickets lottoTickets = new LottoTickets();

        for (int i = 0; i < numberOfLotto; i++) {
            RandomNumber randomNumber = new RandomNumber();
            lottoTickets.lottoTickets.add(new LottoTicket(randomNumber));
        }
        return lottoTickets;
    }
}
