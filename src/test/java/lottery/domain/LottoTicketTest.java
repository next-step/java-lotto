package lottery.domain;

import lottery.domain.vo.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 생성 테스트")
    void lottoTicket(){
        final LottoTicket lottoTicket = new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6});

        Set<LottoNumber> actual = lottoTicket.lotteryNumbers();

        assertThat(actual).hasSize(LottoTicket.NUMBER_SIZE);
        assertThat(actual).contains(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6));
    }

    @Test
    @DisplayName("로또 번호 일치 개수 테스트")
    void matchNumbersCountTest() {
        final LottoTicket lottoTicket = new LottoTicket(new Integer[]{1, 2, 3, 4, 5, 6});
        final Set<LottoNumber> otherNumbers = Set.of(
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6),
                new LottoNumber(7),
                new LottoNumber(8));

        Long actual = lottoTicket.matchNumbersCount(otherNumbers);

        Long expected = 4L;
        assertThat(actual).isEqualTo(expected);
    }

}
