package lotto.controller;

import lotto.model.*;
import lotto.view.ViewInput;
import lotto.view.ViewOutput;

import java.util.Arrays;

public class LottoController {
    public static void run() {
        LottoNumbers winningNumbers = new LottoNumbers(Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
        NumberMatcher numberMatcher = new NumberMatcher(winningNumbers);
        int expense = ViewInput.getExpense();
        int numLottoTicket = ViewInput.getAvailableNumLottoTicket(expense);
        LottoResultMap lottoResultMap = new LottoResultMap(expense);
        for (int i=0; i<numLottoTicket; i++){
            LottoGenerator lottoGenerator = new LottoGenerator(new RandomGenerateRule());
            LottoNumbers generated = lottoGenerator.generate();
            lottoResultMap.plusByNumKeyMatched(numberMatcher.howManyMatched(generated));
            System.out.println(generated.sort().toString());
        }

        lottoResultMap.printResult();
    }
}
