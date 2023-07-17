package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.vo.Money;
import lotto.domain.vo.Quantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    private final List<Lotto> lottos = new ArrayList<>();

    @BeforeEach
    void setUp() {
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 6))); // 1등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 7))); // 2등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 5, 8))); // 3등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 4, 8, 9))); // 4등
        lottos.add(Lotto.createSpecificLotto(List.of(1, 2, 3, 8, 9, 10))); // 5등
        lottos.add(Lotto.createSpecificLotto(List.of(21, 22, 23, 24, 25, 26))); // 등수없음
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 구매 수량 테스트.")
    void createLottoGroupTest() {
        LottoGroup lottoGroup = LottoGroup.createRandomLottos(new Money(14000L));
        assertThat(lottoGroup.getLottos()).hasSize(14);
    }

    @Test
    @DisplayName("로또 구매 수량이 0인 경우 예외 던진다.")
    void zeroQuantityThrowsExceptionTest() {
        assertThrows(IllegalArgumentException.class,
            () -> LottoGroup.createRandomLottos(new Money(0L)));
    }

    @Test
    @DisplayName("자동 로또의 구매 개수와 수동으로 구매할 로또 번호를 입력하면 적절한 로또를 생성한다. ")
    void createManualAndRandomLotto() {
        // when
        LottoGroup lottoGroup = LottoGroup.createRandomAndManualLottos(new Quantity(8), lottos);

        // then
        assertThat(lottoGroup.getLottos()).hasSize(14);
        assertThat(lottoGroup.getLottos()).containsAll(lottos);
    }

    @Test
    @DisplayName("보유 금액으로 수량만큼 로또를 구매할 수 없으면 예외를 false 를 반환한다.")
    void canBuyableTest() {
        assertThat(LottoGroup.canBuy(new Money(1000L), new Quantity(2))).isFalse();
        assertThat(LottoGroup.canBuy(new Money(1000L), new Quantity(1))).isTrue();
    }
}