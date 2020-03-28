package LottoTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 번호 생성기 테스트")
public class LottoGeneratorTests {

    @DisplayName("자동 로또 번호 생성 테스트")
    @Test
    public void generateAutomaticTest() {
        assertThat(RandomLottoGenerator.generate())
                .hasSize(6)
                .allmatch(number -> number >= 1 && number <= 45);
    }

}
