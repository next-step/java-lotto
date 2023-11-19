package lotto;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class lottoTest {

    @DisplayName("로또 생성시 랜덤 숫자 6개를 추출한다.")
    @Test
    void lotto() {
        Lotto lotto = new Lotto();
        System.out.println(lotto.getLotto());
        assertThat(lotto.getLotto().size()).isEqualTo(6);
    }
}
