package lotto;

import lotto.domain.BuyLotto;
import lotto.domain.Count;
import lotto.domain.Money;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class BuyLottoTest {
    @ParameterizedTest
    @ValueSource(ints = {4453, 0, -1000, 5003})
    @DisplayName("1,000원 단위로 입력하지 않은 경우 오류체크를 확인한다.")
    void 로또_구입_금액_1000원_단위_오류체크(int amt) {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
                        .isThrownBy(() -> {new BuyLotto(new Money(amt));});
    }

    @Test
    @DisplayName("구입 금액에 따라 로또 개수가 잘 계산되는지 확인한다.")
    void 로또_구입_금액에_따른_로또_개수_계산_확인() {
        BuyLotto buyLotto = new BuyLotto(new Money(10000), new Count(4));

        assertThat(buyLotto.getCount().getCount()).isEqualTo(10);
    }

    @Test
    @DisplayName("수동 로또 개수가 잘 계산되는지 확인한다.")
    void 수동_로또_구입_계산_확인() {
        BuyLotto buyLotto = new BuyLotto(new Money(10000), new Count(4));

        assertThat(buyLotto.getPassiveCount().getCount()).isEqualTo(4);
        assertThat(buyLotto.getAutoCount().getCount()).isEqualTo(6);
        assertThat(buyLotto.getCount().getCount()).isEqualTo(10);
    }
}