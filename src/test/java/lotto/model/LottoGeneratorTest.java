package lotto.model;

import lotto.util.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @DisplayName("자동 로또 생성 되는지 테스트")
    @Test
    void makeLottoTest() {
        assertThat(LottoGenerator.makeAutoLotto().getClass()).isEqualTo(Lotto.class);
    }

    @DisplayName("수동 로또 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6"})
    void makeManualLottoTest(String inputNumber) {

        assertThat(LottoGenerator.makeManualLotto(inputNumber).getClass()).isEqualTo(Lotto.class);
    }
}
