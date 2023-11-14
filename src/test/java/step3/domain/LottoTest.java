package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    Lotto lottoFixture(Integer... numbers) {
        return new Lotto(
                Arrays.stream(numbers)
                        .map(LottoNumber::of)
                        .collect(Collectors.toList())
        );
    }

    @Test
    @DisplayName("로또는 중복되지 않는 6개의 숫자로 만들수 있다.")
    void createWithNonSameNumber() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoFixture(1,2,3,4,5,5));
    }

    @Test
    @DisplayName("로또는 6개의 숫자로 만들수 있다.")
    void create() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoFixture(1,2,3,4,5,6,7));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoFixture(1));
    }



}
