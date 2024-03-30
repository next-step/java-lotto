package lotto.controller;

import lotto.domain.*;

import java.util.List;

import static lotto.view.InputView.*;
import static lotto.view.OutputView.*;

public class LottoClient {

    public static void main(String[] args) {
        System.out.println("구입금액을 입력해 주세요.");
        Cash cash = generateCash();
        ManualLottoCount manualLottoCount = insertManualLottoCount(cash);
        Lottos lottos = generateManualLottos(manualLottoCount);
        generateLottos(lottos, manualLottoCount.getLeftOvers(cash));
        printCount(manualLottoCount.getCount(), manualLottoCount.getLeftOvers(cash));
        printLottoGroup(lottos);
        WinningLotto winningLotto = insertWinningNumbers();
        Match match = new Match();
        lottos.saveMatchResult(winningLotto, match);
        printResult(cash, match);
    }

    private static Lottos generateManualLottos(ManualLottoCount manualLottoCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        Lottos newLottos = new Lottos();
        Integer iter = 0;
        while(manualLottoCount.isLargerThan(iter)){
            Lotto lotto = new Lotto(generateNumbers());
            newLottos.add(lotto);
            iter++;
        }
        return newLottos;
    }

    private static WinningLotto insertWinningNumbers() {
        List<LottoNumber> latestWinningNumbers = insertLatestWinningNumbers();
        int bonusNumber = insertBonusNumber();
        return new WinningLotto(latestWinningNumbers, bonusNumber);
    }

    private static void generateLottos(Lottos lottos, int amount) {
        lottos.generateLottoNumbers(new LottoGenerator(), amount);
    }

    private static List<LottoNumber> insertLatestWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return generateNumbers();
    }

    private static int insertBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return insertNumber();
    }

    private static ManualLottoCount insertManualLottoCount(Cash cash){
        System.out.println("");
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        ManualLottoCount manualLottoCount = new ManualLottoCount(insertNumber());
        manualLottoCount.validateIfLargerThanWholeCount(cash);
        return manualLottoCount;
    }
}
