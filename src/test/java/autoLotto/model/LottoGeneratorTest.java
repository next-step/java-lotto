package autoLotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;

    @Test
    @DisplayName("자동 로또 생성 테스트 : 랜덤 로또 생성 전략을 사용하여 랜덤 값이 정상 생성됨")
    void testGenerateLottoNumbers_RandomLottoMachine_ReturnRandomLotto() {
        // given
        LottoGenerator generator = new LottoGenerator();
        LottoGeneratorStrategy lottoGeneratorStrategy = new RandomLottoGeneratorStrategy();

        // when
        int[] result = generator.generateLottoNumbers(lottoGeneratorStrategy);
        Set<Integer> set = Arrays.stream(result)
                                 .boxed()
                                 .collect(Collectors.toSet());

        // then
        // 1. 서로 다른 값을 가지며
        // 2. 동시에 1 이상, 45 이하의 숫자를 가짐
        for (int i : result) {
            assertThat(i).isBetween(MIN_NUMBER, MAX_NUMBER);
        }
        assertThat(set.size()).isEqualTo(result.length);
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
