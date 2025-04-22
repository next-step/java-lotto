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
        InputView in = new InputView();
        OutputView out = new OutputView();

        // 로또 구매 금액 입력 및 로또 발행
        LottoOrder order = in.readLottoOrder();
        out.printPurchase(order);

        // 로또 당첨 번호 입력 및 우승자 찾기
        WinningNumber winningNumber = in.readWinningNumber();

        // 로또 검증 서비스 생성 및 검증
        LottoValidateService validateService = new LottoValidateService(winningNumber);
        Map<Rank, Integer> result = validateService.validate(order.lottos());

        // 결과 출력
        out.printResult(result);

        // 통게 출력
        double rate = LottoStatisticsService.of(order, result).calculateRate();
        out.printRate(rate);
    }
}
