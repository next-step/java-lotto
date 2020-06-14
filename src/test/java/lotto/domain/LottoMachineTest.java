package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoMachineTest {
    private List<String> stringNumbers;

    @BeforeEach
    void setup() {
        stringNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 25, 26");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    @DisplayName("로또 자동 생성")
    void createAutoLottos(int lottoCount) {
        List<Lotto> lottos = LottoMachine.createAutoLottos(lottoCount);
        assertThat(lottos).hasSize(lottoCount);

        List<LottoNumber> lottoNumbers = lottos.get(0).getLottoNumbers();
        assertThat(lottoNumbers).hasSize(6);
    }

    @Test
    @DisplayName("로또 수동 생성")
    void createManualLottos() {
        List<Lotto> lottos = LottoMachine.createManualLottos(stringNumbers);
        assertAll(
                () -> assertThat(lottos).hasSize(2),
                () -> assertThat(lottos.get(0).getLottoNumbers()).hasSize(6)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, s, 3, 4, a, 2"})
    @DisplayName("숫자가 아닐 경우 예외 발생")
    void exceptionParseInt(String input) {
        List<String> lottos = Collections.singletonList(input);

        assertThatThrownBy(() -> LottoMachine.createManualLottos(lottos))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }
}
