package lottery.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lottery.dto.LotteryNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LotteryTicketOrderTest {

    @Test
    @DisplayName("수동으로 구입할 로또의 수량이 구입할 수 있는 개수보다 많으면 예외를 던진다.")
    void throwExceptionIfManualLotteryQuantityExceed() {
        List<LotteryNumbersDto> lotteryNumbersDtoList =
            Arrays.asList(
                new LotteryNumbersDto(Arrays.asList(1, 2, 3, 4, 5, 6)),
                new LotteryNumbersDto(Arrays.asList(10, 11, 12, 13, 14, 15))
            );

        assertThatThrownBy(() -> new LotteryTicketOrder(1000, lotteryNumbersDtoList))
            .isInstanceOf(RuntimeException.class);
    }
}
