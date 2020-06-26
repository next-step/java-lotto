package step4.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step4.domain.lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

class LottoGameTest {

    @Test
    void matchingWinningNumbers() {
    }

    @DisplayName("로또 구매 매수에 따른 실 생성")
    @ParameterizedTest
    @CsvSource(value = {"1000", "2000", "15000"}, delimiter = ':')
    public void matchingWinningNumbers(String boughtLotto) {

        // set
        PurchaseInfo purchaseInfo = new PurchaseInfo(boughtLotto, "0");
        List<Lotto> selfChosenLottos = new ArrayList<>();
        LottoGame lottoGame = LottoGame.create(purchaseInfo, selfChosenLottos);
        // 테스트만을 위한 메소드 생성이 옳은가... 에 대한 고민..
        //assertThat(lottoGame.).isEqualTo(boughtLotto);
    }

}
