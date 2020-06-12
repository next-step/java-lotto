package lotto.domain;

import lotto.StringParser;
import lotto.view.PurchaseLottoInput;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoFactory {

    public static final int PRICE = 1000;

    private static List<Lotto> createAutoLottos(PurchaseLottoInput purchaseLottoInput, NumberGeneratorStrategy strategy) {

        int lottoCount = purchaseLottoInput.getAutoSize();

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(strategy.generateNumbers()));
        }
        return lottos;
    }

    private static List<Lotto> createManualLottos(PurchaseLottoInput purchaseLottoInput) {

        List<Lotto> lottos = new ArrayList<>();

        for (String numbers : purchaseLottoInput.getManualLottoNumbers()) {
            lottos.add(new Lotto(StringParser.getParseNumbers(numbers)));
        }
        return lottos;
    }

    public static List<Lotto> createLottos(PurchaseLottoInput purchaseLottoInput){
        List<Lotto> autoLottos = createAutoLottos(purchaseLottoInput, new RandomNumberGeneratorStrategy());
        autoLottos.addAll(createManualLottos(purchaseLottoInput));
        return Collections.unmodifiableList(autoLottos);
    }
}
