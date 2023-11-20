package controller;

import lotto.Lotto;
import lotto.WinningNumber;
import lotto.type.WinningLevel;
import view.Renderer;

import java.util.ArrayList;
import java.util.List;

/**
 * 로또 게임 상태 정보를 담는 객체
 * 사용자 입력에 대한 유효성 체크 검사 기능을 담고 있습니다.
 * 상태 정보로부터 파생되는 정보도 계산합니다.
 * 가변 객체입니다.
 */
public class LottoGameState {
    private int userInputPurchaseAmount;
    private int userInputManualLottoCount;
    private List<Lotto> lottos = new ArrayList<>();
    private WinningNumber winningNumber;

    public void setUserInputPurchaseAmount(int userInputPurchaseAmount) {
        if (userInputPurchaseAmount < 0) {
            throw new IllegalArgumentException("입력된 구매 금액 " + userInputPurchaseAmount + "는 0원 미만입니다.");
        }
        this.userInputPurchaseAmount = userInputPurchaseAmount;
    }

    public void setUserInputManualLottoCount(int userInputManualLottoCount) {
        if (userInputManualLottoCount < 0) {
            throw new IllegalArgumentException("입력된 구매 장수 " + userInputManualLottoCount + "는 0개 미만입니다.");
        }

        if (userInputManualLottoCount > this.getTotalLottoCount()) {
            throw new IllegalArgumentException("최대 구매 장수 " + this.getTotalLottoCount() + "장보다 많은 " + userInputManualLottoCount + "장을 구매할 수는 없습니다.");
        }

        this.userInputManualLottoCount = userInputManualLottoCount;
    }

    public int getManualLottoCount() {
        return this.userInputManualLottoCount;
    }

    public int getAutoLottoCount() {
        return this.getTotalLottoCount() - this.userInputManualLottoCount;
    }

    public int getTotalLottoCount() {
        return userInputPurchaseAmount / 1000;
    }

    public void addLotto(Lotto lotto) {
        this.lottos.add(lotto);
    }

    public void addAllLottos(List<Lotto> lottos) {
        this.lottos.addAll(lottos);
    }

    public void printAllLottos() {
        for (Lotto lotto : this.lottos) {
            Renderer.printLotto(lotto);
        }
    }

    public void setWinningNumber(WinningNumber winningNumber) {
        this.winningNumber = winningNumber;
    }

    public WinningStatistic getWinningStatistic() {
        WinningStatistic result = new WinningStatistic();
        for (Lotto myLotto : lottos) {
            WinningLevel rank = WinningLevel.decideFinalWinningLevel(myLotto, winningNumber);

            result.occurs(rank);
        }
        return result;
    }

    public int getUserInputPurchaseAmount() {
        return this.userInputPurchaseAmount;
    }
}
