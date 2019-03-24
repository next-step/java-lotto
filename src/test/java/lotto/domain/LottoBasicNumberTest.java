package lotto.domain;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBasicNumberTest {
    @Test
    public void 로또_45개번호_확인() {
        int i = 0;
        for (LottoBall lottoBalls : LottoBasicNumber.basicNumbers) {
            assertThat(lottoBalls.number).isEqualTo(++i);
        }
    }
}
