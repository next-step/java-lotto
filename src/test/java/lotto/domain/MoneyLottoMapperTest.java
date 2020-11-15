package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyLottoMapperTest {

    @Test
    @DisplayName("구입 금액에 맞는 로또 개수 계산")
    void getLottoNum() {
        int money = 14000;

        int lottoNum = MoneyLottoMapper.calculateLottoNum(money);

        assertThat(lottoNum).isEqualTo(14);
    }
}
