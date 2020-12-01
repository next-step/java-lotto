package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class SoldLottoTest {

    @Test
    @DisplayName(value = "count 만큼 로또를 생성하는지 테스트함.")
    void create() {
        SoldLotto soldLotto = new SoldLotto(10);
        assertThat(soldLotto.getSoldLotto().size()).isEqualTo(10);
    }
}