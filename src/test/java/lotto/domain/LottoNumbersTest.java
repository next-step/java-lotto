package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumbersTest {
    @Test
    public void 로또번호입력() {
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 4, 5, 6});
        assertThat(luckyNumbers.size()).isEqualTo(6);
    }

    @Test(expected = IllegalArgumentException.class)
    public void 유효하지않는로또번호() {
        LottoNumbers luckyNumbers = new LottoNumbers(new Integer[]{1, 2, 3, 4, 5});
    }
}