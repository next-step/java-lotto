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
        InputUtils inputUtils = new InputUtils();

        input.moneyInput();
        int money = input.getMoney();
        inputUtils.validMoneyGreaterZero(money);
        int buyCount = inputUtils.parserMoney(money);

        output.printLottoCount(buyCount);
        Lottos lottos = new Lottos(buyCount, new LottoShuffle());
        List<String> lottoNumbers = lottos.getLottoNumbers();

        output.printBuyLottoNumber(lottoNumbers);
        input.inputLastLottoNumber();
        String lastLottoNumberString = input.getLastLottoNumber();
        List lastLottoNumbers = inputUtils.stringToArray(lastLottoNumberString);
        output.printResultStatic(lottos.makeResultStatics(lastLottoNumbers));

    }
}
