package lottery.domain;

import lottery.dto.LotteryNumbersDto;
import lottery.dto.LotteryTicketOrderDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LotteryTicketIssuerTest {

    static Stream<Arguments> generateTestData() {
        List<LotteryNumbersDto> lotteryNumbersDtoList = Arrays.asList(
            new LotteryNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LotteryNumbersDto(Arrays.asList(7, 8 ,9, 10, 11, 12))
        );


        return Stream.of(
            Arguments.of(new LotteryTicketOrderDto(14000, lotteryNumbersDtoList), 14),
            Arguments.of(new LotteryTicketOrderDto(2000, lotteryNumbersDtoList), 2)
        );
    }

    @ParameterizedTest
    @DisplayName("지불한 금액에 맞게 로또를 발급한다.")
    @MethodSource("generateTestData")
    void sellLottery(LotteryTicketOrderDto order, int expected) {
        LotteryTicket lotteryTicket = LotteryTicketIssuer.issue(order);

        assertThat(lotteryTicket.exportLotteryNumbers()).hasSize(expected);
    }

    @Test
    @DisplayName("지불한 돈보다 많은 수동 발급을 요구한 경우에는 예외 처리한다.")
    void throwExceptionIfExceedManualLotteryQuantity() {
        List<LotteryNumbersDto> lotteryNumbersDtoList = Arrays.asList(
            new LotteryNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6)),
            new LotteryNumbersDto(Arrays.asList(7, 8 ,9, 10, 11, 12))
        );
        LotteryTicketOrderDto order = new LotteryTicketOrderDto(1000, lotteryNumbersDtoList);

        assertThatThrownBy(() -> LotteryTicketIssuer.issue(order)).isInstanceOf(RuntimeException.class);
    }
}
