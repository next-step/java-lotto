package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumberRandomSelector;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.printOpening();
        int price = Integer.parseInt(inputView.getNumber());

        LottoGame lottoGame = new LottoGame(price, new LottoNumberRandomSelector());
        LottoResult lottoResult = new LottoResult();
        outputView.printGameNum(lottoGame.getLottoTicketSize());
        outputView.printTickets(lottoGame.getLotto());
        outputView.printLastWinningNumber();

        String inputNumberString = inputView.getNumber();
        List<String> splitNumbers = Arrays.asList(inputNumberString.split(","));

        List<Integer> numbers = new ArrayList<>();
        for (String splitNumber : splitNumbers) {
            numbers.add(Integer.parseInt(splitNumber.trim()));
        }

        LottoNumbers winningNumbers = new LottoNumbers(numbers);
        lottoGame.checkResult(winningNumbers);
        lottoResult.setResult(lottoGame.getLotto());

        outputView.printResult(lottoResult.getResult());
        outputView.printProfitValue(lottoResult.getProfitRate(price));

    }

}
