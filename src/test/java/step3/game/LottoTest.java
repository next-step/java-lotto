package step3.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.model.LottoNumbers;
import step3.model.Price;
import step3.model.TotalLotto;

public class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setting() {
        lotto = new Lotto();
    }

    @Test
    @DisplayName("중복된 숫자가 없는 로또 번호를 뽑는다")
    void pickLottoTest() {
        LottoNumbers lottoOne = lotto.pickLottoOne();

        assertThat(lottoOne.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("금액 입력 시 금액에 맞는 로또 배열 반환")
    void pickLottoWithPriceTest() {
        TotalLotto lottoTotal = lotto
            .pickLottoWithPrice(new Price(14000));
        assertThat(lottoTotal.size()).isEqualTo(14);
    }

}
