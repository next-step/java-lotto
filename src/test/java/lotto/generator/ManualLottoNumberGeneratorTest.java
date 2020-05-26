package lotto.generator;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoNumberGeneratorTest {

    private LottoNumberGenerator lottoNumberGenerator;

    @BeforeEach
    void setup() {
        this.lottoNumberGenerator = new ManualLottoNumberGenerator();
    }

    @ParameterizedTest
    @MethodSource("provideManualLottoNumbers")
    @DisplayName("수동 로또 번호 발급 테스트")
    void generateManualLottoNumbers(List<Integer> lottoNumbers) {
        List<Lotto> lottos = this.createLottos(lottoNumbers);
        List<Lotto> lottoResult = this.lottoNumberGenerator.generateLottoNumber(lottos, lottoNumbers.size());
        assertThat(lottoResult).containsAll(lottos);
    }

    private static Stream<Arguments> provideManualLottoNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1,2,3,4,5,6)),
                Arguments.of(Arrays.asList(8,3,5,45,11,1))
        );
    }

    private List<Lotto> createLottos(List<Integer> lottoNumbers) {
        return lottoNumbers.stream()
                .map(lottoNumber -> new Lotto(lottoNumber))
                .collect(Collectors.toList());
    }
}