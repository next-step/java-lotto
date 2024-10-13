package lotto.domain;

import lotto.dto.LottoRewardInfoDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.WinningNumbersDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoJudgeTest {
    @Test
    @DisplayName("당첨 번호와 보너스 번호를 입력하면 각각 등록됨")
    void enrollWinningNumbersAndBonusNumberTest() {
        WinningNumbersDTO winningNumbers = WinningNumbersDTO.valueOf(List.of(1, 3, 5, 7, 9, 11));
        int bonusNumber = 4;
        LottoJudge judge = LottoJudge.valueOf(winningNumbers, bonusNumber);
        assertThat(judge.getWinningLottoNumbers().value()).isEqualTo(winningNumbers.getWinningNumbers());
        assertThat(judge.getBonusNumber()).isEqualTo(bonusNumber);
    }

    @Test
    @DisplayName("당첨 번호에 포함된 보너스 번호를 입력하면 IllegalArgumentException 발생")
    void enrollDuplicatedBonusNumberTest() {
        WinningNumbersDTO winningNumbers = WinningNumbersDTO.valueOf(List.of(1, 3, 5, 7, 9, 11));
        int bonusNumber = 3;
        assertThatIllegalArgumentException().isThrownBy(() -> LottoJudge.valueOf(winningNumbers, bonusNumber));
    }

    @Test
    @DisplayName("statistics에서 당첨된 로또 번호 갯수가 포함됨")
    void getStatisticsOfTest() {
        LottoAgent agent = LottoAgent.newInstance();
        List<Integer> winningNumbers = List.of(1, 3, 5, 7, 9, 11);
        int bonusNumber = 4;
        int buyingPrice = 10000;
        agent.buy(buyingPrice, () -> LottoNumbers.valueOf(winningNumbers));
        WinningNumbersDTO winningNumbersDTO = WinningNumbersDTO.valueOf(winningNumbers);
        LottoJudge judge = LottoJudge.valueOf(winningNumbersDTO, bonusNumber);
        LottoStatisticsDTO statistics = judge.getStatisticsOf(agent);
        List<LottoRewardInfoDTO> infos = statistics.getMatchInfosDTO().getRewardInfoDTOs();
        assertThat(infos).isNotEmpty().anyMatch(info -> info.getReward().getMatchCount() == 6 && info.getCount() > 0);
    }
}
