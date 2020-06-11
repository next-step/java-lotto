package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ManualLottoCreatorTest {
    private List<String> lottoNumbers;

    @BeforeEach
    void setup() {
        lottoNumbers = new ArrayList<>();
        lottoNumbers.add("1, 2, 3, 4, 5, 6");
        lottoNumbers.add("11, 12, 13, 14, 25, 26");
    }

    @Test
    void createLottos() {
        List<Lotto> lottos = ManualLottoCreator.createLottos(lottoNumbers);
        assertAll(
                () -> assertThat(lottos).hasSize(2),
                () -> assertThat(lottos.get(0).getLottoNumbers()).hasSize(6)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, s, 3, 4, a, 2"})
    @DisplayName("숫자가 아닐 경우 예외 발생")
    void exceptionParseInt(String input) {
        List<String> lottos = new ArrayList<>();
        lottos.add(input);

        Throwable thrown = catchThrowable(() -> ManualLottoCreator.createLottos(lottos));

        assertThat(thrown).isInstanceOf(NumberFormatException.class).hasMessageContaining("숫자가 아닙니다.");
    }
}
