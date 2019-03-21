package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class LottoNumbersTest {
    private static final LottoNumber LOTTO_1 = LottoNumber.from(1);
    private static final LottoNumber LOTTO_2 = LottoNumber.from(2);
    private static final LottoNumber LOTTO_3 = LottoNumber.from(3);
    private static final LottoNumber LOTTO_4 = LottoNumber.from(4);
    private static final LottoNumber LOTTO_5 = LottoNumber.from(5);
    private static final LottoNumber LOTTO_6 = LottoNumber.from(6);
    private static final LottoNumber LOTTO_7 = LottoNumber.from(7);

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_여섯_개_초과한_경우() {
        // given
        // when
        // then
        final List<LottoNumber> numbers = Arrays.asList(LOTTO_1, LOTTO_2, LOTTO_3, LOTTO_4, LOTTO_5, LOTTO_6, LOTTO_7);
        new LottoNumbers(numbers);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_중복인_경우() {
        // given
        // when
        // then
        final List<LottoNumber> numbers = Arrays.asList(LOTTO_1, LOTTO_1, LOTTO_1, LOTTO_1, LOTTO_1, LOTTO_1);
        new LottoNumbers(numbers);
    }
}
