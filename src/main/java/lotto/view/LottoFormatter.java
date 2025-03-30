package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.stream.Collectors;

public class LottoFormatter {

    public static String format(Lotto lotto) {
        return lotto.getLottoNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList())
                .toString();
    }

}
