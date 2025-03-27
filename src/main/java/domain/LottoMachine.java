package domain;

import java.util.List;

public class LottoMachine {
    public static Lotto create(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }
}
