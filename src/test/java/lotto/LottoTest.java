package lotto;

import lotto.model.Lotto;
import lotto.model.Rank;
import org.assertj.core.api.Assertions;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.LottoNumberTest.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 6개를 담는 lotto 클래스 테스트")
public class LottoTest {

    public static final Lotto TEST_LOTTO = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, SIX));

    @Test
    @DisplayName("lotto 생성시 null이 들어오면 NullPointerException이 발생한다.")
    void nullTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(null))
                .isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("lotto 생성시 사이즈가 6이 아닌 수가 들어오면 예외가 발생한다.")
    void sizeTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 당첨 번호 리스트와 일치하는 개수를 반환한다.")
    void resultMatchTest() {
        Lotto winLottoNums = new Lotto(Sets.newLinkedHashSet(ONE, TWO, THREE, FOUR, FIVE, SIX));

        assertThat(TEST_LOTTO.getRank(winLottoNums)).isEqualTo(Rank.FIRST);
    }
}
