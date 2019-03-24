package lotto.domain;

import org.junit.Test;

import java.util.Arrays;

public class LottoNumbersTest {
    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_여섯_개_초과한_경우() {
        // given
        // when
        // then
        new LottoNumbers(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
    }

    @Test(expected = IllegalArgumentException.class)
    public void 로또_번호가_중복인_경우() {
        // given
        // when
        // then
        new LottoNumbers(Arrays.asList(1, 1, 1, 1, 1, 1));
    }
}
