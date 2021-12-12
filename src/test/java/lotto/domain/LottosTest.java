package lotto.domain;

import lotto.domain.fixture.TestLottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @DisplayName("로또가격은 1000원, 가지고 있는 금액만큼 로또를 구입한다")
    @Test
    void 금액만큼_로또구입() {
        Lottos lottos = new Lottos(10000);
        assertThat(lottos.numberOfLotto()).isEqualTo(10);
    }

    @DisplayName("로또가격보다 적은 구입금액 입력시 예외")
    @Test
    void 잔액부족() {
        assertThatThrownBy(() -> new Lottos(900))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 부족합니다.");
    }

    @DisplayName("당첨번호와 3개 일치하는 로또의 수는 1개이다.")
    @Test
    void result_당첨결과() {
        Lottos lottos = new Lottos(createLottos());
        Lotto winningNumbers = TestLottoFactory.create(new int[]{3, 6, 9, 12, 15, 2});
        LottoResult result = lottos.result(winningNumbers);

        assertThat(result.numberOfLotto(3)).isEqualTo(1);
    }

    private static List<Lotto> createLottos() {
        return Arrays.asList(
                TestLottoFactory.create(new int[]{1, 2, 3, 4, 5, 6}),
                TestLottoFactory.create(new int[]{6, 7, 8, 9, 10, 11}),
                TestLottoFactory.create(new int[]{12, 13, 14, 15, 16, 17}),
                TestLottoFactory.create(new int[]{20, 25, 30, 25, 40, 45}));
    }
}
