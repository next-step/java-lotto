package study.ascii92der.lotto.step3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        LottoPrice lottoPrice = new LottoPrice(money);
        ResultView.printLottoCount(lottoPrice);

        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoPrice.lottoCount(); i++) {
            List<String> generatedNumberList = lottoGenerator.generate();
            Collections.sort(generatedNumberList);
            String lottoNumbers = String.join(",", generatedNumberList);
            ResultView.printLottoNumbers(lottoNumbers);
            lottos.add(new Lotto(lottoNumbers));
        }

        String winnerNumbers = InputView.inputWinnerNumbers();
        List<String> winnerNumberList = new ArrayList<>(Arrays.asList(winnerNumbers.split(",")));
        List<LottoResult> lottoResults = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoResults.add(new LottoResult(lotto, winnerNumberList));
        }

        WinResult winResult = new WinResult(lottoResults);
        ResultView.printWinnerResult(winResult);
    }

}
