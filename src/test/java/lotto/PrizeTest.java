package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Prize;
import lotto.domain.WinningLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@Nested
@DisplayName("Prize 클래스는")
public class PrizeTest {
    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        Lotto lotto = Lotto.ofManualStringLottoNumbers("1,2,3,7,8,9");
        WinningLotto winningNumber = WinningLotto.ofString("1,2,3,4,5,6");
        LottoNumber bonus = LottoNumber.ofInt(10);
        Prize prize = Prize.FIFTH;
        listOfArguments.add(Arguments.of(lotto, winningNumber, bonus, prize));

        Lotto lotto_1 = Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6");
        WinningLotto winningNumber_1 = WinningLotto.ofString("1,2,3,4,5,9");
        LottoNumber bonus_1 = LottoNumber.ofInt(6);
        Prize prize_1 = Prize.SECOND;
        listOfArguments.add(Arguments.of(lotto_1, winningNumber_1, bonus_1, prize_1));

        Lotto lotto_2 = Lotto.ofManualStringLottoNumbers("1,2,3,4,5,6");
        WinningLotto winningNumber_2 = WinningLotto.ofString("11,12,13,14,15,19");
        LottoNumber bonus_2 = LottoNumber.ofInt(6);
        Prize prize_2 = Prize.ELSE;
        listOfArguments.add(Arguments.of(lotto_2, winningNumber_2, bonus_2, prize_2));
        return listOfArguments.stream();
    }

    @Nested
    @DisplayName("findPrize 메소드는")
    class FindPrizeTest {
        @ParameterizedTest
        @MethodSource("generateArgumentsStream")
        @DisplayName("로또 맞춘 개수에 따른 상금을 반환")
        void prizeTest(Lotto lotto, WinningLotto winningLotto, LottoNumber bonus, Prize prize) {
            assertThat(Prize.findPrize(lotto.countMatching(winningLotto), winningLotto, lotto.checkContainNumber(bonus))).isEqualTo(prize);
        }
    }
}

