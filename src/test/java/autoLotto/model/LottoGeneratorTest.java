package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    private static final int VALID_LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    @Test
    @DisplayName("자동 로또 생성 테스트 : 랜덤 로또 생성 전략을 사용하여 랜덤 값이 정상 생성됨")
    void testGenerateLottoNumbers_RandomLottoMachine_ReturnRandomLotto() {
        // given
        LottoGenerator generator = new LottoGenerator();
        LottoGeneratorStrategy lottoGeneratorStrategy = new RandomLottoGeneratorStrategy();

        // when
        Set<LottoNumber> result = generator.generateRandomLottoNumbers(lottoGeneratorStrategy);

        // then
        for (LottoNumber lottoNumber : result) {
            assertThat(lottoNumber.getLottoNumber()).isBetween(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        }
        assertThat(result.size()).isEqualTo(VALID_LOTTO_LENGTH);
    }

    @Test
    @DisplayName("자동 로또 생성 테스트 : 전략 패턴이 null로 들어와 예외 발생")
    void testGenerateLottoNumbers_NoneStrategy_ThrowException() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when, then
        assertThatThrownBy(() -> generator.generateRandomLottoNumbers(null))
                .isInstanceOf(NullPointerException.class);
    }
}
