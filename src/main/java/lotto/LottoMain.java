package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LottoMain {
    public static void main(String[] args) {

        int price = InputView.inputPrice();
        LottoTicket lottoTicket = new LottoTicket(price);

        ResultView.printCount(lottoTicket.getCount());

        ResultView.printLottoNumber(lottoTicket.getLottoRowList());

        String winningNumbers = InputView.inputWinningNumbers();
        List<LottoNumber> winningNumberList = Arrays.stream(winningNumbers.split(","))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::new)
            .collect(Collectors.toList());

        WinningNumber winningNumber = new WinningNumber(winningNumberList);
        Map<Prize, Integer> calculate = winningNumber.calculate(lottoTicket);

        ResultView.printWinning(calculate);

    }
}
