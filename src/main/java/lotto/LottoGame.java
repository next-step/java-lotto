package lotto;

import lotto.domain.Lottos;
import lotto.utils.InputUtils;
import lotto.utils.LottoShuffle;
import lotto.view.Input;
import lotto.view.Output;

import java.util.List;
import java.util.Scanner;

public class LottoGame {

    public static void main(String[] args) {
        Input input = new Input(new Scanner(System.in));
        Output output = new Output();

        input.moneyInput();
        int buyCount = InputUtils.parserMoney(input.getMoney());
        output.printLottoCount(buyCount);

        Lottos lottos = new Lottos(buyCount, new LottoShuffle());
        output.printBuyLottoNumber(lottos.getLottoNumbers());

        input.inputLastLottoNumber();
        List lastLottoNumbers = InputUtils.stringToArray(input.getLastLottoNumber());
        output.printResultStatic(lottos.makeResultStatics(lastLottoNumbers));

        output.printTotalRevenue(lottos.getTotalRevenue(), lottos.getRevenueMention());

    }
}
