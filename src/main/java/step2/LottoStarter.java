package step2;

import step2.domain.Constants;
import step2.domain.LottoTicket;
import step2.domain.LottoTicketGenerator;
import step2.domain.WinningNumbers;
import step2.domain.strategy.RandomLottoGeneratorStrategy;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoStarter {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        int lottoAmount = calculateLottoAmount(inputView.getPurchaseAmount());
        resultView.showLottoAmount(lottoAmount);

        LottoTicketGenerator lottoTicketGenerator = new LottoTicketGenerator(lottoAmount, new RandomLottoGeneratorStrategy());
        LottoTicket lottoTicket = lottoTicketGenerator.getLottoTicket();

        resultView.showLottos(lottoTicket);

        Optional<WinningNumbers> lottoWinningNumber = splitAndParsingWinningNumber(inputView.getWinningNumbers());
        resultView.showWinResult(lottoTicket.getWinLottoCount(lottoWinningNumber));
        resultView.showWinRatio(lottoTicket.calculateWinnerRatio(lottoAmount, lottoTicket.calculateTotalPrice()));
    }

    private static int calculateLottoAmount(int purchaseAmount) {
        if (purchaseAmount < Constants.LOTTO_PRICE)
            throw new IllegalArgumentException("최소 구매금액은 " + Constants.LOTTO_PRICE + "원 입니다");
        return purchaseAmount / Constants.LOTTO_PRICE;
    }

    private static Optional<WinningNumbers> splitAndParsingWinningNumber(String input) {
        String[] splitStrArr = input.split(",");
        if (splitStrArr.length != 6)
            throw new IllegalArgumentException("당첨번호는 6개 이어야 합니다.");

        WinningNumbers winningNumbers = new WinningNumbers(
                Arrays.stream(splitStrArr)
                        .map(Integer::parseInt)
                        .collect(Collectors.toList()));

        return Optional.of(winningNumbers);
    }
}
