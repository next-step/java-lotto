package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {

    @Test
    @DisplayName("Lotto 객체가 보유한 NumberGroup와 당첨 번호의 일치 개수에 따라 MatchCriteria의 값이 정상적으로 증가하였는지 확인합니다.")
    void match() {
        //given
        NumberGroup winningNumbers = numberGroups(3, 5, 11, 16, 32, 38);
        Lotto lotto = mockLotto();
        //when
        lotto.match(winningNumbers);
        //then
        assertThat(MatchCriteria.THREE.equalsCount(1)).isTrue();
        assertThat(MatchCriteria.FOUR.equalsCount(1)).isTrue();
        assertThat(MatchCriteria.FIVE.equalsCount(2)).isTrue();
        assertThat(MatchCriteria.SIX.equalsCount(1)).isTrue();
    }

    NumberGroup numberGroups(int number1, int number2, int number3, int number4, int number5, int number6) {
        return new NumberGroup(Arrays.asList(new Number(number1, new Position(0)),
                new Number(number2, new Position(1)), new Number(number3, new Position(2)),
        new Number(number4, new Position(3)), new Number(number5, new Position(4)), new Number(number6, new Position(5))));
    }

    Lotto lotto(NumberGroup numberGroup1, NumberGroup numberGroup2, NumberGroup numberGroup3
                ,NumberGroup numberGroup4, NumberGroup numberGroup5, NumberGroup numberGroup6) {
        return new Lotto(Arrays.asList(numberGroup1, numberGroup2, numberGroup3, numberGroup4, numberGroup5, numberGroup6));
    }

    Lotto mockLotto() {
        return lotto(
                numberGroups(3, 5, 11, 16, 32, 38), // 6
                numberGroups(3, 5, 11, 16, 32, 7), // 5
                numberGroups(7, 5, 11, 16, 32, 3), // 4
                numberGroups(7, 5, 11, 8, 32, 3), // 3
                numberGroups(2, 5, 11, 16, 32, 38), //5
                numberGroups(1, 2, 3, 4, 5, 6) // 0
        );
    }
}