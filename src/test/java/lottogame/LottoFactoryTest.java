package lottogame;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.numbergenerator.NumberGenerator;
import utils.numbergenerator.RandomNumberGenerator;

class LottoFactoryTest {

    NumberGenerator numberGenerator;
    LottoFactory factory;

    @BeforeEach
    void setup() {
        numberGenerator = new RandomNumberGenerator();
        factory = new LottoFactory(numberGenerator);
    }

    @Test
    void 로또번호_6개_생성() {
        int expected = 6;

        assertThat(factory.createLotto().getNumbers().size()).isEqualTo(expected);
    }

    @Test
    void 구입금액에_따른_로또갯수를_생성() {
        int money = 10_000;
        int expected = 10;

        assertThat(factory.createLottos(money).size()).isEqualTo(expected);
    }
}