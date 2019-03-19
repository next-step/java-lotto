package lotto.util;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoBasicNumberTest {

    @Test
    public void basicNumber생성확인() {
        int i = 1;
        for (int number : LottoBasicNumber.numbers) {
            assertThat(number).isEqualTo(i++);
        }
    }
}
