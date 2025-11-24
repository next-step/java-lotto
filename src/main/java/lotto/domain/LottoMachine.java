package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {

    private static final List<NumberElement> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(NumberElement.create(i));
        }
    }

    public static void createLotto(BuyLotto buyLotto, LottoPrice lottoPrice) {
        lottoPrice.create(() -> {
            Collections.shuffle(LottoMachine.lottoNumbers);
            buyLotto.add(new Lotto(new HashSet<>(LottoMachine.lottoNumbers.subList(0, 6))));
        });
    }
}
