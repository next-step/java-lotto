package LottoTests;

import lotto.AutomaticLottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기 테스트")
public class LottoGeneratorTests {

    @DisplayName("자동 로또 번호 생성 테스트")
    @Test
    public void generateAutomaticTest() {
        assertThat(AutomaticLottoGenerator.generate())
                .hasSize(6)
                .allMatch(number -> number.toInt() >= 1 && number.toInt() <= 45);
    }

}
