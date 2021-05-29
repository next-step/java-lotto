import domain.*;
import view.InputView;
import view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        int price = InputView.purchaseAmount();
        int manualLottoCount = InputView.manualPurchaseLottoCount();

        LottoTickets manualLottos = InputView.manualLottoNumbers(manualLottoCount);

        LottoTickets autoLottoTickets = lottoMachine.autoGenerate(price, manualLottos);

        OutputView.lottoStatus(autoLottoTickets, manualLottos);

        // 당첨 로또 생성
        WinningNumber winningNumber = WinningNumber.generateWinningNumber(InputView.winningNumber());

        // 보너스 볼 생성
        LottoNumber bonusBall = LottoNumber.generateBonusBall(InputView.bonusBall(), winningNumber);
        
        // 수동 개수 더하기 자동 개수
        LottoTickets concatTickets = manualLottos.concat(autoLottoTickets);

        // 로또 게임 결과 생성
        LottoResult lottoResult = LottoResult.result(concatTickets, winningNumber, bonusBall);
        OutputView.LottoEnd(lottoResult);
    }
}