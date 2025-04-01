
import java.util.List;
import java.util.Scanner;


import domain.BonusNumber;
import domain.Lotto;
import domain.LottoBundle;
import domain.LottoGenerator;

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

        List<Integer> winningNumbers = splitAndConvertInt(inputWinningNumber());
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumbers(), winningNumbers);
        LottoBundle lottoBundle = new LottoBundle(lottoList, winningNumbers, bonusNumber);
        print(lottoBundle.getLottoStatics());
    }
}
