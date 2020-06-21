package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step2.util.Utils;

class LottoSheetTest {

    private static Stream<Arguments> mergeLottoSheetTestCase() {
        return Stream.of(
            Arguments.of(new LottoSheet(Arrays.asList(new UserLotto(
                    Utils.convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6))))),
                new LottoSheet(Arrays.asList(new UserLotto(
                    Utils.convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6))))), 2),
            Arguments.of(new LottoSheet(Arrays.asList(new UserLotto(
                    Utils.convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6))))),
                null, 1),
            Arguments.of(new LottoSheet(Arrays.asList(new UserLotto(
                    Utils.convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6))))),
                new LottoSheet(), 1),
            Arguments.of(new LottoSheet(), new LottoSheet(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("mergeLottoSheetTestCase")
    void mergeLottoSheet(LottoSheet lottoSheet, LottoSheet lottoSheet2, Integer expected) {

        //when
        LottoSheet mergedLottoSheet = lottoSheet.mergeLottoSheet(lottoSheet2);

        //then
        assertThat(mergedLottoSheet.getLottos()).hasSize(expected);
    }


    private static Stream<Arguments> getLottoCountTestCase() {
        return Stream.of(
            Arguments
                .of(new LottoSheet(Arrays.asList(new UserLotto(
                        Utils.convertIntegerToLottoNumberList(Arrays.asList(1, 2, 3, 4, 5, 6))))),
                    1),
            Arguments.of(new LottoSheet(), 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getLottoCountTestCase")
    void getLottoCount(LottoSheet lottoSheet, Integer expected) {
        //when&then
        assertThat(lottoSheet.getLottoCount()).isEqualTo(expected);
    }
}