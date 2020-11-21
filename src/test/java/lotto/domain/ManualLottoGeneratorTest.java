package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ManualLottoGeneratorTest {

    private LottoGenerator lottoGenerator;

    @BeforeEach
    void setup() {
        lottoGenerator = new CustomManualLottoGenerator();
    }

    @DisplayName("수동 로또 생성 테스트")
    @Test
    void case1() {
        assertThat(lottoGenerator.create()).isEqualTo(lottoGenerator.create());
    }

    public class CustomManualLottoGenerator extends ManualLottoGenerator {
        @Override
        public String intput() {
            return "1,2,3,4,5,6";
        }
    }
}
