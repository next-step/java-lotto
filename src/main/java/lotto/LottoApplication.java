package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printOpening();
        int price = Integer.parseInt(inputView.getNumber());

        LottoGame lottoGame = new LottoGame(price);

        outputView.printGameNum(lottoGame.getGameNum());
        outputView.printTickets(lottoGame.getLottoGame());
        outputView.printLastWinningNumber();

        String inputNumberString = inputView.getNumber();
        List<String> splitNumbers = Arrays.asList(inputNumberString.split(","));

        List<Integer> numbers = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber.trim()));
        }

        lottoGame.setWinningNumber(numbers);
        lottoGame.checkResult();
        lottoGame.setResult();

        outputView.printResult(lottoGame.getResult());
        outputView.printProfitValue(lottoGame.getProfitRate());

    }

}
