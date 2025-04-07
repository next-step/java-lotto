
import java.util.List;


import domain.BonusNumber;
import domain.Lotto;
import domain.LottoBundle;
import domain.LottoGenerator;
import domain.WinningNumbers;

import static domain.Lotto.PRICE_PER_ONE;
import static utils.Splitter.splitAndConvertInt;
import static view.InputView.inputAmount;
import static view.InputView.inputBonusNumbers;
import static view.InputView.inputWinningNumber;
import static view.ResultView.print;

public class Main {
    public static void main(String[] args) {
        int amount = inputAmount();
        int buyCount = amount / PRICE_PER_ONE;
        System.out.println(buyCount + "개를 구매하였습니다.");

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.createLottoBulk(amount);
        print(lottoList);

        WinningNumbers winningNumbers = new WinningNumbers(splitAndConvertInt(inputWinningNumber()),
            inputBonusNumbers());

        LottoBundle lottoBundle = new LottoBundle(lottoList, winningNumbers);
        print(lottoBundle.getLottoStatics());
    }
}
