package lotto.main;

import lotto.controller.MatchResult;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args) {
        Lotto lotto = new Lotto();
        InputView input = new InputView();
        Buyer buyer = new Buyer();
        // 로또 입력
        // 금액 입력
        OutputView.printBuy();
        int amount = input.inputAmount();
        // 로또 실행
        // 구매
        // 구매 수량 확인
        int lottos = buyer.matchPriceAndPayment(amount);
        OutputView.printBuyerTickets(lottos);
        MatchResult result = new MatchResult(lottos);
        // Buy Lotto
        List<LottoTicket> tickets = buyer.buyLotto(amount);
        // 구매자 로또 정보 메시지


        OutputView.printBuyTicketsNumbers(tickets);

        // 로또 당첨 번호
        OutputView.printLottoMsg();
        OutputView.printLottoNumbers(lotto.getLottoTicket());
        // 로또 보너스 번호
        OutputView.printBonusMsg();
        OutputView.printBonusNumber(lotto.getLottoTicket());

        // Match Lotto
        result.countUpMatch(lotto, tickets);

        // return result to output view
        List<Integer> res = result.getResult();
        Double resRevenue = result.CalculateWinningRevenue();
        // 로또 결과 메시지
        OutputView.printResult(res);
        // 통계 출력 메시지
        OutputView.printRevenue(resRevenue);
    }
}