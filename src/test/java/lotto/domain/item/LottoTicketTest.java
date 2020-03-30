package lotto.domain.item;

import enums.LottoPrize;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LottoTicketTest {

    private List<LottoNumber> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)));
    }

    private static Stream<Arguments> provideMatchNumbers() {
        return Stream.of(
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)),
                        6, 1),
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(10)),
                        5, 2),
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(10), new LottoNumber(11)),
                        4, 3),
                Arguments.of(Arrays.asList(
                        new LottoNumber(1), new LottoNumber(10), new LottoNumber(11),
                        new LottoNumber(12), new LottoNumber(13), new LottoNumber(14)),
                        1, 0),
                Arguments.of(Arrays.asList(
                        new LottoNumber(10), new LottoNumber(11), new LottoNumber(12),
                        new LottoNumber(13), new LottoNumber(14), new LottoNumber(15)),
                        0, 0));
    }

    @DisplayName("로또 티켓 정상 생성")
    @Test
    public void constructor_success() throws Exception {
        //given
        LottoTicket ticket1 = new LottoTicket(numbers);
        LottoTicket ticket2 = new LottoTicket(numbers);

        assertThat(ticket1.equals(ticket2)).isTrue();
    }

    @DisplayName("당첨 번호와 비교해 로또 번호가 몇개가 맞는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideMatchNumbers")
    public void getLuckyNumberMatchCount_success(List<LottoNumber> comp, int expect) throws Exception {
        //given
        final LottoTicket lotto = new LottoTicket(comp);
        final WinLottoTicket winLottoTicket = new WinLottoTicket(numbers, new LottoNumber(45));

        //when
        int match = lotto.getLuckyNumberMatchCount(winLottoTicket);

        //then
        assertThat(match).isEqualTo(expect);
    }

    @DisplayName("해당 로또가 몇등인지 판단한다")
    @Test
    public void getRank_success() throws Exception {
        //given
        final LottoTicket lotto = new LottoTicket(numbers);
        final WinLottoTicket first = new WinLottoTicket(numbers, new LottoNumber(10));
        final WinLottoTicket second = new WinLottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(10)), new LottoNumber(6));
        final WinLottoTicket third = new WinLottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(10)), new LottoNumber(11));
        final WinLottoTicket miss = new WinLottoTicket(Arrays.asList(new LottoNumber(1), new LottoNumber(10), new LottoNumber(11), new LottoNumber(12), new LottoNumber(13), new LottoNumber(14)), new LottoNumber(20));

        //then
        assertAll(
                () -> assertThat(lotto.getRank(first)).isEqualTo(LottoPrize.FIRST)
                , () -> assertThat(lotto.getRank(second)).isEqualTo(LottoPrize.SECOND)
                , () -> assertThat(lotto.getRank(third)).isEqualTo(LottoPrize.THIRD)
                , () -> assertThat(lotto.getRank(miss)).isEqualTo(LottoPrize.MISS)
        );
    }
}
