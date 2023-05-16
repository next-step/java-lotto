package lotto.domain;

import lotto.domain.result.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

    @Test
    @DisplayName(value = "입력한 로또 번호를 Lotto 변환 검사")
    void test1() {
        Lotto lotto = Lotto.stringToNumber("1, 2, 3, 4, 5, 6");
        assertThat(lotto).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @Test
    @DisplayName(value = "로또 번호와 당첨 로또 번호 간 맞은 개수에 따라 RANK 리턴 검사")
    void test2() {
        Lotto lotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lotto winningLotto = Lotto.of(Arrays.asList(1, 2, 3, 4, 5, 7));
        assertThat(lotto.getRank(winningLotto)).isEqualTo(Rank.SECOND);
    }

    @Test
    @DisplayName(value = "입력 로또번호중 중복된 번호가 있을경우 예외 검사")
    void test3() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Lotto.stringToNumber("1, 2, 3, 4, 5, 5");
        });
    }
}
