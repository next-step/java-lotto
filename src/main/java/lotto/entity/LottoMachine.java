package lotto.entity;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_UNIT_PRICE = 1000;

    private LottoMachine() {

    }

    public static void validate(int inputMoney, int manualCount) {
        int lottoCount = getLottoCount(inputMoney);

        if (manualCount > lottoCount) {
            throw new IllegalArgumentException("투입금액보다 수동 발급 수가 더 큽니다");
        }
    }

    public static List<Lotto> createLotto(List<String[]> manualTexts, int inputMoney) {
        List<Lotto> result = new ArrayList<>();
        List<Lotto> manualLottos = ManualLottoMachine.createLotto(manualTexts);
        result.addAll(manualLottos);
        List<Lotto> autoLottos = AutoLottoMachine.createLotto(autoCount(inputMoney, manualLottos.size()));
        result.addAll(autoLottos);
        return result;
    }

    private static int getLottoCount(int money) {
        return money / LOTTO_UNIT_PRICE;
    }

    private static int autoCount(int inputMoney, int manualLottoSize) {
        return getLottoCount(inputMoney) - manualLottoSize;
    }
}
