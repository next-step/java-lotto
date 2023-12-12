package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

public class LottoNumbersTest {

    @Test
    void 로또_당첨_번호_갯수_테스트() {
        LottoNumbers lottoNumbers = new LottoNumbers("1, 2, 3, 4, 5, 6");
        LottoNumbers winningNumbers = new LottoNumbers("1, 2, 3, 4, 5, 7");

        assertThat(lottoNumbers.matchCount(winningNumbers)).isEqualTo(5);
    }
}
