package lottogame;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.numbergenerator.NumberGenerator;
import utils.numbergenerator.RandomNumberGenerator;

class LottoTest {

    @Test
    void 로또번호_6개_생성한다() {
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        Lotto lotto = new Lotto(numberGenerator);
        int expected = 6;

        Assertions.assertThat(lotto.create().size()).isEqualTo(expected);
    }
}