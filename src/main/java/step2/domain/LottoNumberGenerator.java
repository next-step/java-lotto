package step2.domain;

import java.util.*;

public class LottoNumberGenerator {

    public static List<LottoNumbers> lottoNumbers(int count) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(new LottoNumbers());
        }

        return result;
    }

}
