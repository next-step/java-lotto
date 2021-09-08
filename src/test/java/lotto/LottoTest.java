package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class LottoTest {
    @Test
    @DisplayName("로또 번호에 대한 유효성 테스트")
    void validLotto() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoGenerator.generateManualLotto(Arrays.asList(1,2,3));
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoGenerator.generateManualLotto(Arrays.asList(1,2,3,4,5,5));
        });
    }
}