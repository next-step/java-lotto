package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또가 6개의 랜덤 숫자를 가지도록 하는 테스트")
    @Test
    public void lottoNumberTest() {
        // 로또가 랜덤 난수로 제대로 만들어졌다면, 6개의 로또 번호를 가지고 있을 것
        Lotto lotto = LottoFactory.createLottoWithRandomNumbers();
        assertThat(lotto.getLottoSize()).isEqualTo(6);
    }
}
