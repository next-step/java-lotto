package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoTest {
    private Lotto lotto;
    private Lotto lotto2;

    @Test
    @DisplayName("로또 생성 test")
    void createLottoTest() {
        lotto = new Lotto();
        assertThat(lotto.getNums().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("생성된 로또 비교 test")
    void compareLottoTest() {
        lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        lotto2 = new Lotto(Arrays.asList(3,2,1,4,5,6));
        assertThat(lotto.equals(lotto2)).isEqualTo(true);
    }

    @Test
    @DisplayName("로또 sorting test")
    void sortingLottoTest() {
        lotto = new Lotto(Arrays.asList(5,4,3,2,6,1));
        assertThat(lotto.getNums().get(0)).isEqualTo(1);
        assertThat(lotto.getNums().get(5)).isEqualTo(6);
    }

}
