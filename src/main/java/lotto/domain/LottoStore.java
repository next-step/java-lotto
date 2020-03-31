package lotto.domain;

import lotto.exception.ExceptionType;
import lotto.exception.LottoException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStore {
    private static final int PRICE = 1000;

    public static List<Lotto> sellLotto(int money, List<String> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();

        lottos.addAll(manualLottos.stream()
                .map(manualLotto -> new Lotto(manualLotto))
                .collect(Collectors.toList()));

        int autoLottoCount = money / PRICE - manualLottos.size();

        checkMoney(money, autoLottoCount);

        for (int i = 0; i < autoLottoCount; i++) {
            lottos.add(LottoGenerator.generate());
        }

        return lottos;
    }

    private static void checkMoney(int money, int autoLottoCount) {
        if (money < PRICE || autoLottoCount < 0) {
            throw new LottoException(ExceptionType.NOT_ENOUGH_MONEY);
        }
    }
}
