package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumbersTest {
    @Test
    @DisplayName("로또 번호에 대한 유효성 테스트")
    void validLottoNumbers() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(
                    Stream.of(1,2,3).map(LottoNumber::new).collect(Collectors.toList())
            );
        });

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new LottoNumbers(
                    Stream.of(1,2,3,4,5,5).map(LottoNumber::new).collect(Collectors.toList())
            );
        });
    }
}