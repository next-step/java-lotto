package step02.domain;

import exception.LottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class LottoPriceTest {
    @DisplayName("생성자")
    @Test
    public void test_LottoPrice_Construct() {
        assertThat(LottoPrice.of(1000))
                .isEqualTo(LottoPrice.of(1000));
    }

    private static Stream<Integer> provideInvalidLottoPriceResult() {
        return Stream.of(-1000, 0);
    }

    @DisplayName("장당 가격이 1원 이하이면 에러 던짐")
    @ParameterizedTest
    @MethodSource("provideInvalidLottoPriceResult")
    public void test_validate(int lottoPrice) {
        assertThatExceptionOfType(LottoPriceException.class)
                .isThrownBy(() -> LottoPrice.of(lottoPrice));
    }
}
