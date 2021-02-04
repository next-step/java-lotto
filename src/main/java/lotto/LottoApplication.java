package lotto;


import lotto.controller.LottoGenerator;
import lotto.wrapper.Count;
import lotto.wrapper.Money;
import lotto.controller.MatchResult;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    private static Lotto lotto;
    private static InputView input;
    private static Buyer buyer;
    private static List<LottoTicket> tickets;
    private static MatchResult result;
    static Count lottos;
    static Money amount;
    static Count lottosManual;
    static Money randomAmount;
    static Count lottosRandom;
    static List<String> lottosManualRaw;

    public static void main(String[] args) {
        try {
            init();
            buyLotto();
            confirmLotto();
            result();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() {
        lotto = new Lotto();
        input = new InputView();
        buyer = new Buyer();
    }
    private static void buyLottoManual() {
        // 수동 구매 수량을 결정.
        OutputView.printManual(); // 수동으로 구매 할 수를 입력하세요.
        lottosManual = input.inputAmountManual(); // 수동 입력.
        randomAmount = Money.subManual(amount, lottosManual);
        lottosRandom = Count.split(lottos, lottosManual); // lottos에 전체 수량 - 수동 수량 을 해 주는 메서드 생성. 메서드는 new Count(res)를 반환.

        OutputView.printSelectManual(); // 로또 수동 입력 하라는 프린트.
        lottosManualRaw = input.selectLottosManually(lottosManual);
        tickets = LottoGenerator.rawToTicktes(lottosManualRaw); // 수동으로 입력하기.
    }
    private static void buyLorroRandom() {
        tickets.addAll(buyer.buyLotto(randomAmount));// 자동 구매 수량에 따라 티켓 생성.
    }
    private static void buyLotto() {
        // 로또 입력
        // 금액 입력
        OutputView.printBuy();
        amount = input.inputAmount();
        // 구매 가능 수량이 lottos로 담김.
        lottos = buyer.matchPriceAndPayment(amount);
        buyLottoManual();
        buyLorroRandom();

        // 로또 실행
        // 구매
        // 구매 수량 확인
        OutputView.printBuyerTickets(lottosManual, lottosRandom); // 수동으로 a 개, 자동으로 b 개 구매했습니다.
        result = new MatchResult(Count.sum(lottosManual, lottosRandom));
        // 구매자 로또 정보 메시지
        OutputView.printBuyTicketsNumbers(tickets);
    }

    private static void confirmLotto() {
        // 로또 당첨 번호
        OutputView.printLottoMsg();
        OutputView.printLottoNumbers(lotto.getLottoTicket());
        // 로또 보너스 번호
        OutputView.printBonusMsg();
        OutputView.printBonusNumber(lotto.getLottoTicket());

        // Match Lotto
        result.countUpMatch(lotto, tickets);
    }

    private static void result() {
        // return result to output view
        List<Count> res = result.getResult();
        Double resRevenue = result.calculateWinningRevenue();
        // 로또 결과 메시지
        OutputView.printResult(res);
        // 통계 출력 메시지
        OutputView.printRevenue(resRevenue);
    }
}
