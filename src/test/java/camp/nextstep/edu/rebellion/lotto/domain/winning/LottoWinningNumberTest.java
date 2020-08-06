package camp.nextstep.edu.rebellion.lotto.domain.winning;

import camp.nextstep.edu.rebellion.lotto.domain.ticket.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningNumberTest {

    @DisplayName("입력된 번호가 당첨번호 중에 있을 경우 결과를 잘 반환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:true",
            "2:true",
            "3:true",
            "4:true",
            "7:false"
    }, delimiter = ':')
    public void containTest(int number, boolean expected) {
        // given
        LottoWinningNumber winningNumber =
                new LottoWinningNumber("1,2,3,4,5,6", 7);

        // when
        assertThat(winningNumber.contain(new LottoNumber(number)))
                .isEqualTo(expected);

    }

    @DisplayName("입력된 번호가 보너스 번호일 경우 결과를 잘 반환하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "1:false",
            "7:true"
    }, delimiter = ':')
    public void containBonusTest(int number, boolean expected) {
        // given
        LottoWinningNumber winningNumber =
                new LottoWinningNumber("1,2,3,4,5,6", 7);

        // when
        assertThat(winningNumber.containBonus(new LottoNumber(number)))
                .isEqualTo(expected);
    }
}
