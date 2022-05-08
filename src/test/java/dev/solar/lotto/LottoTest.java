package dev.solar.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

public class LottoTest {
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }

    @DisplayName("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급한다.")
    @CsvSource(value = { "14000:14", "13500:13", "0:0" }, delimiter = ':')
    @ParameterizedTest
    void issue_lotto_equal_purchase_amount(int purchaseAmount, int amountOfLotto) {
        assertThat(lotto.buyLotto(purchaseAmount)).isEqualTo(amountOfLotto);
    }

    @DisplayName("로또 한 장당 6개의 번호를 랜덤으로 선택한다.")
    @Test
    void pick_lotto_random_number() {
        LottoTicket lottoTicket = lotto.pick();
        System.out.println(lottoTicket);
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

    @DisplayName("입력받은 당첨 번호로 몇개의 번호를 맞췄는지 계산한다.")
    @MethodSource("lottoNumbers")
    @ParameterizedTest
    void check_the_number_of_wins(LottoTicket lottoTicket, int result) {
        Set<LottoNumber> winningNumbers = new HashSet<>(
                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));

        assertThat(lottoTicket.checkWinningNumbers(winningNumbers)).isEqualTo(result);
    }

    private static Stream<Arguments> lottoNumbers() {
        return Stream.of(
                Arguments.of(
                        new LottoTicket(new HashSet<>(
                                        Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(44), new LottoNumber(45))
                        )), 4),
                Arguments.of(
                        new LottoTicket(new HashSet<>(
                                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(45))
                        )), 5),
                Arguments.of(
                        new LottoTicket(new HashSet<>(
                                Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6))
                        )), 6)
                );
    }
}
