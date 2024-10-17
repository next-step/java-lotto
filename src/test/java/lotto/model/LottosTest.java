package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 생성자_테스트() {
        Lottos lottos = new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,6)));

        assertThat(lottos).isEqualTo(new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,6))));
    }

    @DisplayName("match 메소드는 유저의 로또와 당첨 로또를 비교해, 입력 갯수만큼 일치하는 로또의 갯수를 반환한다.")
    @Test
    void match_메소드_테스트() {
        Lottos userLottos = new Lottos(List.of(new Lotto(1,2,3,4,5,6), new Lotto(1,2,3,4,5,7)));
        Lotto winningLotto = new Lotto("1,2,3,4,5,6");

        long expected = userLottos.match(winningLotto, 6);

        assertThat(expected).isEqualTo(1);
    }

    @DisplayName("calculateProfit 메소드는 유저 로또와 당첨 번호를 비교해, 수익률을 반환한다.")
    @Test
    void calculateProfit_메소드_테스트() {
        Lottos userLottos = new Lottos(List.of(new Lotto("8,21,23,41,42,43"), new Lotto("3,5,11,16,32,38"), new Lotto("7,11,16,35,36,44")));
        Lotto winningLotto = new Lotto("8,21,4,3,2,1");

        long expected = userLottos.calculateProfit(winningLotto);

        assertThat(expected).isEqualTo(0);
    }

    @DisplayName("calculateMatchingCounts 메소드는 유저 로또와 당첨 번호를 비교해, 1등 ~ 4등 까지의 일치 갯수를 반환한다.")
    @Test
    void calculateMatchingCounts_메소드_테스트() {
        Lottos userLottos = new Lottos(List.of(new Lotto("8,21,4,3,2,1"), new Lotto("8,21,4,10,11,12"), new Lotto("8,21,4,3,10,11")));
        Lotto winningLotto = new Lotto("8,21,4,3,2,1");

        List<Long> expected = userLottos.calculateMatchingCounts(winningLotto);

        assertThat(expected).isEqualTo(List.of(1L, 1L, 0L, 1L));
    }
}
