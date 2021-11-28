package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.exception.MinimumAmountException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoTicketBoothTest {

    private LottoTicketBooth lottoTicketBooth;

    @BeforeEach
    void setUp() {
        lottoTicketBooth = LottoTicketBooth.getInstance();
    }

    @ParameterizedTest
    @DisplayName("로또자동생성성공")
    @CsvSource(value = {"14000:14", "10000:10", "1000:1"}, delimiter = ':')
    void autoCreate(int money, int size) {
        assertThat(lottoTicketBooth.autoTickets(money).size()).isEqualTo(size);
    }

    @ParameterizedTest
    @DisplayName("로또 금액 부족 예외처리")
    @ValueSource(ints = {900, 100, 0})
    void LackOfMoneyException(Integer money) {
        assertThatExceptionOfType(MinimumAmountException.class)
            .isThrownBy(() -> lottoTicketBooth.autoTickets(money));
    }

    @Test
    void 로또자동생성() {
        Money money = Money.of(10000, 0);
        assertThat(lottoTicketBooth.generate(money)).isInstanceOf(LottoTickets.class);
    }

    @Test
    void 로또수동생성() {
        List<String> manualLottoNumbers = new ArrayList<>(Arrays.asList("1, 2, 3, 4, 5, 6", "10, 1, 23, 45, 44, 32"));
        assertThat(lottoTicketBooth.generate(manualLottoNumbers)).isInstanceOf(LottoTickets.class);
    }

}
