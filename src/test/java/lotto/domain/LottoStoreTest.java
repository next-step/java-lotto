package lotto.domain;

import lotto.exception.ExceptionType;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStoreTest {
    @Test
    void sellLotto() {
        List<Lotto> lottos = LottoStore.sellLotto(14000, Arrays.asList("1,2,3,4,5,6"));

        assertThat(lottos).hasSize(14);
    }

    @Test
    @DisplayName("구매 가능 금액 초과시 에러 테스트")
    void sellLotto_EXCEPTION() {
        assertThatThrownBy(() -> LottoStore.sellLotto(1000, Arrays.asList("1,2,3,4,5,6", "7,8,9,10,11,12")))
                .isInstanceOf(LottoException.class)
                .hasMessageContaining(ExceptionType.NOT_ENOUGH_MONEY.getMessage());
    }
}
