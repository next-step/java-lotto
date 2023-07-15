package lottogame.service;

import lottogame.domain.LottoRank;
import lottogame.domain.LottoTicket;
import lottogame.domain.mock.MockLottoTicket;
import lottogame.service.response.LottoCheckResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoCheckService 클래스")
class LottoCheckServiceTest {

    @Nested
    @DisplayName("checkResult 메서드는")
    class Describe_Check_Result {

        @Nested
        @DisplayName("Lotto tickets가 들어오면")
        class Context_Input_Lotto_Tickets {

            private static final int PURCHASE_COUNT = 3;
            private static final int BONUS_NUMBER = 7;

            private final Set<Integer> selectedLottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
            private final LottoService lottoCheckService = new LottoService();
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
                LottoTicket firstPrizeLottoTicket = new MockLottoTicket((count) -> selectedLottoNumbers);
                LottoTicket secondPrizeLottoTicket = new MockLottoTicket(
                    (count) -> Set.of(1, 2, 3, 4, 5, BONUS_NUMBER));
                LottoTicket nonePrizeLottoTicket = new MockLottoTicket(
                    (count) -> Set.of(8, 9, 10, 11, 12, 13));

                return List.of(firstPrizeLottoTicket, secondPrizeLottoTicket, nonePrizeLottoTicket);
            }

            private LottoCheckResponse getExpectedLottoCheckResponse() {
                double totalMoney = PURCHASE_COUNT * LottoTicket.PURCHASABLE_UNIT;
                double earnMoney = LottoRank.FIRST.getMoney() + LottoRank.SECOND.getMoney();

                return new LottoCheckResponse( earnMoney / totalMoney,
                    Map.of(LottoRank.FIRST, 1L, LottoRank.SECOND, 1L, LottoRank.NONE, 1L));
            }
        }
    }
}
