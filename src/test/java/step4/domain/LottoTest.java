package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import step4.domain.Lotto;
import step4.domain.LottoNumber;
import step4.domain.generator.LottoManualGenerator;

import java.util.stream.Stream;

class LottoTest {

    Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new LottoManualGenerator().generate("1,2,3,4,5,6");
    }

    @ParameterizedTest
    @MethodSource("generateLottoData")
    @DisplayName("로또번호 1,2,3,4,5,6 일 때, 당첨번호 일치하는 개수 기능 테스트 ")
    void equal_lottoNumber_count(String lottoNumber, int count) {
        String[] winningNumbers = lottoNumber.split(",");

        for (String winningNumber : winningNumbers) {
            lotto.checkLottoMatchCount(new LottoNumber(Integer.parseInt(winningNumber)), new LottoNumber(1));
        }

        Assertions.assertEquals(lotto.getCount(), count);
    }


    static Stream<Arguments> generateLottoData() {
        return Stream.of(
                Arguments.of("1,2,3,14,15,16", 3),
                Arguments.of("1,2,3,4,15,16", 4),
                Arguments.of("1,2,3,4,5,16", 5),
                Arguments.of("1,2,3,4,5,6", 6)
        );
    }


    @ParameterizedTest
    @MethodSource("generateLottoBonusData")
    @DisplayName("로또번호 1,2,3,4,5,6 일 때, 보너스 번호 존재 기능 테스트 ")
    void equal_lottoNumber_match_bonus(String lottoNumber, int bonus, boolean expected) {
        String[] winningNumbers = lottoNumber.split(",");

        for (String winningNumber : winningNumbers) {
            lotto.checkLottoMatchCount(new LottoNumber(Integer.parseInt(winningNumber)), new LottoNumber(bonus));
        }

        Assertions.assertEquals(lotto.isMatchBonus(), expected);
    }


    static Stream<Arguments> generateLottoBonusData() {
        return Stream.of(
                Arguments.of("1,2,3,14,15,16", 3, true),
                Arguments.of("1,2,3,4,5,16", 17, false)
        );
    }
}