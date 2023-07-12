package lottogame.service;

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

            private static final int PURCHASE_COUNT = 3;
            private static final int BONUS_NUMBER = 7;

            private final Set<Integer> selectedLottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
            private final LottoCheckService lottoCheckService = new LottoCheckService();
            private final List<LottoTicket> lottoTicketRequest = getLottoTicketRequest();
            private final LottoCheckResponse expectedLottoCheckResponse = getExpectedLottoCheckResponse();

            @Test
            @DisplayName("수익률와, 상별 갯수를 반환한다")
            void It_Return_Earning_Rate_And_Number_Of_Prize() {
                Assertions.assertThat(
                        lottoCheckService.checkResult(lottoTicketRequest, selectedLottoNumbers, BONUS_NUMBER))
                    .isEqualTo(expectedLottoCheckResponse);
            }

            private List<LottoTicket> getLottoTicketRequest() {
                LottoTicket firstPrizeLottoTicket = new LottoTicket((count) -> selectedLottoNumbers);
                LottoTicket secondPrizeLottoTicket = new LottoTicket(
                    (count) -> Set.of(1, 2, 3, 4, 5, BONUS_NUMBER));
                LottoTicket nonePrizeLottoTicket = new LottoTicket(
                    (count) -> Set.of(8, 9, 10, 11, 12, 13));

                return List.of(firstPrizeLottoTicket, secondPrizeLottoTicket, nonePrizeLottoTicket);
            }

            private LottoCheckResponse getExpectedLottoCheckResponse() {
                int totalMoney = PURCHASE_COUNT * LottoTicket.PURCHASABLE_UNIT;
                int earnMoney = LottoPrize.FIRST.getMoney() + LottoPrize.SECOND.getMoney();

                return new LottoCheckResponse((double) earnMoney / (double) totalMoney,
                    Map.of(LottoPrize.FIRST, 1, LottoPrize.SECOND, 1));
            }
        }
    }
}
