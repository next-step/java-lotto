package lotto;


import lotto.domain.*;
import lotto.wrapper.Count;
import lotto.wrapper.Money;
import lotto.controller.CheckResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoApplication {
    private static Lotto lotto;
    private static Buyer buyer;
    private static CheckResult checker;
    static Count lottos;
    static Money amount;
    static Count lottosManual;
    static List<String> lottosManualRaw;

    public static void main(String[] args) {
        try {
            init();
            buyLotto();
            confirmLotto();
            resultLotto();
        } catch (IllegalArgumentException iae) {
            iae.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void init() {
        lotto = new Lotto();
        buyer = new Buyer();
    }

    private static void buyLottoManual() {
        // 수동 구매 수량을 결정.
        OutputView.printManual(); // 수동으로 구매 할 수를 입력하세요.
        lottosManual = InputView.inputAmountManual(); // 수동 입력.
        buyer.setLottosManual(lottosManual);
        buyer.splitManual(amount, lottos, lottosManual);
        OutputView.printSelectManual(); // 로또 수동 입력 하라는 프린트.
        lottosManualRaw = InputView.selectLottosManually(buyer.getLottosManual());
        buyer.buyTicketsManual(lottosManualRaw);
    }

    private static void buyLottoRandom() {
        buyer.buyTicketsRandom();
    }

    private static void buyLotto() {
        // 로또 입력
        // 금액 입력
        OutputView.printBuy();
        amount = InputView.inputAmount();
        // 구매 가능 수량이 lottos로 담김.
        lottos = buyer.matchPriceAndPayment(amount);
        buyLottoManual();
        buyLottoRandom();

        // 구매
        // 구매 수량 확인
        OutputView.printBuyerTickets(buyer.getLottosManual(), buyer.getLottosRandom()); // 수동으로 a 개, 자동으로 b 개 구매했습니다.
        OutputView.printBuyTicketsNumbers(buyer.getTickets());
    }

    private static void confirmLotto() {
        // 로또 체크 할 인스턴스 생성
        checker = new CheckResult(Count.sum(buyer.getLottosManual(), buyer.getLottosRandom()));
        // 로또 당첨 번호
        OutputView.printLottoMsg();

        inputWinningLottoNumbers();
        inputBonusLottoNumber();

        // Match Lotto
        checker.countUpMatch(lotto, buyer.getTickets());
    }

    private static void inputWinningLottoNumbers() {
        String lottoWinningNumbers = InputView.inputOneLotto();
        LottoTicket ticket = LottoGenerator.rawToTicket(lottoWinningNumbers); // 수동으로 입력하기.
        lotto.setLottoNumbers(ticket);
    }

    private static void inputBonusLottoNumber() {
        // 로또 보너스 번호
        OutputView.printBonusMsg();
        LottoNumber bonusLottoNumber = InputView.inputBonus();
        lotto.setBonusNumber(bonusLottoNumber);
    }

    private static void resultLotto() {
        // return result to output view
        List<Count> res = checker.getResult();
        Double resRevenue = checker.calculateWinningRevenue();        // 로또 결과 이전 메시지
        OutputView.printBeforeResult();
        // 로또 결과 메시지
        OutputView.printResult(res);
        // 통계 출력 메시지
        OutputView.printRevenue(resRevenue);
    }
}
