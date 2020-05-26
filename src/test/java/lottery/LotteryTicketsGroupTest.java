package lottery;

import com.sun.org.apache.xpath.internal.Arg;
import lottery.domain.LotteryNumber;
import lottery.domain.LotteryTicket;
import lottery.domain.LotteryTicketsGroup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

public class LotteryTicketsGroupTest {

    private List<LotteryTicket> lotteryTicketList;

    @BeforeEach
    public void setupLotteryTicket() {
        List<LotteryNumber> lotteryNumberList = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            lotteryNumberList.add(new LotteryNumber(i));
        }
        LotteryTicket lotteryTicket = new LotteryTicket(lotteryNumberList);
        lotteryTicketList = Arrays.asList(lotteryTicket, lotteryTicket);
    }

    @DisplayName("LotteryTicketsGroup 정상 생성 테스트")
    @Test
    public void makeLotteryTicketsGroupObject() {
        assertThatCode(() -> {
            LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(lotteryTicketList);
        }).doesNotThrowAnyException();

        LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(lotteryTicketList);
        assertThat(lotteryTicketsGroup.getClass())
                .isEqualTo(LotteryTicketsGroup.class);
    }

    @DisplayName("LotteryTicketGroups 사이즈 비교 메소드 테스트")
    @ParameterizedTest
    @MethodSource("mockLotteryTicketGroupBuilder")
    public void returnBooleanOnWhetherSizeEqualsLotteryTicketCounts(int lotteryTicketCounts, boolean result) {
        LotteryTicketsGroup lotteryTicketsGroup = new LotteryTicketsGroup(lotteryTicketList);

        assertThat(lotteryTicketsGroup.isSameCounts(lotteryTicketCounts))
                .isEqualTo(result);
    }

    private static Stream<Arguments> mockLotteryTicketGroupBuilder() {
        return Stream.of(
                Arguments.of(2, true),
                Arguments.of(1, false)
        );
    }
}
