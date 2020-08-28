package step3.domain;

import cmm.util.InputUtil;
import step3.view.PrintResult;

import java.util.List;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    private int buyPrice;

    public LottoGame(int buyPrice) {
        if (buyPrice < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매금액은 1000원 이상으로 입력해주세요");
        }
        this.buyPrice = buyPrice;
    }

    public void playLottoGame() {
        LottoFactory makeLotto = new LottoFactory();
        PrintResult.printBuyQuantity(buyQuantity());

        List<Lotto> lottoList = makeLotto.makeLottoRandomList(buyQuantity());
        PrintResult.printLottoList(lottoList);

        String winningNumbers = InputUtil.returnString("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLottoNumber = makeLotto.makeLottoWithString(winningNumbers);

        int bonusBallNumber = InputUtil.returnInteger("보너스 볼을 입력해 주세요.");

        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, new LottoNumber(bonusBallNumber));
        WinningStatistics winningStatistics = new WinningStatistics(lottoList, winningLotto);
        WinningJudgement winneingJudgement = new WinningJudgement(winningLotto);

        PrintResult.printLottoMap(winneingJudgement.makeWinningMap(lottoList));
        PrintResult.printResult(winningStatistics.getWinningStatic(), winningStatistics.isBenefit());
    }

    public int buyQuantity() {
        return buyPrice / LOTTO_PRICE;
    }
}
