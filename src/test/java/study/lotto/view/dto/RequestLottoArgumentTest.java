package study.lotto.view.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import study.lotto.domain.Money;
import study.lotto.exception.LottoException;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class RequestLottoArgumentTest {

    private static Stream<Arguments> lottoArgumentRange() {
        return Stream.of(
                Arguments.of(Money.of(1000), "a")
        );
    }

    @DisplayName("Lotto Argument 생성 테스트")
    @Test
    void lottoArgument_생성테스트() {
        // given
        RequestLottoArgument lottoArgument = RequestLottoArgument.of(1000);
        // when
        RequestLottoArgument expected = RequestLottoArgument.of(1000);
        // then
        assertThat(lottoArgument).isEqualTo(expected);
    }

    @ParameterizedTest(name = "`{0}` 입력 시 예외 발생")
    @NullAndEmptySource
    void lottoArgument_예외테스트(String given) {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> {
                    RequestLottoArgument.of(given);
                });
    }

    @DisplayName(value = "manualCount 예외 테스트")
    @ParameterizedTest(name = "{0} {1} 입력 시 예외 테스트")
    @MethodSource(value = "lottoArgumentRange")
    void lottoArgument_범위_밖_데이터_예외테스트(Money money, String manualCount) {
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> RequestLottoArgument.of(money, manualCount));
    }
}
