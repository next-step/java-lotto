package lotto;

import lotto.domain.LottoGame;
import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {
    public static void main(String[] args) {
        LottoGame lottoGame = new LottoGame();
        try {
            // 구입 금액 입력
            int price = InputView.purchaseAmount();
            // 수동 구매 로또 수 입력
            int manualPurchaseLottoCount = InputView.manualPurchaseLottoCount();
            // 수동 로또 생성
            FixedLottoMachine fixedLottoMachine = new FixedLottoMachine(InputView.manualPurchaseLottoNumbers(manualPurchaseLottoCount));
            LottoTickets fixedLottoTickets = lottoGame.generateLottoTickets(fixedLottoMachine);
            // 자동 로또 생성
            RandomLottoMachine randomLottoMachine = new RandomLottoMachine(lottoGame.calculateRemainingMoney(price, manualPurchaseLottoCount));
            LottoTickets randomLottoTickets = lottoGame.generateLottoTickets(randomLottoMachine);
            // 혼합 로또 생성
            LottoTickets mixedLottoTickets = lottoGame.generateMixedLottoTickets(fixedLottoTickets, randomLottoTickets);
            // 로또 게임 중간 상태 표시
            OutputView.lottoStatus(lottoGame, fixedLottoTickets, randomLottoTickets);
            // 당첨 로또 생성
            WinningNumber winningLotto = lottoGame.generateWinningNumber(InputView.winningNumber(), randomLottoMachine);
            // 보너스 볼 생성
            LottoNumber bonusBall = lottoGame.generateBonusBall(InputView.bonusBall(), randomLottoMachine, winningLotto);
            // 로또 게임 결과 생성
            LottoResult result = lottoGame.result(mixedLottoTickets, winningLotto, bonusBall);
            OutputView.LottoEnd(result);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }
}
