package step4.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Lotto;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 번호는 중복되지 않은 6개의 숫자여야 한다.")
    @Test
    public void duplicatedTest() {
        Assertions.assertThatIllegalArgumentException().isThrownBy(
                () -> Lotto.of(List.of(1, 2, 3, 4, 5, 5))
        );
    }
}