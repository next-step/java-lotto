package lotto.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("로또 테스트")
class LottoTest {

    @DisplayName("45개 이하의 숫자 6개를 가진다.")
    @Test
    void checkLottoNumber() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        for (LottoNumber number : lotto.getNumbers()) {
            Assertions.assertTrue(number.getLottoNumber() <= 45);
        }
    }

    @DisplayName("로또가 가지고 있는 번호는 6개를 초과할 수 없다.")
    @Test
    void checkLottoSize() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1,2,3,4,5,6,7));
        });
    }

    @DisplayName("중복된 로또 번호가 존재하는지 확인한다.")
    @Test
    void checkDuplicateNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new Lotto(Arrays.asList(1,1,3,4,5,6));
        });
    }

    @DisplayName("로또 당첨 개수를 확인한다.")
    @Test
    void countWinning() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        Lotto winningLotto = new Lotto(Arrays.asList(4,5,6,7,8,9));
        Assertions.assertEquals(lotto.countWinningNumber(winningLotto.getNumbers()), 3);
    }
}
