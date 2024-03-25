package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("입력으로 들어온 숫자 리스트를 기반으로 로또를 발행한다.")
    @Test
    void test01() {
        Lotto lotto = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto).isEqualTo(TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호의 갯수가 6개가 아닌 경우 예외가 발생한다.")
    @Test
    void test02() {
        assertThatThrownBy(() -> TestFixture.createLotto(Set.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호의 갯수가 6개가 아닙니다.");
    }

    @DisplayName("입력으로 들어온 Lotto 객체와 일치하는 번호의 갯수를 구한다.")
    @Test
    void test03() {
        Lotto lotto = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6));

        int result = lotto.matchCount(TestFixture.createLotto(Set.of(1, 2, 3, 10, 11, 12)));

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("하나의 LottoNumber 가 포함되는지 여부를 확인한다.")
    @Test
    void test04() {
        Lotto lotto = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6));

        assertThat(lotto.match(new LottoNumber(1))).isTrue();
    }

    @DisplayName("입력으로 들어온 당첨 번호와 보너스 번호를 기반으로 2등인지 확인한다.")
    @Test
    void test05() {
        Lotto lotto = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6));

        boolean result = lotto.isMatchFiveNumberAndBonusNumber(TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 7)), new LottoNumber(6));

        assertThat(result).isTrue();
    }
}
