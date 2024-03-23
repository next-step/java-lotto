package lottogame;

import static org.assertj.core.api.Assertions.assertThat;

import lottogame.domain.LottoFactory;
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
    void 구입금액에_따른_로또갯수를_생성() {
        int money = 10_000;
        int price = 1_000;
        int expected = 10;

        assertThat(factory.createLottos(money, price).size()).isEqualTo(expected);
    }
}