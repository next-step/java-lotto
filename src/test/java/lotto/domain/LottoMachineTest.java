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
public class LottoMachineTest {

    public LottoQuantity createQuantity(int amount, int quantity) {
        return new LottoQuantity(amount, quantity);
    }

    public List<Integer> manualLotto() {
        return Arrays.asList(1,2,3,4,5,6);
    }

    public List<List<Integer>> createManualLottos(int quantity) {
        return Stream.generate(this::manualLotto)
                .limit(quantity)
                .collect(Collectors.toList());
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,0", "1000,0"})
    @DisplayName("로또 자동 개수 확인")
    public void createAutoLottoSizeTest(int amount, int qantity) throws Exception {
        //given
        LottoQuantity lottoQuantity = createQuantity(amount, qantity);
        LottoTickets lottoTickets = LottoMachine.createLottoTickets(lottoQuantity);

        //when
        boolean result = lottoQuantity.isAutoQuantityCheck(lottoTickets.readOnlyLottoTicket().size());

        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,5", "10000,10"})
    @DisplayName("로또 수동 개수 확인")
    public void createManualLottoSizeTest(int amount, int qantity) throws Exception {
        //given
        LottoQuantity lottoQuantity = createQuantity(amount, qantity);
        LottoTickets lottoTickets = LottoMachine.createLottoTickets(lottoQuantity, createManualLottos(qantity));

        //when
        boolean result = lottoQuantity.isManualQuantityCheck(lottoTickets.readOnlyLottoTicket().size());

        //then
        assertThat(result).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"5000,0,5", "5000,2,5", "10000,2,10"})
    @DisplayName("로또 자동,수동 개수 확인")
    public void createAutoAndManualLottoSizeTest(int amount, int qantity, int ticketSize) throws Exception {
        //given
        LottoQuantity lottoQuantity = createQuantity(amount, qantity);
        LottoTickets lottoTickets = LottoMachine.createLottoTickets(lottoQuantity, createManualLottos(qantity));

        //when

        //then
        assertThat(lottoTickets.readOnlyLottoTicket().size()).isEqualTo(ticketSize);
    }

}
