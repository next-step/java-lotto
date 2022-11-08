package step2.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    void createLottoNumbersTest() {
        List<Integer> lotto = new Lotto().getLotto();
        assertThat(lotto.contains(0)).isFalse();
        assertThat(lotto.contains(46)).isFalse();
    }

}