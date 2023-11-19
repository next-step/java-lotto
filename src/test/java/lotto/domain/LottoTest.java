package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void 생성자_가변인자_테스트() {
        assertThat(new Lotto(1, 2, 3, 4, 5, 6)).isEqualTo(new Lotto(1, 2, 3, 4, 5, 6));
    }

    @Test
    void 생성자_리스트_테스트() {
        assertThat(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6))).isEqualTo(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또의 getRightNumber()는 동일한 번호의 갯수를 반환한다.")
    @Test
    void getRightNumberTest() {
        final Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        final int rightNumber = lotto.getRightNumber(new Lotto(1,2,3,4,5,6));

        assertThat(rightNumber).isEqualTo(6);
    }

    @DisplayName("로또의 getRightNumber()는 동일한 번호가 없으면 0을 리턴한다.")
    @Test
    void rightNumberEmptyTest() {
        final Lotto lotto = new Lotto(1, 2, 3, 4, 5, 6);

        final int rightNumber = lotto.getRightNumber(new Lotto(7,8,9,10,11,12));

        assertThat(rightNumber).isEqualTo(0);
    }
}