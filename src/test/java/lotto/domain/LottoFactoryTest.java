package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoFactoryTest {

    private final LottoFactory lottoFactory = new LottoFactory();

    @Test
    void createLottoTest() {
        Lotto actual = lottoFactory.createLotto();

        assertThat(actual).isNotNull();
    }
}
