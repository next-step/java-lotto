import domain.*;
import view.InputView;
import view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoMachine lottoMachine = new LottoMachine();
        // 로또 생성
        LottoTickets lottoTickets = lottoMachine.generate(InputView.lottoStart());
        OutputView.lottoStatus(lottoTickets);
        // 당첨 로또 생성
        WinningNumber winningNumber = WinningNumber.generateWinningNumber(InputView.winningNumber());

        // 보너스 볼 생성
        LottoNumber bonusBall = LottoNumber.generateBonusBall(InputView.bonusBall(), winningNumber);

        // 로또 게임 결과 생성
        LottoResult lottoResult = LottoResult.result(lottoTickets, winningNumber, bonusBall);
        OutputView.LottoEnd(lottoResult);
    }
}