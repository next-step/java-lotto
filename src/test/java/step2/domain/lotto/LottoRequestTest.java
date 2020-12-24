package step2.domain.lotto;

import step2.domain.LottoRequest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.*;

public class LottoRequestTest {
    @Test
    @DisplayName("로또(수동) 구매 테스트")
    void manualPickLottoTest() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers(asList(1, 10, 20, 30, 40, 45)));

        LottoRequest lottoRequest = new LottoRequest(3000, lottoNumbers);

        assertThat(lottoRequest).extracting("purchaseMoney", "totalQuantityForAutomatedPick")
                .containsExactly(3000, 2);
        assertThat(lottoRequest.getLottoNumbersByManualPick().size()).isEqualTo(1);
    }

    @Test
    @DisplayName("로또(수동) 구매 실패 테스트")
    void manualPickLottoFailTest() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers(asList(1, 10, 20, 30, 40, 45)));
        lottoNumbers.add(new LottoNumbers(asList(1, 7, 10, 20, 30, 40)));
        lottoNumbers.add(new LottoNumbers(asList(1, 10, 20, 30, 40, 41)));

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoRequest(2000, lottoNumbers))
                .withMessageContaining("지불 금액을 초과하여 로또를 구매할 수 없습니다");
    }
}
