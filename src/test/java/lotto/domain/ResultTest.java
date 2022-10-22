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
    void winnings(LottoNumbers lottoNumbers, LottoNumber luckyNumber, BonusNumber bonusNumber, List<Winning> expected) {
        assertThat(winnings(lottoNumbers, luckyNumber, bonusNumber)).hasSameElementsAs(expected);
    }
    
    private List<Winning> winnings(LottoNumbers lottoNumbers, LottoNumber luckyNumber, BonusNumber bonusNumber) {
        List<Winning> winnings = new ArrayList<>();
        Result.of(lottoNumbers, luckyNumber, bonusNumber, new Money(1000)).winnings().iterator().forEachRemaining(winnings::add);
        return winnings;
    }
    
    private static Stream<Arguments> winningsSet() {
        return Stream.of(
                Arguments.arguments(
                        lottoNumbers(
                                lottoNumber(1, 2, 3, 4, 5, 6),
                                lottoNumber(1, 2, 3, 4, 5, 11),
                                lottoNumber(1, 2, 3, 4, 5, 13),
                                lottoNumber(1, 2, 3, 4, 20, 21),
                                lottoNumber(1, 3, 5, 6, 30, 31),
                                lottoNumber(5, 6, 4, 8, 9, 10),
                                lottoNumber(1, 2, 3, 8, 9, 10)
                        ),
                        lottoNumber(1, 2, 3, 4, 5, 6),
                        bonusNumber(11),
                        winnings(
                                winning(Prize.FIRST, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 6))),
                                winning(Prize.SECOND, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 11))),
                                winning(Prize.THIRD, lottoNumbers(lottoNumber(1, 2, 3, 4, 5, 13))),
                                winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 2, 3, 4, 20, 21))),
                                winning(Prize.FOURTH, lottoNumbers(lottoNumber(1, 3, 5, 6, 30, 31))),
                                winning(Prize.FIFTH, lottoNumbers(lottoNumber(5, 6, 4, 8, 9, 10))),
                                winning(Prize.FIFTH, lottoNumbers(lottoNumber(1, 2, 3, 8, 9, 10)))
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
    
    private static BonusNumber bonusNumber(int number) {
        return new BonusNumber(number);
    }
}
