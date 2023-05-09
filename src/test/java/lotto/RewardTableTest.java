package lotto;

import lotto.domain.Lotto;
import lotto.utility.InputConverter;
import lotto.utility.RewardTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTableTest {
  @ParameterizedTest
  @CsvSource(value = {"3,fourthRank", "4,thirdRank", "5,secondRank", "6, firstRank"})
  @DisplayName("matchNumber에 따른 원하는 rank 가져오기")
  public void RewardTableRewardTableInfoTest(int matchNumber, RewardTable expect) {
    RewardTable result = RewardTable.rewardTableInfo(matchNumber);

    assertThat(result).isEqualTo(expect);
  }

  @Test
  @DisplayName("번호 3개 맞춘 복권 상금과 번호 5개 맞춘 복권 상금 계산")
  public void compareWithLastNumber() {

    int result1 = RewardTable.rewardTableInfo(3).calculateReward(1);
    int result2 = RewardTable.rewardTableInfo(5).calculateReward(1);

    assertThat(result1).isEqualTo(5000);
    assertThat(result2).isEqualTo(1500000);
  }

  @ParameterizedTest
  @CsvSource(value = {"6, 15", "23, 5"})
  @DisplayName("번호 5개 맞춘 복권 + 보너스 번호 맞춘 경우 15 반환 아닌 경우에 따른 matchNumber 반환")
  public void bonusRankSeparatorTest(int bonusNumber, int expect) {
    Lotto lotto = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)));
    String strList = "1, 2, 3, 4, 5, 45";
    List<Integer> targetNumber = InputConverter.convertNumberToList(strList);
    int result = RewardTable.bonusRankSeparator(lotto.isMatchBonusNumber(bonusNumber), lotto.matchLottoNumber(targetNumber));

    assertThat(result).isEqualTo(expect);

  }

}
