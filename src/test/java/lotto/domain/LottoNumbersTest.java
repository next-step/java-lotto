package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoNumbersTest {
    @Test
    public void 생성() {
        assertThat(new LottoNumbers(List.of(1, 2, 3, 4, 5, 6))).isEqualTo(new LottoNumbers(1, 2, 3, 4, 5, 6));
    }

    @Test
    public void 포함_여부() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        assertThat(lottoNumbers.contains(new LottoNumber(1))).isTrue();
    }

    @Test
    public void 일치_횟수_비교() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoNumbers otherNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 7));

        assertThat(lottoNumbers.getMatchCount(otherNumbers)).isEqualTo(5);
    }
}
