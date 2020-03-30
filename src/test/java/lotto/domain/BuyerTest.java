package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class BuyerTest {
    private Buyer buyer;
    private LottoTicket winningTicket;

    @BeforeEach
    void setUp() {
        buyer = new Buyer();
        winningTicket = createTicket(1, 2, 3, 4, 5, 6);
    }

    @ParameterizedTest
    @DisplayName("가격에 맞는 개수만큼 로또 티켓 구매 확인")
    @CsvSource(value = {"3500:3", "9800:9", "15920:15"}, delimiter = ':')
    void checkTicketCountByPayMoney(int money, int expectedLottoTicketCount) {
        List<LottoTicket> lottoTickets = buyer.buyLottoTickets(money);
        assertThat(lottoTickets).hasSize(expectedLottoTicketCount);
    }

    @Test
    @DisplayName("3등 1장, 4등 1장일때 result 확인")
    void checkByGetResult() {
        LottoTicket thirdTicket = createTicket(1, 2, 3, 4, 5, 16);
        LottoTicket fourthTicket = createTicket(1, 2, 3, 14, 15, 16);

        Buyer newBuyer = new Buyer(Arrays.asList(thirdTicket, fourthTicket));
        BuyerResult result = newBuyer.getResult(winningTicket, LottoNumber.of(17));

        assertThat(result.getWinningResult().size()).isEqualTo(2);
        assertThat(result.getProfitRate()).isEqualTo(752.5);
    }

    @Test
    @DisplayName("2등 1장, 3등 1장일때 result 확인")
    void checkByGetResult2() {
        LottoTicket secondTicket = createTicket(1, 2, 3, 4, 5, 16);
        LottoTicket fourthTicket = createTicket(1, 2, 3, 4, 5, 16);

        Buyer newBuyer = new Buyer(Arrays.asList(secondTicket, fourthTicket));
        BuyerResult result = newBuyer.getResult(winningTicket, LottoNumber.of(16));

        assertThat(result.getWinningResult().size()).isEqualTo(2);
        assertThat(result.getProfitRate()).isEqualTo(30000.0);
    }

    @ParameterizedTest
    @DisplayName("보너스번호 당첨번호와 중복 시 예외 발생")
    @ValueSource(ints = {1, 3, 5})
    void nonDuplicatedByInputBonus(int bonusNumber) {
        LottoTicket secondTicket = createTicket(1, 2, 3, 4, 5, 16);

        Buyer newBuyer = new Buyer(Arrays.asList(secondTicket));
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            newBuyer.getResult(winningTicket, LottoNumber.of(bonusNumber));
        }).withMessage(String.format("보너스 숫자(%d)는 중복될 수 없습니다.", bonusNumber));
    }

    private LottoTicket createTicket(int... numbers) {
        return new LottoTicket(Arrays.asList(
                LottoNumber.of(numbers[0]),
                LottoNumber.of(numbers[1]),
                LottoNumber.of(numbers[2]),
                LottoNumber.of(numbers[3]),
                LottoNumber.of(numbers[4]),
                LottoNumber.of(numbers[5])
        ));
    }
}