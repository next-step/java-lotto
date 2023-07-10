package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LottoTest {

    @Test
    void createLottoTest() {
        Assertions.assertDoesNotThrow(() -> new Lotto());
    }

    @Test
    void createSixNumbersTest() {
        //given
        Lotto lotto = Lotto.createLotto();

        //when, then
        assertThat(lotto.getNumbers()).hasSize(6);
    }
}
