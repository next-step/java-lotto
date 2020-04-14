package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("콤마로 구분하여 로또 번호 생성")
    @Test
    public void createOfComma() {
        Lotto lotto = Lotto.ofComma("1,2,3,4,5,6");
        assertThat(lotto).isNotNull();
    }

    @DisplayName("로또는 중복되지 않는 6개의 번호로 구성")
    @Test
    public void lotto() {

    }
}
