package edu.nextstep.camp.lotto;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {
    static Stream<Arguments> parseLotto1To6AsList() {
        return Stream.of(
            Arguments.of(List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)))
        );
    }

    static Stream<Arguments> parseLottoInvalid() {
        return Stream.of(
            Arguments.of(
                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5))
            ),
            Arguments.of(
                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7))
            )
        );
    }

    @ParameterizedTest(name = "create from list: {arguments}")
    @MethodSource("parseLotto1To6AsList")
    public void createFromList(List<LottoNumber> numbers) {
        assertThat(Lotto.of(numbers))
                .isEqualTo(Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        assertThat(Lotto.of(numbers).collect()).hasSize(6);
        assertThat(Lotto.of(numbers).collect())
                .containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }

    @Test
    public void createFromList() {
        assertThat(Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)))
                .isEqualTo(Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)));
        assertThat(Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)).collect()).hasSize(6);
        assertThat(Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6)).collect())
                .containsExactly(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6));
    }

    @ParameterizedTest(name = "create failed from list: {arguments}")
    @NullAndEmptySource
    @MethodSource("parseLottoInvalid")
    public void createFailedFromList(List<LottoNumber> numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(numbers))
                .withMessageContaining("invalid input");
    }

    @ParameterizedTest(name = "create failed from objects: {arguments}")
    @NullAndEmptySource
    public void createFailedFromObjects(LottoNumber[] numbers) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(numbers))
                .withMessageContaining("invalid input");
    }

    @Test
    @DisplayName("create failed from objects: {arguments}")
    public void createFailedFromObjects() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5)))
                .withMessageContaining("invalid input");
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6), LottoNumber.of(7)))
                .withMessageContaining("invalid input");
    }
}
