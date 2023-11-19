package domain.lotto;

import domain.lotto.domain.LottoGame;
import domain.lotto.domain.LottoLine;
import domain.lotto.domain.LottoNumber;
import domain.lotto.view.InputView;
import domain.lotto.view.OutputView;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoApplication {
    public static void main(String[] args) {
        int buyingPrice = InputView.getBuyingPrice();

        LottoGame lottoGame = LottoGame.from(buyingPrice);

        OutputView.printBuyingCount(lottoGame.getLottoLines().size());
        OutputView.printLottoLines(lottoGame);
        
        String winningNumberAnswer = InputView.getWinningNumber();
        String[] winningNumbersString = winningNumberAnswer.split(", ");
        Set<LottoNumber> winningNumbers = Arrays.stream(winningNumbersString)
                .mapToInt(Integer::parseInt)
                .mapToObj(LottoNumber::from)
                .collect(Collectors.toSet());

        lottoGame.registerWinningLottoLine(new LottoLine(winningNumbers));

        lottoGame.calculateStatistics();

        OutputView.printStatistics(lottoGame);

    }
}
