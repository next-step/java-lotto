package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketsTest {

    @ParameterizedTest
    @MethodSource("provideListForStringNumbers")
    @DisplayName("당첨 번호 입력 시 결과를 반환한다")
    void makeStatisticsTest(List<String> numbers, int firstCount, int secondCount, int thirdCount, int fourthCount) {
        LottoNumbers winningNumbers = LottoNumbers.of("1,2,3,4,5,6");
        List<LottoNumbers> lottoNumbersList = numbers.stream()
                .map(LottoNumbers::of)
                .collect(Collectors.toList());

        LottoTickets lottoTickets = LottoTickets.of(lottoNumbersList, winningNumbers);
        LottoResult result = lottoTickets.matchResult();

        assertThat(result.prizeCount(Prize.FIRST)).isEqualTo(firstCount);
        assertThat(result.prizeCount(Prize.SECOND)).isEqualTo(secondCount);
        assertThat(result.prizeCount(Prize.THIRD)).isEqualTo(thirdCount);
        assertThat(result.prizeCount(Prize.FOURTH)).isEqualTo(fourthCount);
    }

    private static Stream<Arguments> provideListForStringNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8"), 1, 1, 1, 0),
                Arguments.of(Arrays.asList("1,2,3,6,7,8", "2,3,4,5,6,7", "3,4,5,6,7,8", "1,2,3,7,8,9"), 0, 1, 2, 1)
        );
    }
}