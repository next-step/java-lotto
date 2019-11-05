package step2.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PriceGroupTest {

    private static Stream<Arguments> getPriceGroup() {
        return Stream.of(
                Arguments.of(0, false, PriceGroup.ZERO),
                Arguments.of(3, false, PriceGroup.THREE),
                Arguments.of(5, false, PriceGroup.FIVE),
                Arguments.of(5, true, PriceGroup.FIVE_WITH_BONUS),
                Arguments.of(6, false, PriceGroup.SIX)
        );
    }

    @ParameterizedTest
    @MethodSource("getPriceGroup")
    void 맞춘갯수로_당첨금액_가져오기(Integer matchAmount, boolean hasBonus, PriceGroup answer) {
        PriceGroup priceGroup = PriceGroup.findPriceByMatchAmount(matchAmount, hasBonus);

        assertThat(priceGroup).isEqualTo(answer);
    }
}