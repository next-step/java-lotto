package step4.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketGeneratorTest {
    @Test
    void 로또복권을_생성한다() {
        //Given
        LottoTicket lottoTicket = LottoTicketGenerator.issue();
        //When
        //Then
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(LottoTicketGenerator.BASIC_LOTTO_SIZE);
    }

    @Test
    void 로또번호_1부터_45까지를_생성하여_리스트에_담는다() {
        //Given
        List<Integer> lottoBalls = LottoBalls.getLottoBalls();

        //When
        //Then
        assertThat(lottoBalls.size()).isEqualTo(LottoNumber.MAXIMUM_LOTTO_NUMBER);
    }

    @Test
    void 로또번호가_담긴_리스트로부터_6개의_숫자를_추출하여_리스트에_담는다() {
        //Given
        List<Integer> lottoBalls = LottoBalls.getLottoBalls();

        //When
        List<LottoNumber> lotto = LottoTicketGenerator.pickLottoBalls(lottoBalls);

        //Then
        assertThat(lotto.size()).isEqualTo(LottoTicketGenerator.BASIC_LOTTO_SIZE);
    }

    @Test
    void 추출된_6개의_숫자를_오름차순으로_정렬한다() {
        //Given
        List<Integer> lottoBalls = LottoBalls.getLottoBalls();

        //When
        List<LottoNumber> lotto = LottoTicketGenerator.pickLottoBalls(lottoBalls);

        //Then
        assertThat(lotto.get(LottoTicketGenerator.BASIC_LOTTO_SIZE - 1).getNumber()).isGreaterThan(lotto.get(0).getNumber());
    }
}
