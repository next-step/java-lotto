package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static autoLotto.model.LottoConstants.LOTTO_END_NUMBER;
import static autoLotto.model.LottoConstants.LOTTO_START_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    @Test
    @DisplayName("자동 로또 생성 테스트 : 랜덤 로또 생성 전략을 사용하여 랜덤 값이 정상 생성됨")
    void testGenerateLottoNumbers_RandomLottoMachine_ReturnRandomLotto() {
        // given
        LottoGenerator generator = new LottoGenerator();
        LottoGeneratorStrategy lottoGeneratorStrategy = new RandomLottoGeneratorStrategy();

        // when
        List<Integer> result = generator.generateLottoNumbers(lottoGeneratorStrategy);
        Set<Integer> set = new HashSet<>(result);

        // then
        for (int i : result) {
            assertThat(i).isBetween(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        }
        assertThat(set.size()).isEqualTo(result.size());
    }

    @Test
    @DisplayName("자동 로또 생성 테스트 : 전략 패턴이 null로 들어와 예외 발생")
   void testGenerateLottoNumbers_NoneStrategy_ThrowException() {
        // given
        LottoGenerator generator = new LottoGenerator();

        // when, then
        assertThatThrownBy(() -> generator.generateLottoNumbers(null))
                .isInstanceOf(NullPointerException.class);
    }
}
