package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TotalLottosTest {

    @Test
    @DisplayName("총 구입금액을 올바르게 리턴한다.")
    void test1() {
        //given
        TotalLottos totalLottos = new TotalLottos(List.of(
                new Lotto(Set.of(1, 3, 4, 6, 9, 11)),
                new Lotto(Set.of(1, 3, 4, 5, 6, 7))
        ));
        //then
        assertThat(totalLottos.totalPurchasePrice()).isEqualTo(2000);
    }

    @Test
    @DisplayName("로또 갯수를 리턴한다.")
    void test2() {
        TotalLottos totalLottos = new TotalLottos(List.of(
                new Lotto(Set.of(1, 3, 4, 6, 9, 11)),
                new Lotto(Set.of(1, 3, 4, 5, 6, 7))
        ));
        assertThat(totalLottos.lottoCount()).isEqualTo(2);
    }

}