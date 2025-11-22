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

    public static BuyLotto createLotto(LottoPrice lottoPrice) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        lottoPrice.create(() -> {
            Collections.shuffle(LottoMachine.lottoNumbers);
            lottoNumbers.add(new Lotto(new HashSet<>(
                    LottoMachine.lottoNumbers.subList(0, 6).stream().collect(Collectors.toSet())))
            );
        });

        return new BuyLotto(lottoNumbers);
    }
}
