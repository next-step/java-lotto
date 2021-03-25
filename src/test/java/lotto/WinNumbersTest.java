package lotto;

import lotto.domain.HitCount;
import lotto.domain.Numbers;
import lotto.domain.WinNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class WinNumbersTest {
    @DisplayName("로또번호와 당첨번호를 비교하여 당첨갯수를 반환한다.")
    @Test
    public void hitCount() {
        WinNumbers winNumbers = new WinNumbers(Arrays.asList(1, 8, 19, 21, 20, 43));
        Numbers lottoNumbers = new Numbers(Arrays.asList(1, 8, 19, 21, 20, 43));

        assertThat(winNumbers.hitNumberCount(lottoNumbers)).isEqualTo(new HitCount(6));
    }
}
