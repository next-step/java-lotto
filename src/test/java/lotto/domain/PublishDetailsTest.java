package lotto.domain;

import lotto.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static java.util.Collections.nCopies;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PublishDetailsTest {

    @DisplayName("입력값이 하나라도 null이면 예외를 던진다")
    @ParameterizedTest(name = "[{index}] dollars: {0}, manualLottoLines: {1}")
    @MethodSource("nullInputArguments")
    void create_nullInput_thrownException(Dollars dollars, List<LottoNumbers> manualLottoLines) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new PublishDetails(dollars, manualLottoLines))
                .withMessage(Validator.REQUIRED_ERROR_MESSAGE);
    }

    public static Stream<Arguments> nullInputArguments() {
        return Stream.of(
                Arguments.of(new Dollars(1000), null),
                Arguments.of(null, singletonList(LottoNumbers.of(asList(1, 2, 3, 4, 5, 6)))),
                Arguments.of(null, null)
        );
    }

    @DisplayName("달러개수 - 수동구매개수 = 자동구매개수")
    @ParameterizedTest(name = "[{index}] dollars: {0}, manualLineCount: {1} expectedAutoLineCount: {2}")
    @MethodSource("autoLottoLinesCountArguments")
    void autoLottoLineCount(Dollars dollars, int manualLineCount, int expectedAutoLineCount) {
        //given
        LottoNumbers manualLottoLine = LottoNumbers.of(asList(1, 2, 3, 4, 5, 6));
        List<LottoNumbers> manualLottoLines = nCopies(manualLineCount, manualLottoLine);
        PublishDetails publishDetails = new PublishDetails(dollars, manualLottoLines);

        //when
        int autoLineCount = publishDetails.autoLottoLineCount();

        //then
        assertThat(autoLineCount).isEqualTo(expectedAutoLineCount);
    }

    public static Stream<Arguments> autoLottoLinesCountArguments() {
        Dollars dollars = new Dollars(4000);
        return Stream.of(
                Arguments.of(dollars, 0, 4),
                Arguments.of(dollars, 1, 3),
                Arguments.of(dollars, 4, 0)
        );
    }

}
