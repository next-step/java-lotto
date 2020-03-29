package lotto.domain.item;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinLottoTicketTest {

    private List<Integer> numbers;

    private static Stream<Arguments> provideMatchNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 10), 5),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 10, 11), 4),
                Arguments.of(Arrays.asList(1, 10, 11, 12, 13, 14, 15), 1),
                Arguments.of(Arrays.asList(10, 11, 12, 13, 14, 15, 16), 0)
        );
    }

    @DisplayName("당첨 로또를 생성 한다.")
    @Test
    public void create() throws Exception {
        //given
        WinLottoTicket winTicket = new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 6);
        WinLottoTicket winTicket2 = new WinLottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6), 6);

        //then
        assertThat(winTicket.equals(winTicket2)).isTrue();
    }
}
