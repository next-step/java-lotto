package lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoFactory {

    public static List<Lotto> createLottos(Money money, List<String> manualLottoNumbers){
        validationCheck(money, manualLottoNumbers);
        List<Lotto> autoLottos = AutoLottos.createLottos(money.getTotalPurchaseSize() - manualLottoNumbers.size());
        List<Lotto> manualLottos = ManualLottos.createLottos(manualLottoNumbers);
        autoLottos.addAll(manualLottos);
        return Collections.unmodifiableList(autoLottos);
    }

    private static void validationCheck(Money money, List<String> manualLottoNumbers) {
        if (manualLottoNumbers == null || manualLottoNumbers.size() > money.getTotalPurchaseSize()) {
            throw new IllegalArgumentException("수동으로 구매할 로또 개수가 예산을 초과합니다.");
        }
    }
}
