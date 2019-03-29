package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.UserLottoTickets;
import lotto.domain.WiningLottoTicket;
import spark.Request;

import java.util.List;

public class WebService {

    public static LotteryResults createLotteryResult(Request request) {
        UserLottoTickets userLottoTickets = request.session().attribute("userLottoTickets");
        LottoTicket winningNumber = StringParseUtils.parseToLottoTicket(request.queryParams("winningNumber"));
        LottoNumber bonusNumber = LottoNumber.getBasicNumber(Integer.parseInt(request.queryParams("bonusNumber")));
        WiningLottoTicket winingLottoTicket = new WiningLottoTicket(winningNumber, bonusNumber);
        return new LotteryResults(winingLottoTicket, userLottoTickets);
    }

    public static UserLottoTickets createUserLottoTickets(Money money, Request req) {
        String manualNumber = req.queryParams("manualNumber");
        String[] manualNumbers = manualNumber.split("\n");
        List<LottoTicket> manualTicket = StringParseUtils.parseToLottoTickets(manualNumbers);
        LottoMachine lottoMachine = new LottoMachine(new UserLottoTicketGenerator());
        return lottoMachine.buyLottoTicket(money, manualTicket);
    }

    public static Money createMoney(Request req) {
        String inputMoney = req.queryParams("inputMoney");
        int money = Integer.parseInt(inputMoney);
        return new Money(money);
    }

}
