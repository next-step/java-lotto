package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {
    @Test
    public void 생성() {
        assertThat(new LottoNumbers("1, 2, 3, 4, 5, 6")).isEqualTo(new LottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 포함_여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        assertThat(lottoNumbers.contains(LottoNumber.get(1))).isTrue();
    }

    @Test
    public void 일치_횟수_비교() {
        LottoNumbers lottoNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);
        LottoNumbers otherNumbers = new LottoNumbers(1, 2, 3, 4, 5, 6);

        assertThat(lottoNumbers.getMatchCount(otherNumbers)).isEqualTo(6);
    }
}
