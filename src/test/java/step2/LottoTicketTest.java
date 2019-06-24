package step2;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @Test
    void 로또복권을_생성한다() {
        //Given
        LottoTicket lottoTicket = LottoTicket.issue();
        //When
        //Then
        assertThat(lottoTicket.getLottoTicket().size()).isEqualTo(LottoTicket.BASIC_LOTTO_SIZE);
    }

    @Test
    void 로또번호_1부터_45까지를_생성하여_리스트에_담는다() {
        //Given
        List<Integer> lottoBalls = LottoTicket.generateLottoBalls();

        //When
        //Then
        assertThat(lottoBalls.size()).isEqualTo(LottoNumber.MAXIMUM_LOTTO_NUMBER);
    }

    @Test
    void 생성된_로또번호_45개를_섞는다() {
        //Given
        List<Integer> testNumbers = new ArrayList<>();
        testNumbers.add(1);
        testNumbers.add(2);
        testNumbers.add(3);

        //When
        LottoTicket.shuffleLottoBalls(testNumbers);

        //Then
//        assertThat(testNumbers.get(0)).isNotEqualTo(1);
        //TODO: 이 테스트는 완전하지 않습니다. 셔플링을 어떻게 테스트하면 좋을까요
    }

    @Test
    void 로또번호가_담긴_리스트로부터_6개의_숫자를_추출하여_리스트에_담는다() {
        //Given
        List<Integer> lottoBalls = LottoTicket.generateLottoBalls();

        //When
        List<Integer> lotto = LottoTicket.pickLottoBalls(lottoBalls);

        //Then
        assertThat(lotto.size()).isEqualTo(LottoTicket.BASIC_LOTTO_SIZE);
    }

    @Test
    void 추출된_6개의_숫자를_오름차순으로_정렬한다() {
        //Given
        List<Integer> lottoBalls = LottoTicket.generateLottoBalls();

        //When
        List<Integer> lotto = LottoTicket.pickLottoBalls(lottoBalls);

        //Then
        assertThat(lotto.get(LottoTicket.BASIC_LOTTO_SIZE - 1)).isGreaterThan(lotto.get(0));
    }

}
