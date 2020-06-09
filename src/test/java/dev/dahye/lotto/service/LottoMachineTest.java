package dev.dahye.lotto.service;

import dev.dahye.lotto.domain.LottoMoney;
import dev.dahye.lotto.domain.LottoOrder;
import dev.dahye.lotto.domain.LottoTicket;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;

@DisplayName("로또 머신 객체")
class LottoMachineTest {
    @ParameterizedTest(name = "로또의 전체 갯수는 {0}개, 수동 로또 갯수는 {1}인 경우, 로또티켓의 갯수는 {1}개 여야 한다.")
    @MethodSource("lottoMachine_fail")
    @DisplayName("수동 로또 갯수만큼 수동 로또 티켓이 입력되지 않은 경우 IllegalArgument Exception throw")
    void validateCountOfManualLottoTickets(int totalCountOfLotto, int countOfManualLotto, List<LottoTicket> lottoTickets) {
        LottoMoney lottoMoney = new LottoMoney(totalCountOfLotto * LottoMoney.PRICE_PER_LOTTO);
        LottoOrder lottoOrder = LottoOrder.of(lottoMoney, countOfManualLotto);
        assertThatThrownBy(() -> new LottoMachine(lottoMoney, lottoOrder, lottoTickets))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("수동 로또 갯수 만큼 로또 티켓을 입력해주세요.");
    }

    private static Stream<Arguments> lottoMachine_fail() {
        return Stream.of(
                arguments(2, 1, Arrays.asList(LottoTicket.autoIssued(), LottoTicket.autoIssued())),
                arguments(2, 0, Arrays.asList(LottoTicket.autoIssued()))
        );
    }
}