package step2.domain;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step2.dto.LottoDTO;
import step2.dto.LottosDTO;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoStoreTest {
    private LottoStore store;

    @BeforeEach
    void setUp() {
        store = LottoStore.getInstance();
    }

    @Test
    @DisplayName("로또 1장 금액인 1000원 보다 적은 돈을 넣는 경우")
    void less_money() {
        assertThat(store.salesLottos(new Money(500L), new LottosDTO(List.of())).size()).isEqualTo(0);
    }

    @Test
    @DisplayName("로또 14장 구입")
    void lotto() {
        Lottos lottos = store.salesLottos(new Money(14000L), new LottosDTO(List.of()));
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 1장 수동 구입")
    void lotto_user_pick() {
        Lottos lottos = store.salesLottos(new Money(1_000L), new LottosDTO(List.of(new LottoDTO(List.of(1, 2, 3, 4, 5, 6)))));
        assertThat(lottos.size()).isEqualTo(1);
    }
}
