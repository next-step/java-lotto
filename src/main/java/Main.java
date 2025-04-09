
import java.util.List;


import domain.Lotto;
import domain.LottoBundle;
import domain.LottoGenerator;
import domain.WinningNumbers;

import static domain.Lotto.PRICE_PER_ONE;
import static utils.Splitter.splitAndConvertInt;
import static view.InputView.inputAmount;
import static view.InputView.inputBonusNumbers;
import static view.InputView.inputManualLottoCount;
import static view.InputView.inputManualLottoNumber;
import static view.InputView.inputWinningNumber;
import static view.ResultView.print;
import static view.ResultView.printBuyCount;

public class Main {
    public static void main(String[] args) {
        int autoAmount = inputAmount();
        int autoBuyCount = autoAmount / PRICE_PER_ONE;
        int manualCount = inputManualLottoCount();

        List<Lotto> manualLottoList = inputManualLottoNumber(manualCount);

        printBuyCount(manualCount, autoBuyCount);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.createLottoBulk(autoAmount);
        lottoList.addAll(manualLottoList);
        print(lottoList);

        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(splitAndConvertInt(inputWinningNumber())),
            inputBonusNumbers());

        LottoBundle lottoBundle = new LottoBundle(lottoList, winningNumbers);
        print(lottoBundle.getLottoStatics());
    }
}
