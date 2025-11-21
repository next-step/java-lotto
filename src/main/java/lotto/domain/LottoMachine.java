package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoMachine {

    private static final List<NumberElement> lottoNumbers;

    static {
        lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumbers.add(new NumberElement(i));
        }
    }

    public static List<LottoNumber> createLotto(LottoPrice lottoPrice) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();

        lottoPrice.create(() -> {
            Collections.shuffle(LottoMachine.lottoNumbers);
            lottoNumbers.add(new LottoNumber(new ArrayList<>(
                    LottoMachine.lottoNumbers.subList(0, 6).stream().toList()))
            );
        });

        return lottoNumbers;
    }
}
