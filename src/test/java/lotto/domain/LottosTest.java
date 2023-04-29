package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {

    @Test
    @DisplayName("Lottos 를 생성한다.")
    void test01() {
        Lottos lottos = new Lottos(1000, LottoType.AUTO);

        assertThat(lottos).isNotNull();
    }

    @Test
    @DisplayName("구입금액으로 Lottos 를 생성한다.")
    void test02() {
        Lottos lottos = new Lottos(10100, LottoType.AUTO);

        assertThat(lottos.lottos()).hasSize(10);
    }

    @Test
    @DisplayName("구입금액이 천원보다 적으면 에러를 발생한다.")
    void test03() {
        assertThatThrownBy(() -> new Lottos(0, LottoType.AUTO)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 번호 확인을 한다.")
    void test04() {
        Lottos lottos = new Lottos(new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6),
                                   new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5, 11));

        List<WinType> winTypes = lottos.confirmWins(new WinNumbers(List.of(1, 2, 3, 4, 5, 6), new LottoNumber(45)));

        assertThat(winTypes).containsExactly(WinType.FIRST, WinType.THIRD);
    }

    @Test
    @DisplayName("수동 번호로 로또를 생성한다.")
    void test05() {
        List<Lotto> numbers = List.of(new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6));
        Lottos lottos = new Lottos(2000, numbers);

        assertThat(lottos.lottos()).hasSize(2);
        assertThat(lottos.lottos()).contains(new Lotto(LottoType.AUTO, 1, 2, 3, 4, 5, 6));
    }
}
