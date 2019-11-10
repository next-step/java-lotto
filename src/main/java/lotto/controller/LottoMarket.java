package lotto.controller;

import java.util.ArrayList;
import java.util.List;

import lotto.Lotto;
import lotto.VendingMachine;
import lotto.Wallet;
import lotto.data.LottoNumbers;
import lotto.data.Lottos;
import lotto.data.Winners;
import lotto.input.InputReader;
import lotto.view.LottoViewResolver;
import lotto.view.Viewer;

public class LottoMarket {
    private final InputReader inputReader;
    private final VendingMachine vendingMachine;
    private final LottoViewResolver viewResolver;

    public LottoMarket(InputReader inputReader, Viewer viewer) {
        this.inputReader = inputReader;
        this.vendingMachine = initVendingMachine();
        this.viewResolver = new LottoViewResolver(viewer);
    }

    public void guess() {
        Lottos lottos = buyLottos();
        viewResult(getWinner(lottos));
    }

    private Lottos buyLottos() {
        Lottos lottos = vendingMachine.buy();
        viewResolver.viewStart(lottos);
        return lottos;
    }

    private void viewResult(Winners winners) {
        viewResolver.viewResult(winners, vendingMachine.calculateSpent());
    }

    private Winners getWinner(Lottos lottos) {
        LottoNumbers winningNumbers = new LottoNumbers(LottoInputParser.parseMultipleNumberInput(inputReader, "당첨번호 입력: "));

        return new Winners(lottos, winningNumbers, LottoInputParser.parseBonus(inputReader, winningNumbers));
    }

    private VendingMachine initVendingMachine() {
        int budget = LottoInputParser.parseSingleNumberInput(inputReader, "지불할 금액 입력: ");
        int manualCount = LottoInputParser.parseSingleNumberInput(inputReader, "수동구매 매수: ");

        Wallet wallet = new Wallet(budget);
        return new VendingMachine(wallet, createManualLotto(manualCount));
    }

    private List<Lotto> createManualLotto(int count) {
        List<Lotto> manualLottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            manualLottos.add(new Lotto(new LottoNumbers(LottoInputParser.parseMultipleNumberInput(inputReader, "수동구매 번호 입력: "))));
        }

        return manualLottos;
    }
}
