package lotto.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.domain.lotto.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
    @Test
    @DisplayName("번호가 6자리가 아니면, 예외를 발생시킨다.")
    void lottoWrongNumberFormatTest() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3))
                .withMessage("로또는 6개 숫자여야 합니다.");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5))
                .withMessage("로또는 6개 숫자여야 합니다.");
    }

    @Test
    @DisplayName("로또 객체 간에 숫자를 비교하여, 일치하는 개수를 반환한다.")
    void lottoComparingTest() {
        Lotto myLotto = new Lotto(3, 6, 9, 12, 15, 18);
        Lotto yourLotto = new Lotto(2, 4, 6, 8, 10, 12);

        long counts = myLotto.getMatchingBallCountFrom(yourLotto);

        assertThat(counts).isEqualTo(2L);
    }

    @Test
    @DisplayName("로또는 서로 중복되는 숫자가 없어야 합니다.")
    void noDuplicateNumberInLotto() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Lotto(1, 2, 3, 4, 5, 1))
                .withMessage("중복되는 숫자가 없어야 합니다.");
    }
}
