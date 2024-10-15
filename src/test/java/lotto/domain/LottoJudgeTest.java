package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoJudgeTest {
    @Test
    @DisplayName("당첨 번호와 보너스 번호를 입력하면 각각 등록됨")
    void enrollWinningNumbersAndBonusNumberTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(List.of(1, 3, 5, 7, 9, 11));
        LottoNumber bonusNumber = LottoNumber.valueOf(4);
        LottoJudge judge = LottoJudge.of(winningNumbers, bonusNumber);
        assertThat(judge.getWinningLottoNumbers().value()).isEqualTo(winningNumbers.value());
        assertThat(judge.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호에 포함된 보너스 번호를 입력하면 IllegalArgumentException 발생")
    void enrollDuplicatedBonusNumberTest() {
        LottoNumbers winningNumbers = LottoNumbers.valueOf(List.of(1, 3, 5, 7, 9, 11));
        LottoNumber bonusNumber = LottoNumber.valueOf(3);
        assertThatIllegalArgumentException().isThrownBy(() -> LottoJudge.of(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("countRewards에서 당첨된 로또 번호 갯수가 포함됨")
    void countRewardsTest() {
        LottoAgent agent = LottoAgent.newInstance();
        LottoNumbers winningNumbers = LottoNumbers.valueOf(List.of(1, 3, 5, 7, 9, 11));
        LottoNumber bonusNumber = LottoNumber.valueOf(4);
        int buyingPrice = 10000;
        agent.buy(buyingPrice, () -> winningNumbers);
        LottoJudge judge = LottoJudge.of(winningNumbers, bonusNumber);
        LottoRewardCountMap rewardCountMap = judge.countRewards(agent.getPurchasedLottos());
        assertThat(rewardCountMap.getRewardCount(LottoReward.FIRST_PLACE)).isGreaterThan(0);
    }

    @Test
    @DisplayName("calculateRewardPercentage로 상금에 해당하는 정보가 반영됨")
    void calculateRewardPercentagTest() {
        LottoAgent agent = LottoAgent.newInstance();
        LottoNumbers winningNumbers = LottoNumbers.valueOf(List.of(1, 3, 5, 7, 9, 11));
        LottoNumber bonusNumber = LottoNumber.valueOf(4);
        int buyingPrice = 1000;
        LottoNumbers buyingNumbers = LottoNumbers.valueOf(List.of(1, 3, 4, 5, 7, 9));
        agent.buy(buyingPrice, () -> buyingNumbers);
        LottoJudge judge = LottoJudge.of(winningNumbers, bonusNumber);
        Double rewardPercentage = judge.calculateRewardPercentage(agent.getPurchasedLottos());
        assertThat(rewardPercentage).isGreaterThan(0);
    }
}
