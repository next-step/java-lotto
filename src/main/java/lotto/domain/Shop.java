package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Shop {
    private static final int LOTTO_PRICE = 1_000;

    private Shop() {}

    public static List<Lotto> buyLottos(Long money, List<String> manualLottos) {
        long autoLottoCount = (money / LOTTO_PRICE) - manualLottos.size();
        return Stream.concat(
                manualLottos.stream().map(lotto -> new Lotto(lotto)),
                Stream.generate(() -> new Lotto()).limit(autoLottoCount)
                ).collect(Collectors.toList());
    }
}
