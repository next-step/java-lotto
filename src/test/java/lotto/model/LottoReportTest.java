package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReportTest {

    @ParameterizedTest
    @DisplayName("여러 로또에 대해 결과 레포트 생성")
    @CsvSource(value = {
            "1, 2, 3, 4, 5, 6:1, 0, 0, 0, 1, 0, 1",
            "10, 11, 12, 13, 14, 15:3, 0, 0, 0, 0, 0, 0",
            "2, 9, 13, 27, 42, 15:2, 1, 0, 0, 0, 0, 0"},
            delimiter = ':')
    public void 로또_번호_비교(String otherNumbers, String expected) {
        List<Integer> expectedResult = Arrays.stream(expected.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Lotto> lottos = Arrays.asList(
                new Lotto(List.of(1,2,3,4,5,6)),
                new Lotto(List.of(3,4,5,6,7,8)),
                new Lotto(List.of(20,21,22,23,24,25))
        );
        Assertions.assertThat(new LottoReport(otherNumbers, lottos).result())
                .isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("수익률 계산 - 소수점 둘째자리 이하 버림")
    @CsvSource(value = {
            "1, 0, 0, 2, 1, 0, 0:15",
            "3, 0, 0, 0, 0, 0, 0:0",
            "1, 1, 1, 0, 0, 0, 1:500000",
            "13, 0, 0, 1, 0, 0, 0:0.35"},
            delimiter = ':')
    public void 리포트_수익률_계산(String result, double expected) {
        List<Integer> resultReport = Arrays.stream(result.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Assertions.assertThat(new LottoReport(resultReport).rateOfReturn())
                .isEqualTo(expected);
    }
}
