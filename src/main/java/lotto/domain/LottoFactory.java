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
            lottos.add(Lotto.of(StringParser.getParseNumbers(numbers)));
        }
        return lottos;
    }

    public static List<Lotto> createLottos(PurchaseLottoInput purchaseLottoInput){
        validationCheck(purchaseLottoInput.getPurchasePrice(), purchaseLottoInput.getManualLottoNumbers());
        List<Lotto> autoLottos = createAutoLottos(purchaseLottoInput, new RandomNumberGeneratorStrategy());
        autoLottos.addAll(createManualLottos(purchaseLottoInput));
        return Collections.unmodifiableList(autoLottos);
    }

    private static void validationCheck(int purchasePrice, List<String> manualLottoNumbers) {
        if (purchasePrice < LottoFactory.PRICE) {
            throw new IllegalArgumentException("구입금액은 최소 1000원 이상입니다.");
        }

        if (manualLottoNumbers == null || manualLottoNumbers.size() > purchasePrice / LottoFactory.PRICE) {
            throw new IllegalArgumentException("수동으로 구매할 로또 개수가 예산을 초과합니다.");
        }
    }
}
