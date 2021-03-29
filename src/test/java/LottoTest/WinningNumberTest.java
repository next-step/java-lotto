package LottoTest;

import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.domain.Rank;
import lotto.domain.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;

public class WinningNumberTest {
    @Test
    @DisplayName("List<Interger>를 받는 생성자")
    void Given_List_When_New_Then_InstanceCreated() {
        int bonusNumber = 9;
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(new WinningNumber(numbers, bonusNumber)).isEqualTo(new WinningNumber(numbers, bonusNumber));
    }


    @ParameterizedTest
    @CsvSource(value = {"6", "0", "46"}, delimiter = ':')
    @DisplayName("잘못된 보너스 번호면 Exception")
    void Given_InvalidBonusNumber_When_New_Then_Exception() {
        int duplicatedBonusNumber = 6;
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy((() -> new WinningNumber(Arrays.asList(1, 2, 3, 4, 5, 6), duplicatedBonusNumber)));
    }

    @Test
    @DisplayName("Rank 계산 테스트")
    void Given_LottoGame_When_Rank_Then_ValidRank() {
        //given
        List<Integer> givenNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoGame game = new LottoGame(givenNumber);
        WinningNumber winningNumber = new WinningNumber(givenNumber, LottoNumber.create(7));

        //when, then
        assertThat(winningNumber.rank(game)).isEqualTo(Rank.FIRST);

    }
}
