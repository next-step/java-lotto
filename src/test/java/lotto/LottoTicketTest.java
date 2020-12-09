package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("로또 티켓(LottoTicketTest) 테스트")
public class LottoTicketTest {

    private LottoTicket lottoTicket;

    @BeforeEach
    void setup() {
        lottoTicket = LottoTicket.of(1, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 티켓은 6개의 로또번호로 만들어진다.")
    @Test
    void crate() {
        // then
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("로또 번호가 6개가 아닐 경우 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 5, 7})
    void createOutOfRange(int size) {
        // given
        int[] values = IntStream.range(0, size)
                .toArray();

        // when / then
        assertThrows(IllegalArgumentException.class, () -> LottoTicket.of(values));
    }

    @DisplayName("특정 로또 번호가 포함되는지 확인할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"6,true", "7,false", "8,false"})
    void contains(int value, boolean expected) {
        // when
        boolean contains = lottoTicket.contains(value);

        // then
        assertThat(contains).isEqualTo(expected);
    }

    @DisplayName("당첨 로또 번호와 비교해서 등수를 구할 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {
            "FIRST,1,2,3,4,5,6",
            "SECOND,2,3,4,5,6,7",
            "THIRD,3,4,5,6,7,8,",
            "FOURTH,4,5,6,7,8,9",
            "UN_RANK,5,6,7,8,9,10",
    })
    void match(String expected, int num1, int num2, int num3, int num4, int num5, int num6) {
        // given
        LottoTicket winning = lottoTicket;
        LottoTicket lottoTicket = LottoTicket.of(num1, num2, num3, num4, num5, num6);

        // when / then
        assertThat(lottoTicket.match(winning)).isEqualTo(Rank.valueOf(expected));
    }
}
