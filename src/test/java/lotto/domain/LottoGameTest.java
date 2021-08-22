package lotto.domain;

import lotto.generic.Money;
import lotto.util.LottoNumbersFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static lotto.domain.LottoGame.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoGameTest {

    @DisplayName("로또 티켓 구매")
    @ParameterizedTest(name = "{index}. {displayName}, arguments: {arguments}")
    @MethodSource("parameterProvider")
    void buy(int purchaseAmount, String[] manualLottoNumbers) {
        Money amount = Money.wons(purchaseAmount);
        int ticketCount = amount.divideAndDiscardRemainder(LOTTO_PRICE);
        LottoTickets lottoTickets = LottoGame.buy(amount, manualLottoNumbers);
        List<LottoNumbers> manualLottoTickets = Arrays.stream(manualLottoNumbers)
                .map(LottoNumbersFactory::makeLottoNumbers)
                .collect(toList());

        assertAll(
                () -> assertThat(lottoTickets.getLottoTickets()).hasSize(ticketCount),
                () -> assertThat(lottoTickets.getAutoTicketCount()).isEqualTo(ticketCount - manualLottoNumbers.length),
                () -> assertThat(lottoTickets.getManualTicketCount()).isEqualTo(manualLottoNumbers.length),
                () -> assertThat(lottoTickets.getLottoTickets()).containsAll(manualLottoTickets)
        );
    }

    //구매금액, 수동 로또 배열
    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of(14500, new String[]{"6, 13, 20, 28, 35, 41", "3, 14, 22, 33, 39, 40", "1, 9, 21, 30, 35, 44"}),
                Arguments.of(14500, new String[0]),
                Arguments.of(3000, new String[]{"6, 13, 20, 28, 35, 41", "3, 14, 22, 33, 39, 40", "1, 9, 21, 30, 35, 44"})
        );
    }
}
