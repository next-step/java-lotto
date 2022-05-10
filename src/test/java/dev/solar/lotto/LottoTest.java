package dev.solar.lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다.")
    @CsvSource(value = { "14000:14", "13500:13", "0:0" }, delimiter = ':')
    @ParameterizedTest
    void issue_lotto_equal_purchase_amount(int payment, int purchaseAmount) {
        assertThat(Lotto.buyLottoTickets(payment).getRemainingLottoTicket()).isEqualTo(purchaseAmount);
    }

    @DisplayName("로또 한 장당 6개의 번호를 랜덤으로 선택한다.")
    @Test
    void pick_lotto_random_number() {
        final Lotto lotto = Lotto.buyLottoTickets(1000);
        LottoTicket lottoTicket = lotto.pick();
        System.out.println(lottoTicket);
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @DisplayName("입력받은 당첨 번호로 몇개의 번호를 맞췄는지 계산한다.")
    @MethodSource("lottoNumbers")
    @ParameterizedTest
    void check_the_number_of_wins(LottoTicket lottoTicket, int result) {
        Set<LottoNumber> winningNumbers = new TreeSet<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        assertThat(lottoTicket.checkWinningNumbers(winningNumbers)).isEqualTo(result);
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(Arguments.of(new LottoTicket(new TreeSet<>(
                                 Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(44), new LottoNumber(45)))), 4),
                         Arguments.of(new LottoTicket(new TreeSet<>(
                                 Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)))), 5),
                         Arguments.of(new LottoTicket(new TreeSet<>(
                                 Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)))), 6));
    }

    @DisplayName("수익률을 계산한다.")
    @Test
    void calculate_profit_margin() {
        final TreeMap<PrizeMoney, Integer> winningResult = new TreeMap<>();
        winningResult.put(PrizeMoney.THREE, 1);
        winningResult.put(PrizeMoney.FOUR, 0);
        winningResult.put(PrizeMoney.FIVE, 0);
        winningResult.put(PrizeMoney.SIX, 0);
        final Lotto lotto = new Lotto(14000, winningResult);

        final double actual = lotto.calculateProfitMargin();
        assertThat(actual).isEqualTo(0.35, withPrecision(0.01));

    }
}
