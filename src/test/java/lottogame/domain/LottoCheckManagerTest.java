package lottogame.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lottogame.domain.dto.LottoTicketDto;
import lottogame.domain.response.LottoCheckedResponse;
import lottogame.domain.response.LottoTicketCheckedResponse;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@SuppressWarnings("FieldCanBeLocal")
@DisplayName("LottoCheckService 클래스")
class LottoCheckManagerTest {

    @Nested
    @DisplayName("checkResult 메서드는")
    class Describe_Check_Result {

        @Nested
        @DisplayName("Lotto tickets가 들어오면")
        class Context_Input_Lotto_Tickets {

            private static final int PURCHASE_COUNT = 3;
            private static final int BONUS_NUMBER = 7;

            private final Set<Integer> selectedLottoNumbers = Set.of(1, 2, 3, 4, 5, 6);
            private final LottoCheckManager lottoCheckManager = new LottoCheckManager(selectedLottoNumbers,
                BONUS_NUMBER);
            private final List<LottoTicketDto> lottoTicketDtoRequests = getLottoTicketDtoRequests();
            private final LottoCheckedResponse expectedLottoCheckedResponse = getExpectedLottoCheckResponse();

            @Test
            @DisplayName("수익률와, 상별 갯수를 반환한다")
            void It_Return_Earning_Rate_And_Number_Of_Prize() {
                Assertions.assertThat(lottoCheckManager.checkResult(lottoTicketDtoRequests))
                    .isEqualTo(expectedLottoCheckedResponse);
            }

            private List<LottoTicketDto> getLottoTicketDtoRequests() {
                LottoTicketDto firstPrizeLottoTicket = new LottoTicketDto(selectedLottoNumbers);
                LottoTicketDto secondPrizeLottoTicket = new LottoTicketDto(Set.of(1, 2, 3, 4, 5, BONUS_NUMBER));
                LottoTicketDto nonePrizeLottoTicket = new LottoTicketDto(Set.of(8, 9, 10, 11, 12, 13));

                return List.of(firstPrizeLottoTicket, secondPrizeLottoTicket, nonePrizeLottoTicket);
            }

            private LottoCheckedResponse getExpectedLottoCheckResponse() {
                int totalMoney = PURCHASE_COUNT * LottoTicket.PURCHASABLE_UNIT;
                int earnMoney = LottoPrize.FIRST.getMoney() + LottoPrize.SECOND.getMoney();

                return new LottoCheckedResponse(BigDecimal.valueOf(earnMoney / (double) totalMoney)
                    .setScale(2, RoundingMode.HALF_EVEN).toString(),
                    Map.of(new LottoTicketCheckedResponse(6, LottoPrize.FIRST.getMoney()), 1,
                        new LottoTicketCheckedResponse(5, LottoPrize.SECOND.getMoney()), 1));
            }

        }

    }

}
