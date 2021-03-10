package lotto;

import lotto.domain.LotteryNumber;
import lotto.domain.LottoNumberRandomGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberRandomGeneratorTest {

    @Test
    @DisplayName("로또번호를 랜덤으로 생성하는지 테스트")
    void generate() {
        int maxTryCount = 100;
        for (int i = 0; i < maxTryCount; i++) {
            LotteryNumber generatedNumber = LottoNumberRandomGenerator.generate();
            assertThat(generatedNumber.getValue()).isBetween(LotteryNumber.MIN_VALUE,LotteryNumber.MAX_VALUE);
        }
    }
}
