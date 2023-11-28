package lotto.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoFactoryTest {

    @Test
    @DisplayName("로또구매/자동 구매 개수/개수만큼 로또들을 준다")
    void buyAutoLottos() {
        MyLottos myLottos = LottoFactory.buy(2);

        assertThat(myLottos.getLottos()).hasSize(2);
    }

    @Test
    @DisplayName("로또구매/수동 구매 번호/개수만큼 로또들을 준다")
    void buyManualLottos() {
        MyLottos myLottos = LottoFactory.buy(List.of(List.of(1, 2, 3, 4, 5, 6), List.of(1, 2, 3, 4, 5, 6)));

        assertThat(myLottos.getLottos()).hasSize(2);
    }
}