package lottogame.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lottogame.domain.LottoPrize;
import lottogame.domain.LottoTicket;
import lottogame.service.response.LottoCheckResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoCheckService 클래스")
public class LottoCheckServiceTest {

    @Nested
    @DisplayName("checkResult 메서드는")
    class Describe_Check_Result {

        @Nested
        @DisplayName("Lotto tickets가 들어오면")
        class Context_Input_Lotto_Tickets {

            private final Set<Integer> selectedLottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
            private final Integer bonusNumber = 7;
            private final List<LottoTicket> lottoTicketRequest = getLottoTicketRequest();
            private final LottoCheckService lottoCheckService = new LottoCheckService();
            private final LottoCheckResponse expectedLottoCheckResponse = getExpectedLottoCheckResponse(
                List.of(LottoPrize.FIRST, LottoPrize.SECOND, LottoPrize.NONE));

            @Test
            @DisplayName("수익률와, 상별 갯수를 반환한다")
            void It_Return_Earning_Rate_And_Number_Of_Prize() {
                Assertions.assertThat(
                        lottoCheckService.checkResult(lottoTicketRequest, selectedLottoNumbers, bonusNumber))
                    .isEqualTo(expectedLottoCheckResponse);
            }

            private List<LottoTicket> getLottoTicketRequest() {
                LottoTicket firstPrizeLottoTicket = new LottoTicket((count) -> selectedLottoNumbers);
                LottoTicket secondPrizeLottoTicket = new LottoTicket(
                    (count) -> Set.of(1, 2, 3, 4, 5, bonusNumber));
                LottoTicket nonePrizeLottoTicket = new LottoTicket(
                    (count) -> Set.of(8, 9, 10, 11, 12, 13));

                return List.of(firstPrizeLottoTicket, secondPrizeLottoTicket, nonePrizeLottoTicket);
            }

            private LottoCheckResponse getExpectedLottoCheckResponse(List<LottoPrize> lottoPrizes) {
                int totalMoney = lottoPrizes.size() * LottoTicket.PURCHASABLE_UNIT;
                int earnMoney = 0;
                Map<LottoPrize, Integer> lottoPrizeMap = new HashMap<>();
                for (LottoPrize lottoPrize : lottoPrizes) {
                    earnMoney += lottoPrize.getMoney();
                    lottoPrizeMap.put(lottoPrize, lottoPrizeMap.getOrDefault(lottoPrize, 0) + 1);
                }
                return new LottoCheckResponse((double) earnMoney / (double) totalMoney, lottoPrizeMap);
            }
        }
    }
}
