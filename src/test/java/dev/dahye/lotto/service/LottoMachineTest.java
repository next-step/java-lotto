package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoOrder;
import dev.dahye.lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 머신 객체")
class LottoMachineTest {
    @ParameterizedTest
    @MethodSource("lottoMachine_issued")
    @DisplayName("구입 금액과 수동으로 구매할 로또 수를 입력하면 로또를 발행할 수 있다.")
    void issued(LottoOrder lottoOrder, int expectedCountOfLotto) {
        LottoMachine lottoMachine = new LottoMachine(lottoOrder);
        assertThat(lottoMachine.getLottoTickets().size()).isEqualTo(expectedCountOfLotto);
    }

    private static Stream<Arguments> lottoMachine_issued() {
        return Stream.of(
                arguments(LottoOrder.of(new LottoMoney(3000), 1, Arrays.asList(LottoTicket.autoIssued())), 3)
        );
    }
}