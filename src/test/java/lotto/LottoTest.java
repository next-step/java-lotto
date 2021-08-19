package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("당첨번호 비교 후 같은 번호 갯수 확인")
    void findMatchedNumberCount() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        int matchedNumberCount = lotto.findMatchedNumberCount(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(matchedNumberCount).isEqualTo(6);
    }

}