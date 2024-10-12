package lotto.domain;


import lotto.dto.LottoMatchInfoDTO;
import lotto.dto.LottoStatisticsDTO;
import lotto.dto.PurchasedLottosDTO;
import lotto.dto.WinningNumbersDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAgentTest {
    @ParameterizedTest
    @ValueSource(ints = {10000, 15000, 20000})
    @DisplayName("금액에 비례하여 Lotto가 구입됩니다.")
    void buyCardinalityTest(int price) {
        LottoAgent agent = LottoAgent.newInstance();
        agent.buy(price, () -> LottoNumbers.valueOf(List.of(1, 3, 5, 7, 9, 11)));
        PurchasedLottosDTO lottos = agent.listPurchasedLottos();
        assertThat(lottos.getPurchasedLottos().size()).isEqualTo(price / 1000);
    }

    @Test
    @DisplayName("당첨 번호를 입력하면 로또가 등록됨")
    void decideWinningLottoTest() {
        LottoAgent agent = LottoAgent.newInstance();
        WinningNumbersDTO winningNumbers = WinningNumbersDTO.valueOf(List.of(1, 3, 5, 7, 9, 11));
        agent.decideWinningNumbers(winningNumbers);
        assertThat(agent.getWinningLottoNumbers().value()).isEqualTo(winningNumbers.getWinningNumbers());
    }

    @Test
    @DisplayName("statistics에서 당첨된 로또 번호 갯수가 포함됨")
    void getStatisticsTest() {
        LottoAgent agent = LottoAgent.newInstance();
        List<Integer> winningNumbers = List.of(1, 3, 5, 7, 9, 11);
        int buyingPrice = 10000;
        agent.buy(buyingPrice, () -> LottoNumbers.valueOf(winningNumbers));
        WinningNumbersDTO winningNumbersDTO = WinningNumbersDTO.valueOf(winningNumbers);
        agent.decideWinningNumbers(winningNumbersDTO);
        LottoStatisticsDTO statistics = agent.getStatistics();
        List<LottoMatchInfoDTO> infos = statistics.getMatchInfosDTO().getMatchInfoDTOs();
        assertThat(infos).isNotEmpty().anyMatch(info -> info.getMatchCount() == 6 && info.getLottoNum() > 0);
    }
}
