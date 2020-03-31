package lotto.Controller;


import lotto.Domain.LottoMachine;
import lotto.Domain.Lottos;
import lotto.View.InputView;
import lotto.View.OutputView;
import stringPlusCalculate.View.ResultView;

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

    public Lottos buyAutoLotto(int count) {
        Lottos lottos = lottoMachine.buyAutoLottos(count);
        outputView.boughtLottoList(lottos);
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

    public void LottoResult(Lottos lottos, List<Integer> lastweekWinLotto) {
        outputView.LottoResult(lottos, lastweekWinLotto);
    }
}
