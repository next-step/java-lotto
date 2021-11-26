package lotto;

import lotto.domain.*;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public class PrizeTest {
    private static Stream<Arguments> generateArgumentsStream() {
        List<Arguments> listOfArguments = new LinkedList<>();
        Lotto lotto = new Lotto("1,2,3,7,8,9");
        WinningLotto winningNumber = new WinningLotto("1,2,3,4,5,6");
        LottoNumber bonus = new LottoNumber(10);
        Prize prize = Prize.FIFTH;
        listOfArguments.add(Arguments.of(lotto, winningNumber, bonus,prize));

        Lotto lotto_1 = new Lotto("1,2,3,4,5,6");
        WinningLotto winningNumber_1 = new WinningLotto("1,2,3,4,5,9");
        LottoNumber bonus_1 = new LottoNumber(6);
        Prize prize_1 = Prize.SECOND;
        listOfArguments.add(Arguments.of(lotto_1, winningNumber_1, bonus_1,prize_1));

        Lotto lotto_2 = new Lotto("1,2,3,4,5,6");
        WinningLotto winningNumber_2 = new WinningLotto("11,12,13,14,15,19");
        LottoNumber bonus_2 = new LottoNumber(6);
        Prize prize_2 = Prize.ELSE;
        listOfArguments.add(Arguments.of(lotto_2, winningNumber_2, bonus_2,prize_2));
        return listOfArguments.stream();
    }
    @ParameterizedTest
    @MethodSource("generateArgumentsStream")
    @DisplayName("로또 맞춘 개수에 다른 상금 테스트")
    void prizeTest(Lotto lotto, WinningLotto winningLotto, LottoNumber bonus,Prize prize) {
        assertThat(Prize.findPrize(lotto.checkMatching(winningLotto), winningLotto, lotto.checkContainNumber(bonus))).isEqualTo(prize);
    }
}

