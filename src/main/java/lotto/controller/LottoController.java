package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.LottoNumbers;
import lotto.model.RandomGenerateRule;
import lotto.view.ViewOutput;

public class LottoController {
    public static void run() {
        int numLottoTiket = 3;
        for (int i=0; i<numLottoTiket; i++){
            LottoGenerator lottoGenerator = new LottoGenerator(new RandomGenerateRule());
            LottoNumbers generated = lottoGenerator.generate();
            System.out.println(generated.sort().toString());
        }
    }
}
