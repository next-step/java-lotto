package step2.domain;

import java.util.*;

public class LottoNumberGenerator {

    public static List<LottoNumber> lottoNumbers(int count) {
        List<LottoNumber> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(new LottoNumber());
        }

        return result;
    }

}
