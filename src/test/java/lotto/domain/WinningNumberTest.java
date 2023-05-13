package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class WinningNumberTest {
    @Test
    void 보너스번호중복검증() {
        assertThatThrownBy(()-> {
            WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 5, 6, 30, 35, 45), 6);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("보너스 번호가 당첨 번호에 중복 입니다.");
    }

    @ParameterizedTest
    @DisplayName("당첨개수확인")
    @MethodSource("provideLottoNumbers")
    void 당첨개수확인(int[] inputNumbers, int matchCount, boolean isBonusMatched) {
        ArrayList<Integer> numbers = new ArrayList<>();

        Arrays.stream(inputNumbers).forEach(i -> numbers.add(i));

        LottoTicket lottoTicket = LottoTicket.createLottoTicketByManual(numbers);


        WinningNumber winningNumber = new WinningNumber(Arrays.asList(1, 5, 10, 20, 30, 45), 3);

        Assertions.assertThat(winningNumber.getMatchCount(lottoTicket)).isEqualTo(matchCount);
        Assertions.assertThat(winningNumber.isBonusMatched(lottoTicket)).isEqualTo(isBonusMatched);
    }

    static Stream<Object[]> provideLottoNumbers() {
        return Stream.of(new Object[][]{
                {new int[]{1, 5, 10, 20, 30, 45}, 6, false},
                {new int[]{2, 5, 10, 20, 30, 45}, 5, false},
                {new int[]{3, 5, 10, 20, 30, 45}, 5, true},
                {new int[]{1, 5, 10, 20, 33, 44}, 4, false},
                {new int[]{2, 5, 10, 20, 33, 44}, 3, false},
                {new int[]{1, 6, 7, 8, 9, 45}, 2, false},
                {new int[]{6, 7, 8, 9, 10, 11}, 1, false},
                {new int[]{6, 7, 8, 9, 11, 12}, 0, false}
        });
    }



}
