package lotto.domain;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTicketTest {
    @Test
    public void 생성_시_로또_숫자의_수가_6개가_넘어가면_IllegalArgumentException() {
        // given
        List<Integer> fiveNumbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> sixNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> sevenNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(fiveNumbers));
        new LottoTicket(sixNumbers);
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(sevenNumbers));
    }

    @Test
    public void 생성_시_로또_숫자간의_중복이_생기면_IllegalArgumentException() {
        // given
        List<Integer> duplicatedNumbers = Arrays.asList(1, 2, 3, 4, 5, 5);

        // when
        // then
        assertThatIllegalArgumentException().isThrownBy(() -> new LottoTicket(duplicatedNumbers));
    }

    @Test
    public void 서로_겹치는_숫자_갯수_구하기() {
        // given
        LottoTicket lottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket six = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
        LottoTicket zero = new LottoTicket(Arrays.asList(11, 12, 13, 14, 15, 16));

        // when
        int shouldBeSix = lottoNumbers.getNumberOfDuplicatedNumbers(six);
        int shouldBeZero = lottoNumbers.getNumberOfDuplicatedNumbers(zero);

        // then
        assertThat(shouldBeSix).isEqualTo(6);
        assertThat(shouldBeZero).isEqualTo(0);
    }
}
