package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottosTest {


    @Test
    @DisplayName("3개의 로또를 구매하는 경우 3개의 로또가 생성된다.")
    void createLottos() {
        Lottos lottos = Lottos.of(3);

        assertThat(lottos.getLottos()).hasSize(3);
    }

    @Test
    @DisplayName("불변객체인 lottos 배열을 수정할 경우 오류가 발생한다.")
    void lottos_불변객체() {
        List<Lotto> lottos = Lottos.of(3).getLottos();

        assertThatThrownBy(lottos::clear)
                .isInstanceOf(UnsupportedOperationException.class);
    }
    @Test
    @DisplayName("수동로또 1개와 자동로또 3개를 생성하면 ")
    void createLotto_자동_수동() {
        List<List<Integer>> manualNumber = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos autoLottos = Lottos.of(3);
        Lottos manualLottos = Lottos.of(manualNumber);

        assertThat(autoLottos.getLottos()).hasSize(3);
        assertThat(manualLottos.getLottos()).hasSize(1);
    }

    @Test
    @DisplayName("수동 로또 1개와 자동로또 3개의 전체 로또를 합치면 4개의 로또가 나온다")
    void sumLottos() {
        List<List<Integer>> manualNumber = Arrays.asList(Arrays.asList(1, 2, 3, 4, 5, 6));
        Lottos autoLottos = Lottos.of(3);
        Lottos manualLottos = Lottos.of(manualNumber);
        
        assertThat(autoLottos.sumLottos(manualLottos)).hasSize(4);
    }
}