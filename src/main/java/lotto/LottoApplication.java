package lotto;

import lotto.wrapper.Count;
import lotto.wrapper.Money;
import lotto.controller.MatchResult;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    private static Lotto lotto;
    private static InputView input;
    private static Buyer buyer;
    private static List<LottoTicket> tickets;
    private static MatchResult result;
    public static void main(String[] args) {
        try {
            init();
            buyLotto();
            confirmLotto();
            result();
        }
        catch (IllegalArgumentException iae){
            iae.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    private static void init () {
        lotto = new Lotto();
        input = new InputView();
        buyer = new Buyer();
    }
    private static void buyLotto () {
        // 로또 입력
        // 금액 입력
        OutputView.printBuy();
        Money amount = input.inputAmount();
        // 로또 실행
        // 구매
        // 구매 수량 확인
        Count lottos = buyer.matchPriceAndPayment(amount);
        OutputView.printBuyerTickets(lottos);
        result = new MatchResult(lottos);
        // Buy Lotto
        tickets = buyer.buyLotto(amount);
        // 구매자 로또 정보 메시지
        OutputView.printBuyTicketsNumbers(tickets);
    }
    private static void confirmLotto () {
        // 로또 당첨 번호
        OutputView.printLottoMsg();
        OutputView.printLottoNumbers(lotto.getLottoTicket());
        // 로또 보너스 번호
        OutputView.printBonusMsg();
        OutputView.printBonusNumber(lotto.getLottoTicket());

        // Match Lotto
        result.countUpMatch(lotto, tickets);
    }
    private static void result () {
        // return result to output view
        List<Count> res = result.getResult();
        Double resRevenue = result.CalculateWinningRevenue();
        // 로또 결과 메시지
        OutputView.printResult(res);
        // 통계 출력 메시지
        OutputView.printRevenue(resRevenue);
    }
}
