package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("전체 로또의 갯수를 구한다.")
    @Test
    void test01() {
        Lottos lottos = Lottos.create(14000);

        assertThat(lottos.lottoCount()).isEqualTo(14);
    }

    @DisplayName("전체 로또 가격을 구한다.")
    @Test
    void test02() {
        Lotto lotto0 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 5, 12));
        Lotto lotto3 = TestFixture.createLotto(Set.of(1, 2, 3, 4, 11, 12));
        Lotto lotto4 = TestFixture.createLotto(Set.of(1, 2, 3, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto0, lotto1, lotto2, lotto3, lotto4));

        int totalPrice = lottos.totalPrice();

        assertThat(totalPrice).isEqualTo(5_000);
    }

    @DisplayName("입력으로 들어온 로또 갯수를 제외한 나머지 금액만큼의 로또를 생성한다.")
    @Test
    void test03() {
        Lottos lottos = Lottos.create(5000, List.of(
                () -> TestFixture.createLotto(Set.of(11, 12, 13, 14, 15, 16)),
                () -> TestFixture.createLotto(Set.of(21, 22, 23, 24, 25, 26)),
                () -> TestFixture.createLotto(Set.of(31, 32, 33, 34, 35, 36))
        ));

        assertThat(lottos).contains(
                TestFixture.createLotto(Set.of(11, 12, 13, 14, 15, 16)),
                TestFixture.createLotto(Set.of(21, 22, 23, 24, 25, 26)),
                TestFixture.createLotto(Set.of(31, 32, 33, 34, 35, 36))
        );
        assertThat(lottos.lottoCount()).isEqualTo(5);
    }
}
