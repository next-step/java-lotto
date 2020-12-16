package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoTicketTest {

    @DisplayName("로또티켓 발행 - 6개의 로또 번호 입력")
    @Test
    void create() {
        //given
        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 6)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());

        //when
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);

        //then
        assertThat(lottoTicket).isNotNull();
    }

    @DisplayName("로또티켓 발행 - 6개의 로또 번호가 아닌 경우")
    @Test
    void create_exception() {
        //given
        Set<LottoNumber> lottoNumbers = IntStream.rangeClosed(1, 5)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());

        //when
        assertThatIllegalArgumentException()
              .isThrownBy(() -> new LottoTicket(lottoNumbers))
              .withMessage("6개의 로또 번호를 입력해주세요");
    }

    @DisplayName("일치개수 확인")
    @ParameterizedTest
    @CsvSource(value = {"6,11,1", "7,12,0"})
    void matchCount(int start, int end, int expected) {
        //given
        Set<LottoNumber> userLottoNumber = IntStream.rangeClosed(1, 6)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());

        Set<LottoNumber> lastWinningLottoNumber = IntStream.rangeClosed(start, end)
              .mapToObj(LottoNumber::new)
              .collect(Collectors.toSet());

        LottoTicket userTicket = new LottoTicket(userLottoNumber);
        LottoTicket lastWinningTicket = new LottoTicket(lastWinningLottoNumber);

        //when
        int matchCount = userTicket.matchCount(lastWinningTicket);

        //then
        assertThat(matchCount).isEqualTo(expected);
    }
}
