package lotto.Controller;


import lotto.Domain.*;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    InputView inputView;
    OutputView outputView;
    LottoMachine lottoMachine;

    public LottoController(InputView inputView, LottoMachine lottoMachine) {
        this.inputView = inputView;
        this.outputView = OutputView.init();
        this.lottoMachine = lottoMachine;
    }

    public int payToLotto() {
        int price = inputView.userInstructionAmount();
        int count = lottoMachine.boughtLottoCount(price);
        outputView.userInstructionCount(count);
        return count;
    }

    public Lottos buyAutoLotto(int LottoCount) {
        Lottos lottos = Lottos.init(new ArrayList<>());
        for (int i = 0; i < LottoCount; i++) {
            Lotto lotto = lottoMachine.buyLotto(lottoMachine.makeAutoTargetNumber());
            lottos.add(lotto);
        }
        return lottos;
    }

    public void boughtLottoList(Lottos lottos) {
        outputView.boughtLottoList(lottos);
    }

    public WinningLotto inputLastWeekWinLotto() {
        System.out.println("---------------------");
        String input = inputView.userInstructionWinner();
        System.out.println("---------------------");
        int bonus = inputView.userInstructionBonus();
        Lotto lastweekWinlotto = Lotto.init(Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList()));
        return WinningLotto.init(lastweekWinlotto, bonus);
    }

    public LottoResult lottoResult(Lottos lottos, WinningLotto winningLotto) {
        return lottos.match(winningLotto);
    }

    public void printLottoResult(LottoResult lottoResult) {
        outputView.LottoResult(lottoResult);
    }
}