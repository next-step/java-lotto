import domain.lottery.LotteryNumber;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import util.Converter;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConverterTest {

    @Test
    @Order(1)
    public void 복권변환_성공() {
        String[] numbers = {"1", "2", "3", "4", "5", "6"};
        List<LotteryNumber> expected = Arrays.asList(
                LotteryNumber.of(1), LotteryNumber.of(2), LotteryNumber.of(3),
                LotteryNumber.of(4), LotteryNumber.of(5), LotteryNumber.of(6));
        assertThat(Converter.convertStringToLotteryTicket(numbers).getTicketNumbers()).isEqualTo(expected);
    }

    @Test
    @Order(2)
    public void 복권변환_실패() {
        String[] numbers = {"a", "b", "c", "d", "e", "f"};
        assertThatThrownBy(() -> Converter.convertStringToLotteryTicket(numbers))
                .isInstanceOf(NumberFormatException.class);
    }

}
