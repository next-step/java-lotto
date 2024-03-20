package domain;

import domain.Lotto;
import domain.Lottos;
import domain.Rank;
import domain.Ranks;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("입력받은 로또 구입 금액만큼 로또를 발급한다.")
    @Test
    void test01() {
        // given
        int price = 14000;

        // when
        Lottos lottos = new Lottos(price);

        // then
        assertThat(lottos.getLottoCount()).isEqualTo(14);
    }

    @DisplayName("번호가 일치하는 로또의 갯수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"3,1", "4,1", "5,1", "6,2"})
    void test02(int rank, int expected) {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto0 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto0, lotto1, lotto2, lotto3, lotto4));

        // when
        Ranks ranks = lottos.ranks(winningLotto);

        // then
        assertThat(ranks.count(Rank.of(rank))).isEqualTo(expected);
    }

    @DisplayName("총 수익률을 구한다.")
    @Test
    void test03() {
        // given
        Lotto winningLotto = new Lotto(List.of(10, 11, 12, 13, 14, 15));
        Lotto lotto0 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 4, 5, 12));
        Lotto lotto3 = new Lotto(List.of(1, 2, 3, 4, 11, 12));
        Lotto lotto4 = new Lotto(List.of(1, 2, 3, 10, 11, 12));
        Lottos lottos = new Lottos(List.of(lotto0, lotto1, lotto2, lotto3, lotto4));

        // when
        double result = lottos.rateOfReturn(winningLotto);

        // then
        assertThat(result).isEqualTo(1);
    }
}
