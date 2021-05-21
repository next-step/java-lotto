package step3.game;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import step3.model.LottoNumbers;

public class LottoTest {

    @Test
    @DisplayName("중복되지 않은 로또 번호를 뽑는다")
    void pickLottoTest() {
        Lotto lotto = new Lotto();
        LottoNumbers lottoOne = lotto.pickLottoOne();

        assertThat(lottoOne.size()).isEqualTo(6);
    }

}
