package step02.domain;

import exception.LottoPriceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
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

    private static Stream<Arguments> provideLottoCountResult() {
        return Stream.of(
                Arguments.of(1000, 10000, 10),
                Arguments.of(1000, 100000, 100),
                Arguments.of(1000, 100001, 100),
                Arguments.of(1000, 1, 0)
        );
    }

    @DisplayName("지불한 돈으로 로또를 몇개 살수 있는지 계산해주는 기능")
    @ParameterizedTest
    @MethodSource("provideLottoCountResult")
    public void test_calculateLottoCount(int lottoPrice, int payment, int lottoCount) {
        assertThat(
                LottoPrice.of(lottoPrice)
                        .calculateLottoCount(payment)
        ).isEqualTo(lottoCount);
    }
}
