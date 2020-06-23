package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoMachineTest {
    private List<String> stringNumbers;

    @BeforeEach
    void setup() {
        stringNumbers = Arrays.asList("1, 2, 3, 4, 5, 6", "11, 12, 13, 14, 25, 26");
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 3})
    @DisplayName("로또 수동&자동 생성")
    void createLottos(int lottoCount) {
        List<Lotto> lottos = LottoMachine.createLottos(stringNumbers, lottoCount);

        assertThat(lottos).hasSize(lottoCount);
        assertThat(lottos.get(lottoCount - 1).getLottoNumbers()).hasSize(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, s, 3, 4, a, 2"})
    @DisplayName("숫자가 아닐 경우 예외 발생")
    void exceptionParseInt(String input) {
        List<String> lottos = Collections.singletonList(input);

        assertThatThrownBy(() -> LottoMachine.createLottos(lottos, 1))
                .isInstanceOf(NumberFormatException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }
}
