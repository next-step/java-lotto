package step2.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {
    public static final List<LottoNo> LOTTO_GENERATOR = new ArrayList<>();

    static {
        for (int number = LottoConstant.START_NO; number <= LottoConstant.END_NO; number++) {
            LOTTO_GENERATOR.add(new LottoNo(number));
        }
    }
}
