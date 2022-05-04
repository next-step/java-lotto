package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private static List<LottoNumber> lottoBaseNumbers;

    private LottoFactory() {
    }

    public static LottoNumbers auto() {
        if (lottoBaseNumbers == null) {
            lottoBaseNumbers = new ArrayList<>();
            for (int i = 0; i < 45; i++) {
                lottoBaseNumbers.add(new LottoNumber(i + 1));
            }
        }

        Collections.shuffle(lottoBaseNumbers);
        return new LottoNumbers(lottoBaseNumbers.stream()
                .limit(6)
                .collect(Collectors.toList()));
    }
}
