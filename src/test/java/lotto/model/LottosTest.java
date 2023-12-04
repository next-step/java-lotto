package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottosTest {

    @Test
    @DisplayName("입력된 금액만큼 로또 발급")
    public void 금액에_따른_로또_발급_갯수() {
        Assertions.assertThat(Lottos.generate(5).count())
                .isEqualTo(5);
    }
}
