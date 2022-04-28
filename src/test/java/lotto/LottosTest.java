package lotto;

import lotto.model.Lottos;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 6개를 담는 lottos 클래스 테스트")
public class LottosTest {

    public static final Lottos TEST_LOTTO = new Lottos(Lists.newArrayList(1, 2, 3, 4, 5, 6));

    @Test
    @DisplayName("lottos 생성시 null이 들어오면 NullPointerException이 발생한다.")
    void nullTest() {
        Assertions.assertThatThrownBy(() -> new Lottos(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("lottos 생성시 사이즈가 6이 아닌 수가 들어오면 예외가 발생한다.")
    void sizeTest() {
        Assertions.assertThatThrownBy(() -> new Lottos(Lists.newArrayList(1, 2, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호 리스트와 일치하는 개수를 반환한다.")
    void resultMatchTest() {
        Lottos winLottoNums = new Lottos(Lists.newArrayList(1, 2, 3, 4, 5, 6));

        assertThat(TEST_LOTTO.getMatchCount(winLottoNums)).isEqualTo(6);
    }
}
