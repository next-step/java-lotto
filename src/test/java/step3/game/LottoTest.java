package step3.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.model.Price;
import step3.model.TotalLotto;

public class LottoTest {

    @Test
    @DisplayName("금액 입력 시 금액에 맞는 로또 배열 반환")
    void pickLottoWithPriceTest() {
        TotalLotto lottoTotal = new Lotto()
            .pickLottoWithPrice(new Price(14000));
        assertThat(lottoTotal.totalSize()).isEqualTo("14");
    }

}
