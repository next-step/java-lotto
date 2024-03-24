package lotto.domain;


import static org.assertj.core.api.Assertions.*;

import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.winning.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    @Test
    @DisplayName("우승번호는 당첨번호를 가지고 있다")
    public void Winning_Numbers_Has_Winning_Number(){
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(10,20,30,31,32,33));

        assertThat(winningNumbers.size()).isEqualTo(6);
    }
    @Test
    @DisplayName("전달 받은 로또번호가 3개가 일치할 경우 4등을 반환한다.")
    public void Winning_Numbers_Should_Return_3th_If_4_Received_Numbers_Match(){
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(10,20,30,31,32,33));
        Lotto lotto = Lotto.fromValues(List.of(10, 20, 30, 1, 2, 3));

        Grade grade = winningNumbers.confirmWinning(lotto);

        assertThat(grade).isEqualTo(Grade.FOUR_GRADE);
    }

    @Test
    @DisplayName("전달 받은 로또번호가 4개가 일치할 경우 3등을 반환한다.")
    public void Winning_Numbers_Should_Return_4th_If_3_Received_Numbers_Match(){
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(10,20,30,31,32,33));
        Lotto lotto = Lotto.fromValues(List.of(10, 20, 30, 31, 2, 3));

        Grade grade = winningNumbers.confirmWinning(lotto);

        assertThat(grade).isEqualTo(Grade.THIRD_GRADE);
    }

    @Test
    @DisplayName("전달 받은 로또번호가 5개가 일치할 경우 2등을 반환한다.")
    public void Winning_Numbers_Should_Return_5th_If_2_Received_Numbers_Match(){
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(10,20,30,31,32,33));
        Lotto lotto = Lotto.fromValues(List.of(10, 20, 30, 31, 32, 3));

        Grade grade = winningNumbers.confirmWinning(lotto);

        assertThat(grade).isEqualTo(Grade.SECOND_GRADE);
    }

    @Test
    @DisplayName("전달 받은 로또번호가 6개가 일치할 경우 1등을 반환한다.")
    public void Winning_Numbers_Should_Return_6th_If_1_Received_Numbers_Match(){
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(10,20,30,31,32,33));
        Lotto lotto = Lotto.fromValues(List.of(10, 20, 30, 31, 32, 33));

        Grade grade = winningNumbers.confirmWinning(lotto);

        assertThat(grade).isEqualTo(Grade.FIRST_GRADE);
    }
}
