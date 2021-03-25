package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("로또 기계")
class LottoFactoryTest {

    List<Integer> manualLotto() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    List<List<Integer>> createManualLottos(int quantity) {
        return Stream.generate(this::manualLotto)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,5", "1000,1"})
    @DisplayName("로또 자동 개수 확인")
    void createAutoLottoSizeTest(int amount, int autoSize) {
        //given
        List<LottoTicket> lottoTickets = LottoFactory.createAutoLottoTickets(amount, createManualLottos(0));

        //when
        int result = lottoTickets.size();

        //then
        assertThat(result).isEqualTo(autoSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"5", "10"})
    @DisplayName("로또 수동 개수 확인")
    void createManualLottoSizeTest(int quantity) {
        //given
        List<LottoTicket> lottoTickets = LottoFactory.createManualLottoTickets(createManualLottos(quantity));

        //when
        int result = lottoTickets.size();

        //then
        assertThat(quantity).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,5,0,5", "5000,3,2,5", "10000,8,2,10"})
    @DisplayName("로또 자동,수동 개수 확인")
    void createAutoAndManualLottoSizeTest(int amount, int autoSize, int manualQuantity, int ticketSize) {
        //given
        List<LottoTicket> autoLottoTickets = LottoFactory.createAutoLottoTickets(amount, createManualLottos(manualQuantity));
        List<LottoTicket> manualLottoTickets = LottoFactory.createManualLottoTickets(createManualLottos(manualQuantity));

        //when
        int sum = autoLottoTickets.size() + manualLottoTickets.size();

        //then
        assertThat(ticketSize).isEqualTo(sum);
        assertThat(autoLottoTickets.size()).isEqualTo(autoSize);
        assertThat(manualLottoTickets.size()).isEqualTo(manualQuantity);
    }



    @ParameterizedTest
    @CsvSource(value = {"10000,11"})
    @DisplayName("수동 개수가 금액초과 시 예외 확인")
    void manualOverQuantityExceptionTest(int buyAmount, int manualQuantity) {
        //given

        //when
        assertThatThrownBy(() -> LottoFactory.createAutoLottoTickets(buyAmount, createManualLottos(manualQuantity)))
                .isInstanceOf(IllegalArgumentException.class);

        //then
    }

}
