package lotto.domain;

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

class AutoLottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setup() {
        lottoNumberGenerator = new AutoLottoNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("provideLottoNumbers")
    @DisplayName("자동 로또번호 생성 테스트")
    void generateAutoLottoNumber(List<Integer> lottoNumbers, int lottoSize) {
        List<Integer> generateLottoNumber = lottoNumberGenerator.generateLottoNumber(lottoNumbers, lottoSize);
        assertThat(generateLottoNumber).hasSize(lottoSize);
        Set<Integer> uniqueNumbers = new HashSet<>(generateLottoNumber);
        assertThat(uniqueNumbers).hasSize(lottoSize);
    }

    private static Stream<Arguments> provideLottoNumbers() {
        return Stream.of(
                Arguments.of(LottoNumber.LOTTO_NUMBERS, LottoNumber.LOTTO_SIZE)
        );
    }
}