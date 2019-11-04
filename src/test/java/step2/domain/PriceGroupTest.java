package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PriceGroupTest {

    private static Stream<Arguments> getPriceGroup() {
        return Stream.of(
                Arguments.of(0, PriceGroup.ZERO),
                Arguments.of(3, PriceGroup.THREE),
                Arguments.of(6, PriceGroup.SIX)
        );
    }

    @ParameterizedTest
    @MethodSource("getPriceGroup")
    void 맞춘갯수로_당첨금액_가져오기(Integer matchAmount, PriceGroup answer) {
        PriceGroup priceGroup = PriceGroup.findPriceByMatchAmount(matchAmount);

        assertThat(priceGroup).isEqualTo(answer);
    }
}