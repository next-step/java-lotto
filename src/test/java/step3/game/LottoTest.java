package step3.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.model.LottoNumbers;
import step3.model.PurchaseInfo;

public class LottoTest {

    @Test
    @DisplayName("금액 입력 시 금액에 맞는 로또 배열 반환")
    void pickLottoWithPriceTest() {
        List<LottoNumbers> lottoTotal = new Lotto()
            .pickAutoLottoWithPrice(new PurchaseInfo(14000));
        assertThat(lottoTotal.size()).isEqualTo(14);
    }

}
