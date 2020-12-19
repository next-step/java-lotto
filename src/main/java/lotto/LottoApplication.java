package lotto;

import lotto.domain.LottoGame;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        try {
            int price = InputView.purchaseAmount();
            int manualLottoCount = InputView.manualPurchaseLottoCount();
            // 로또 생성
            RandomLottoMachine randomMachine = new RandomLottoMachine(price, manualLottoCount);
            FixedLottoMachine fixedMachine = new FixedLottoMachine(InputView.manualLottoNumbers(manualLottoCount));
            LottoGame lottoGame = new LottoGame(fixedMachine, randomMachine);
            // 로또 게임 중간 상태 출력
            OutputView.lottoStatus(lottoGame.getLottoTickets(), price, manualLottoCount);
            // 당첨 로또 생성
            WinningNumber winningLotto = lottoGame.generateWinningNumber(InputView.winningNumber(), fixedMachine);
            // 보너스 볼 생성
            LottoNumber bonusBall = lottoGame.generateBonusBall(InputView.bonusBall(), randomMachine, winningLotto);
            // 로또 게임 결과 출력
            OutputView.LottoEnd(lottoGame.result(winningLotto, bonusBall));
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
