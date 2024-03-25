package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import lotto.domain.grade.Grade;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoMachine;
import lotto.domain.lotto.PurchaseAmount;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistic;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {

    @Test
    @DisplayName("구매 금액을 전달받아 실행 횟수를 계산해야한다")
    public void LottoMachine_Should_Calculate_Execute_Count() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(10000));

        //when
        int executeCount = lottoMachine.calculateExecuteCount();

        //then
        assertThat(executeCount).isEqualTo(10);
    }

    @Test
    @DisplayName("[1등 당첨] WinningNumbers를 사용하여 Lotto번호가 WinningNumbers와 전부 같을 경우 당첨 등수를 확인한다.")
    public void LottoMachine_Should_Compare_Lotto_With_WinningNumbers_To_Check_Equals_All() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(1000));
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.fromValues(List.of(1, 2, 3, 4, 5, 6));

        //when
        Grade grade = lottoMachine.calculatePrizeMoney(winningNumbers, lotto);

        //then
        assertThat(grade).isEqualTo(Grade.FIRST_GRADE);
    }

    @Test
    @DisplayName("[2등 당첨] WinningNumbers를 사용하여 Lotto 번호가 WinningNumbers와 5개와 같을 경우 당첨 등수를 확인한다")
    public void LottoMachine_Should_Compare_Lotto_With_WinningNumbers_To_Check_Equals_Five() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(1000));
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.fromValues(List.of(1, 2, 3, 4, 5, 10));

        //when
        Grade grade = lottoMachine.calculatePrizeMoney(winningNumbers, lotto);

        //then
        assertThat(grade).isEqualTo(Grade.SECOND_GRADE);
    }

    @Test
    @DisplayName("[3등 당첨] WinningNumbers를 사용하여 Lotto 번호가 WinningNumbers와 4개가 같을 경우 당첨 등수를 확인한다.")
    public void LottoMachine_Should_Compare_Lotto_With_WinningNumbers_To_Check_Equals_Four() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(1000));
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.fromValues(List.of(1, 2, 3, 4, 11, 10));

        //when
        Grade grade = lottoMachine.calculatePrizeMoney(winningNumbers, lotto);

        //then
        assertThat(grade).isEqualTo(Grade.THIRD_GRADE);
    }

    @Test
    @DisplayName("[4등 당첨] WinningNumbers를 사용하여 Lotto 번호가 WinningNumbers 3개가 같을 경우 등수를 확인한다")
    public void LottoMachine_Should_Compare_Lotto_With_WinningNumbers_To_Check_Equals_Three() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(1000));
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.fromValues(List.of(1, 2, 3, 12, 11, 10));

        //when
        Grade grade = lottoMachine.calculatePrizeMoney(winningNumbers, lotto);

        //then
        assertThat(grade).isEqualTo(Grade.FOUR_GRADE);
    }

    @Test
    @DisplayName("[꼴지 당첨] WinningNumbers를 사용하여 Lotto 번호가 WinningNumbers와 같은 경우가 없을 경우 꼴지 Grade를 반환한다")
    public void LottoMachine_Should_Compare_Lotto_With_WinningNumbers_To_Check_Equals_two() {
        //given
        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(1000));
        WinningNumbers winningNumbers = WinningNumbers.fromValues(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = Lotto.fromValues(List.of(11, 12, 13, 14, 15, 16));

        //when
        Grade grade = lottoMachine.calculatePrizeMoney(winningNumbers, lotto);

        //then
        assertThat(grade).isEqualTo(Grade.UN_LUCKY_GRADE);
    }

    @Test
    @DisplayName("LottoMachine은 autoLottos와 WinningNuber를 사용하여 당첨통계(WinningStatistice)를 반환한다")
    public void LottoMachine_Should_Return_Winning_Statistics_Using_Auto_Lottos_and_Winning_Number()
        throws ExecutionException, InterruptedException {
        //given
        Lotto firstGradeLotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 5, 6));     //  1등 로또
        Lotto secondGradeLotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 5, 10));   //  2등 로또
        Lotto thirdGradeLotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 4, 20, 10));   //  3등 로또
        Lotto fourGradeLotto = Lotto.fromValues(Arrays.asList(1, 2, 3, 30, 20, 10));   //  4등 로또
        List<Lotto> autoLottos = new ArrayList<>(
            Arrays.asList(firstGradeLotto, secondGradeLotto, thirdGradeLotto, fourGradeLotto));

        WinningNumbers winningNumbers = WinningNumbers.fromValues(Arrays.asList(1, 2, 3, 4, 5, 6));

        LottoMachine lottoMachine = new LottoMachine(new PurchaseAmount(20000));

        //when
        WinningStatistic winningStatistic = lottoMachine.startLotto(autoLottos, winningNumbers);

        //then
        assertThat(winningStatistic.getGradeCount(Grade.FIRST_GRADE)).isEqualTo(1);
        assertThat(winningStatistic.getGradeCount(Grade.SECOND_GRADE)).isEqualTo(1);
        assertThat(winningStatistic.getGradeCount(Grade.THIRD_GRADE)).isEqualTo(1);
        assertThat(winningStatistic.getGradeCount(Grade.FOUR_GRADE)).isEqualTo(1);
    }
}
