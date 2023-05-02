package lotto;

import lotto.domain.Lottos;
import lotto.domain.WinNumbers;
import lotto.view.Input;
import lotto.view.Output;

public class LottoApplication {
    public static void main(String[] args) {
        Input input = new Input();
        Lottos lottos = input.setLottos();

        Output output = new Output(lottos);
        output.printNumbers();

        WinNumbers winNumbers = input.setWinNumbers();
        output.printStatistics(winNumbers);
    }
}
