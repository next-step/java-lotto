package domain;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("입력받은 로또 구입 금액만큼 로또를 발급한다.")
    @Test
    void test01() {
        Lottos lottos = new Lottos(14000);

        assertThat(lottos.lottoCount()).isEqualTo(14);
    }

    @DisplayName("전체 로또 구입금액을 구한다.")
    @Test
    void test02() {
        Lotto lotto0 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto0, lotto1, lotto2, lotto3, lotto4));

        int totalPrice = lottos.totalPrice();

        assertThat(totalPrice).isEqualTo(5_000);
    }

    @DisplayName("수동으로 로또를 생성할 수 있다.")
    @Test
    void test03() {
        Lottos lottos = new Lottos(3000, List.of(
                () -> new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                () -> new Lotto(List.of(21, 22, 23, 24, 25, 26)),
                () -> new Lotto(List.of(31, 32, 33, 34, 35, 36))
        ));

        assertThat(lottos).containsExactly(
                new Lotto(List.of(11, 12, 13, 14, 15, 16)),
                new Lotto(List.of(21, 22, 23, 24, 25, 26)),
                new Lotto(List.of(31, 32, 33, 34, 35, 36))
        );
    }
}
