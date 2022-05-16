package autolotto;

import autolotto.constant.Rank;
import autolotto.domain.*;
import autolotto.exception.LottoException;
import autolotto.view.LottoInput;
import autolotto.view.LottoOutput;

import java.util.List;
import java.util.Set;

public class Lottery {
    public static void main(String[] args) {
        try {
            runLottery(createLotto(), createWinningNumbers());
        } catch (LottoException e) {
            System.out.println("게임 진행 중 에러가 발생했습니다. " + e.getMessage());
        } catch (Exception e) {
            System.out.println("알 수 없는 에러가 발생했습니다.");
        }
    }

    private static Lottos createLotto() {
        int amount = LottoInput.askAmount();
        int totalQuantity = Lottos.getQuantity(amount);
        int manualQuantity = LottoInput.askManualLottoQuantity();
        int autoQuantity = totalQuantity - manualQuantity;

        List<LottoNumbers> manualLottoNumbers = LottoInput.createManualLotto(manualQuantity);

        LottoInput.printQuantities(manualQuantity, autoQuantity);
        Lottos lottos = Lottos.of(autoQuantity, manualLottoNumbers);

        LottoOutput.printLottoNumbers(lottos);
        return lottos;
    }

    private static WinningLotto createWinningNumbers() {
        Set<LottoNumber> winningNumbers = LottoInput.askWinningNumber();
        LottoNumber bonusBall = LottoInput.askBonusBall(winningNumbers);

        return new WinningLotto(new LottoNumbers(winningNumbers), bonusBall);
    }

    private static void runLottery(Lottos lottos, WinningLotto winningLotto) {
        Results results = lottos.confirm(winningLotto);

        LottoOutput.printBoard();
        for (Rank rank : Rank.valuesExceptMiss()) {
            int countOfWinners = results.countOfWinners(rank);
            LottoOutput.printResult(rank, countOfWinners);
        }
        LottoOutput.printROI(results.roi(lottos.cost()));
    }
}
