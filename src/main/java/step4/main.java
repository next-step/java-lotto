package step4;

import java.util.Map;

import step4.domain.LottoOrder;
import step4.domain.WinningNumber;
import step4.domain.Rank;
import step4.service.LottoStatisticsService;
import step4.service.LottoValidateService;
import step4.view.InputView;
import step4.view.OutputView;

public class main {
    public static void main(String[] args) {
        // 초기 Input 및 Output class 선언
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        // 로또 구매 금액 입력 및 로또 발행
        int price = inputView.init();
        LottoOrder lottoOrder = new LottoOrder(price);
        outputView.printNumbers(lottoOrder);

        // 로또 당첨 번호 입력 및 우승자 찾기
        String winnerNumber = inputView.inputWinner();
        int bonusNumber = inputView.inputBonusNumber();
        WinningNumber winningNumber = new WinningNumber(winnerNumber, bonusNumber);

        // 로또 검증 서비스 생성 및 검증
        LottoValidateService validateService = new LottoValidateService(lottoOrder.lottos(), winningNumber);
        validateService.validateAll();
        Map<Rank, Integer> result = validateService.result();

        //로또 결과 출력
        outputView.printResult(result);
        LottoStatisticsService lottoStatisticsService = new LottoStatisticsService(lottoOrder, result);
        outputView.printRate(lottoStatisticsService.calculateRate());

    }
}
