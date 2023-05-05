package step2.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultReportTest {

    @DisplayName("당첨 회수 기록을 테스트한다.")
    @Test
    public void 당첨회수_기록_테스트() {
        LottoResultReport lottoResultReport = new LottoResultReport();

        List<Integer> matchCountList = Arrays.asList(3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6);
        for (Integer count : matchCountList) {
            lottoResultReport.recordRank(count);
        }

        for (int i = 3; i < 7; i++) {
            assertThat(lottoResultReport.findReportByMatchCount(i)).isEqualTo(i);
        }
    }

    @DisplayName("당첨금에 따른 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("lottoReportSample")
    public void 수익률_연산(int[] lottoReport, int sum) throws Exception {
        LottoResultReport lottoResultReport = new LottoResultReport();
        assertThat(lottoResultReport.sum(lottoReport)).isEqualTo(sum);
    }

    static Stream<Arguments> lottoReportSample() throws Throwable {
        return Stream.of(
                Arguments.of(new int[]{0, 1, 1, 0, 0, 0, 0}, 0),
                Arguments.of(new int[]{0, 0, 0, 1, 0, 0, 0}, 5000),
                Arguments.of(new int[]{0, 0, 0, 0, 1, 0, 0}, 50000),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 1, 0}, 1500000),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 1}, 2000000000),
                Arguments.of(new int[]{0, 0, 0, 1, 0, 1, 1}, 2001505000)
        );
    }

    @DisplayName("당첨금에 따른 수익률을 계산한다.")
    @ParameterizedTest
    @MethodSource("lottoReportSample2")
    public void 수익률_연산(LottoResultReport lottoResultReport, int matchCount, int result) throws Exception {
        assertThat(lottoResultReport.findReportByMatchCount(matchCount)).isEqualTo(result);
    }

    static Stream<Arguments> lottoReportSample2() throws Throwable {
        return Stream.of(
                Arguments.of(new LottoResultReport(new int[]{0, 1, 1, 0, 0, 0, 0}), 3, 0),
                Arguments.of(new LottoResultReport(new int[]{0, 0, 0, 1, 0, 0, 0}), 3, 1),
                Arguments.of(new LottoResultReport(new int[]{0, 0, 57, 0, 12, 0, 0}), 4, 12),
                Arguments.of(new LottoResultReport(new int[]{0, 0, 5, 0, 0, 42, 0}), 5, 42),
                Arguments.of(new LottoResultReport(new int[]{0, 0, 6, 0, 12, 1, 8}), 6, 8)
        );
    }

}
