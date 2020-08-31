package step4.domain;

import cmm.util.InputUtil;
import com.sun.java.swing.plaf.windows.WindowsMenuBarUI;
import step4.view.PrintResult;

import java.util.List;
import java.util.Map;

public class LottoGame {

    public static final int LOTTO_PRICE = 1000;
    private int buyPrice;
    private int manualQuantity;

    public LottoGame(int buyPrice, int manualQuantity) {
        priceValidation(buyPrice);
        this.buyPrice = buyPrice;
        manualQuantityValidation(manualQuantity);
        this.manualQuantity = manualQuantity;
    }

    private void priceValidation(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("구매금액은 1000원 이상으로 입력해주세요");
        }
    }

    private void manualQuantityValidation(int manualQuantity) {
        if (buyQuantity() < manualQuantity) {
            throw new IllegalArgumentException("수동으로 구매할 수 있는 개수가 아닙니다." + buyQuantity() + "이하로 입력해주세요.");
        }
    }

    public void playLottoGame() {
        PrintResult.pringString("수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> manualLottoList = LottoFactory.makeLottoManualList(manualQuantity);
        List<Lotto> autoLottoList = LottoFactory.makeLottoAutoList(autoQuantity());
        List<Lotto> allLottoList = LottoFactory.allLottoList(autoLottoList, manualLottoList);

        PrintResult.printBuyQuantity(autoQuantity(), manualQuantity);
        PrintResult.printLottoList(allLottoList);

        String winningNumbers = InputUtil.returnString("지난 주 당첨 번호를 입력해 주세요.");
        Lotto winningLottoNumber = LottoFactory.makeLottoWithString(winningNumbers);

        int bonusBallNumber = InputUtil.returnInteger("보너스 볼을 입력해 주세요.");

        WinningLotto winningLotto = new WinningLotto(winningLottoNumber, new LottoNumber(bonusBallNumber));
        WinningStatistics winningStatistics = new WinningStatistics(allLottoList, winningLotto);

        WinningResult winningResult = new WinningResult();

        PrintResult.printLottoMap(winningResult.makeWinningMap(allLottoList, winningLotto));
        PrintResult.printResult(winningStatistics.getWinningStatic(), winningStatistics.isBenefit());
    }

    private int buyQuantity() {
        return buyPrice / LOTTO_PRICE;
    }

    private int autoQuantity() {
        return buyQuantity() - manualQuantity;
    }
}
