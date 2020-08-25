package lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoFactory {
    private static final LottoNumber[] LOTTO_NUMBERS = {
            new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5),
            new LottoNumber(6), new LottoNumber(7), new LottoNumber(8), new LottoNumber(9), new LottoNumber(10),
            new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14), new LottoNumber(15),
            new LottoNumber(16), new LottoNumber(17), new LottoNumber(18), new LottoNumber(19), new LottoNumber(20),
            new LottoNumber(21), new LottoNumber(22), new LottoNumber(23), new LottoNumber(24), new LottoNumber(25),
            new LottoNumber(26), new LottoNumber(27), new LottoNumber(28), new LottoNumber(29), new LottoNumber(30),
            new LottoNumber(31), new LottoNumber(32), new LottoNumber(33), new LottoNumber(34), new LottoNumber(35),
            new LottoNumber(36), new LottoNumber(37), new LottoNumber(38), new LottoNumber(39), new LottoNumber(40),
            new LottoNumber(41), new LottoNumber(42), new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)
    };

    public static Lotto create() {
        List<LottoNumber> lottoNumbers = Arrays.asList(LOTTO_NUMBERS);

        Collections.shuffle(lottoNumbers);

        return new Lotto(lottoNumbers.subList(0, 6));
    }
}
