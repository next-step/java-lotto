package lotto;

import lotto.model.LottoTicket;
import lotto.model.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("구입할 금액을 입력하세요.");
        Money money = Money.wons(14000);
        LottoTicket lottoTicket = LottoMachine.buy(money);

        System.out.println("당첨번호를 입력하세요.");
        String input = "1,2,3,4,5,6";




        LottoGenerator.generate();

    }
}
