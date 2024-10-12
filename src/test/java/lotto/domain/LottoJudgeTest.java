package lotto.domain;

import lotto.dto.LottoMatchInfoDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.WinningNumbersDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoJudgeTest {
    @Test
    @DisplayName("당첨 번호를 입력하면 당첨 로또로 등록됨")
    void decideWinningLottoTest() {
        WinningNumbersDTO winningNumbers = WinningNumbersDTO.valueOf(List.of(1, 3, 5, 7, 9, 11));
        LottoJudge judge = LottoJudge.valueOf(winningNumbers);
        assertThat(judge.getWinningLottoNumbers().value()).isEqualTo(winningNumbers.getWinningNumbers());
    }

    @Test
    @DisplayName("statistics에서 당첨된 로또 번호 갯수가 포함됨")
    void getStatisticsOfTest() {
        LottoAgent agent = LottoAgent.newInstance();
        List<Integer> winningNumbers = List.of(1, 3, 5, 7, 9, 11);
        int buyingPrice = 10000;
        agent.buy(buyingPrice, () -> LottoNumbers.valueOf(winningNumbers));
        WinningNumbersDTO winningNumbersDTO = WinningNumbersDTO.valueOf(winningNumbers);
        LottoJudge judge = LottoJudge.valueOf(winningNumbersDTO);
        LottoStatisticsDTO statistics = judge.getStatisticsOf(agent);
        List<LottoMatchInfoDTO> infos = statistics.getMatchInfosDTO().getMatchInfoDTOs();
        assertThat(infos).isNotEmpty().anyMatch(info -> info.getMatchCount() == 6 && info.getLottoNum() > 0);
    }
}
