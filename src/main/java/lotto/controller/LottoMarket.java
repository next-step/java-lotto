package lotto.controller;

import lotto.VendingMachine;
import lotto.Winners;
import lotto.data.LottoNumbers;
import lotto.data.Lottos;
import lotto.input.InputReader;
import lotto.view.Viewer;

public class LottoMarket {
    private final InputReader inputReader;
    private final Viewer viewer;
    private final VendingMachine vendingMachine;

    public LottoMarket(InputReader inputReader, Viewer viewer) {
        this.inputReader = inputReader;
        this.viewer = viewer;
        this.vendingMachine = initVendingMachine();
    }

    public void guess() {
        Lottos lottos = vendingMachine.buy();
        lottos.getLottos().forEach(lotto -> viewer.print(lotto.toString(), ""));

        Winners winners = getWinner(lottos);

        printResult(winners);
    }

    private void printResult(Winners winners) {
        viewer.print(winners.toString(), "결과 확인");
        viewer.print(String.valueOf(winners.getTotalEarning() / (double) vendingMachine.getExpend()), "총 수익률");
    }

    private Winners getWinner(Lottos lottos) {
        LottoNumbers winningNumbers = new LottoNumbers(LottoInputParser.getWinningInput(inputReader));

        return LottoInputParser.getBonus(inputReader, winningNumbers).map(num -> new Winners(lottos, winningNumbers, num))
                               .orElseGet(() -> new Winners(lottos, winningNumbers));
    }

    private VendingMachine initVendingMachine() {
        return inputReader.readInt("지불할 금액 입력: ")
                          .map(VendingMachine::new)
                          .orElseThrow(IllegalArgumentException::new);
    }
}
