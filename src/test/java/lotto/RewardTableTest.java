package lotto;

import lotto.utility.RewardTable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RewardTableTest {
  @ParameterizedTest
  @CsvSource(value = {"3,fourthRank", "4,thirdRank", "5,secondRank", "6, firstRank"})
  @DisplayName("matchNumber에 따른 원하는 rank 가져오기")
  public void RewardTableTest(int matchNumber, RewardTable expect) {
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
}
