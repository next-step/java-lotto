package lotto.generator;

import lotto.model.Lotto;
import lotto.model.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGeneratorTest {
    private static final int VALID_LOTTO_LENGTH = 6;
    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_END_NUMBER = 45;

    private static final LottoGenerator generator = new LottoGenerator();

    @Test
    @DisplayName("자동 로또 생성 테스트 : 자동 로또 생성 전략을 사용하여 랜덤 값의 로또 생성")
    void testGenerateLottoNumbers_AutoLottoGenerateStrategy_ShouldReturnAutoLotto() {
        // given
        LottoGeneratorStrategy lottoGeneratorStrategy = new AutoLottoGeneratorStrategy();

        // when
        Lotto lotto = generator.generateLottoNumbers(lottoGeneratorStrategy);
        Set<LottoNumber> result = lotto.getLotto();

        // then
        for (LottoNumber lottoNumber : result) {
            assertThat(lottoNumber.getLottoNumber()).isBetween(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        }
        assertThat(result.size()).isEqualTo(VALID_LOTTO_LENGTH);
    }

    @Test
    @DisplayName("수동 로또 생성 테스트 : 수동 로또 생성 전략을 사용하여 주어진 로또 번호로 로또 생성")
    void testGenerateLottoNumbers_ManualLottoGenerateStrategy_ShouldReturnManualLotto() {
        // given
        List<String> lottoNumbers = List.of("1","2","3","4","5","6");
        LottoGeneratorStrategy lottoGeneratorStrategy = new ManualLottoGeneratorStrategy(lottoNumbers);

        // when
        Lotto lotto = generator.generateLottoNumbers(lottoGeneratorStrategy);
        Set<LottoNumber> result = lotto.getLotto();

        // then
        for (LottoNumber lottoNumber : result) {
            assertThat(lottoNumber.getLottoNumber()).isBetween(LOTTO_START_NUMBER, LOTTO_END_NUMBER);
        }
        assertThat(result.size()).isEqualTo(VALID_LOTTO_LENGTH);
    }

    @Test
    @DisplayName("수동 로또 생성 테스트 : 유효하지 않은 로또 값이 들어와 로또 생성 실패")
    void testGenerateLottoNumbers_InvalidManualLottoNumber_ShouldThrowException() {
        // given
        List<String> lottoNumbers = List.of("111","2","3","4","5","6");
        LottoGenerator generator = new LottoGenerator();

        // when, then
        assertThatThrownBy(() -> generator.generateLottoNumbers(new ManualLottoGeneratorStrategy(lottoNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동 로또 생성 테스트 : 유효하지 않은 개수의 로또 번호들이 들어와 로또 생성 실패")
    void testGenerateLottoNumbers_InvalidRangeOfLottoNumbers_ShouldThrowException() {
        // given
        List<String> lottoNumbers = List.of("1","2","3","4","5");
        LottoGenerator generator = new LottoGenerator();

        // when, then
        assertThatThrownBy(() -> generator.generateLottoNumbers(new ManualLottoGeneratorStrategy(lottoNumbers)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자동 로또 생성 테스트 : 전략 패턴이 null로 들어와 예외 발생")
    void testGenerateLottoNumbers_NoneStrategy_ThrowException() {
        // when, then
        assertThatThrownBy(() -> generator.generateLottoNumbers(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
