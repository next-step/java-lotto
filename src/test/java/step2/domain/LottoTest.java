package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Constants;
import step2.domain.strategy.TestLottoGeneratorStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 테스트")
class LottoTest {

    private Lotto lotto = new Lotto(new TestLottoGeneratorStrategy());

    @BeforeEach
    void setUp() {
        lotto.generateNumber();
    }

    @DisplayName("로또번호 생성")
    @Test
    void generateNumber() {
        assertThat(lotto.toString()).isEqualTo(Constants.TEST_LOTTO_NUMBERS);
    }

    @DisplayName("당첨번호와 일치하는 번호 갯수")
    @Test
    void getMatchCount() {
        assertThat(lotto.getMatchCount(Constants.TEST_WINNER_NUMBERS)).isEqualTo(6);
    }
}
