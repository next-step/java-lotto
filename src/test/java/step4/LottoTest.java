package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    Lotto winnerLotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

    @Test
    @DisplayName("로또 생성")
    public void create() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));

        assertThat(lotto).isEqualTo(Lotto.of(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    @DisplayName("로또 검증 - 여섯자리")
    public void valid_six() {
        assertThatThrownBy(() ->{
            Lotto.of(Arrays.asList(1,2,3,4,5,6,7));
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() ->{
            Lotto.of(Arrays.asList(1,2,3,4,5,6,7,8));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("지난 당첨 번호와 현재 로또번호 Match - First")
    public void matchTest_First() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.match(winnerLotto)).isEqualTo(6);
    }

    @Test
    @DisplayName("지난 당첨 번호와 현재 로또번호 Match - Second")
    public void matchTest_Second() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,5,8));
        assertThat(lotto.match(winnerLotto)).isEqualTo(5);
    }

    @Test
    @DisplayName("지난 당첨 번호와 현재 로또번호 Match - Third")
    public void matchTest_Third() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,4,7,8));
        assertThat(lotto.match(winnerLotto)).isEqualTo(4);
    }

    @Test
    @DisplayName("지난 당첨 번호와 현재 로또번호 Match - Fourth")
    public void matchTest_Fourth() {
        Lotto lotto = Lotto.of(Arrays.asList(1,2,3,7,8,9));
        assertThat(lotto.match(winnerLotto)).isEqualTo(3);
    }

}
