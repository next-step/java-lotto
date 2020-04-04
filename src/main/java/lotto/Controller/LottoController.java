package lotto.Controller;


import lotto.Domain.Lotto;
import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
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

    public List<Integer> inputLastWeekWinLotto() {
        System.out.println("---------------------");
        String input = inputView.userInstructionWinner();
        System.out.println("---------------------");
        return Arrays.stream(input.split(", "))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public void lottoResult(Lottos lottos, List<Integer> lastweekWinLotto) {
        outputView.LottoResult(lottos, lastweekWinLotto);
    }
}