package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoNumbers;
import lotto.generator.AutoLottoNumberGenerator;
import lotto.generator.LottoNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AutoLottoNumbersGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setup() {
        lottoNumberGenerator = new AutoLottoNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("자동 로또번호 생성 테스트")
    void generateAutoLottoNumber(List<Lotto> lottos, int lottoSize) {
        List<Lotto> generateLotto = lottoNumberGenerator.generateLottoNumber(lottos, lottoSize);
        assertThat(generateLotto).hasSize(lottoSize);
        Set<Lotto> uniqueNumbers = new HashSet<>(generateLotto);
        assertThat(uniqueNumbers).hasSize(lottoSize);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(LottoNumbers.LOTTO_NUMBERS, LottoNumbers.LOTTO_SIZE)
        );
    }
}