package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.VendingMachine;
import lotto.Wallet;
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
        LottoNumbers winningNumbers = new LottoNumbers(LottoInputParser.getMultipleNumberInput(inputReader, "당첨번호 입력: "));

        return new Winners(lottos, winningNumbers, LottoInputParser.getBonus(inputReader, winningNumbers));
    }

    private VendingMachine initVendingMachine() {
        int budget = LottoInputParser.getSingleNumberInput(inputReader, "지불할 금액 입력: ");
        int manualCount = LottoInputParser.getSingleNumberInput(inputReader, "수동구매 매수: ");

        Wallet wallet = new Wallet(budget);
        return new VendingMachine(wallet, createManualLotto(manualCount));
    }

    private List<Lotto> createManualLotto(int count) {
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            manualLottos.add(new Lotto(new LottoNumbers(LottoInputParser.getMultipleNumberInput(inputReader, "수동구매 번호 입력: "))));
        }

        return manualLottos;
    }
}
