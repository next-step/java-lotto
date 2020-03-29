package lotto.domain.item;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {

    private List<Integer> numbers;

    private static Stream<Arguments> provideMatchNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 10), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(Arrays.asList(1, 10, 11, 12, 13, 14), 1),
                Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15), 0)
        );
    }

    @BeforeEach
    void setUp() {
        numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 티켓 정상 생성")
    @Test
    public void constructor() throws Exception {
        //given
        LottoTicket ticket1 = new LottoTicket(numbers);
        LottoTicket ticket2 = new LottoTicket(numbers);

        assertThat(ticket1.equals(ticket2)).isTrue();
    }

    @DisplayName("당첨 번호와 비교해 로또 번호가 몇개가 맞는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideMatchNumbers")
    public void getLuckyNumberMatchCount(List<Integer> comp, int expect) throws Exception {
        //given
        final LottoTicket lotto = new LottoTicket(numbers);
        final WinLottoTicket winLottoTicket = new WinLottoTicket(comp, 45);

        //when
        int match = lotto.getLuckyNumberMatchCount(winLottoTicket);

        //then
        assertThat(match).isEqualTo(expect);
    }
}
