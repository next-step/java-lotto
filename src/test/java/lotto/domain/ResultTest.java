package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ResultTest {
    @DisplayName("당첨번호를 리턴한다.")
    @ParameterizedTest
    @MethodSource("winningsSet")
    void winnings(LottoNumbers lottoNumbers, LottoNumber luckyNumber, List<Winning> expected) {
        List<Winning> winnings = winnings(lottoNumbers, luckyNumber);
        assertThat(winnings).hasSameElementsAs(expected);
    }
    
    private List<Winning> winnings(LottoNumbers lottoNumbers, LottoNumber luckyNumber) {
        List<Winning> winnings = new ArrayList<>();
        Result.of(lottoNumbers, luckyNumber).iterator().forEachRemaining(winnings::add);
        return winnings;
    }
    
    private static Stream<Arguments> winningsSet() {
        return Stream.of(
                Arguments.arguments(
                        lottoNumbers(
                                lottoNumber(1, 2, 3, 4, 5, 6), 
                                lottoNumber(5, 6, 4, 8, 9, 10)
                        ),
                        lottoNumber(1, 2, 3, 4, 5, 6),
                        winnings(
                                winning(Prize.FOURTH, lottoNumbers(lottoNumber(5, 6, 4, 8, 9, 10))),
                                winning(Prize.FIRST, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6)))
                        )
                )
        );
    }

    private static LottoNumbers lottoNumbers(LottoNumber... lottoNumbers) {
        return new LottoNumbers(Arrays.stream(lottoNumbers).collect(Collectors.toList()));
    }

    private static LottoNumber lottoNumber(int... numbers) {
        return new LottoNumber(Arrays.stream(numbers).boxed().collect(Collectors.toList()));
    }
    
    private static List<Winning> winnings(Winning... winnings) {
        return Arrays.stream(winnings).collect(Collectors.toList());
    }
    
    private static Winning winning(Prize prize, LottoNumbers matchNumbers) {
        return new Winning(prize, matchNumbers);
    }
}
