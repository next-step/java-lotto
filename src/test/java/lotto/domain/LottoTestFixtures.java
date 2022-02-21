package lotto.domain;

import java.util.Arrays;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCreator;
import lotto.domain.lotto.LottoNumber;

public class LottoTestFixtures {

    public static final List<LottoNumber> OVERSIZE_LOTTO_NUMBER = Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6),
        new LottoNumber(7)
    );

    public static final List<LottoNumber> DUPLICATED_LOTTO_NUMBER = Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(4),
        new LottoNumber(4)
    );

    public static final List<LottoNumber> NORMAL_LOTTO_NUMBER = Arrays.asList(
        new LottoNumber(1),
        new LottoNumber(2),
        new LottoNumber(3),
        new LottoNumber(4),
        new LottoNumber(5),
        new LottoNumber(6)
    );

    public static final LottoCreator FIXED_LOTTO_CREATOR = new LottoCreator() {
        @Override
        public Lotto createLotto() {
            return new Lotto(NORMAL_LOTTO_NUMBER);
        }
    };
}
