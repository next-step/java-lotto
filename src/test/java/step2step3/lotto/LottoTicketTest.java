package step2step3.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTicketTest {

    @Test
    void 로또_번호가_6개가_아니면_예외가_발생한다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1));

        assertThatThrownBy(() -> LottoTicket.from(numbersGenerator))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개이어야 합니다.");
    }

    @Test
    void 로또_번호를_출력할_수_있다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);

        OutputDevice outputDevice = new OutputDevice.Fake();
        assertThatCode(() -> lottoTicket.printNumbers(outputDevice))
                .doesNotThrowAnyException();
    }

    @Test
    void 등수를_구할_수_있다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);

        assertThat(lottoTicket.rank(LottoTicket.from(numbersGenerator))).isEqualTo(Rank.FIRST);
    }

    @Test
    void 비교하려는_로또_번호의_개수가_6개가_아닐경우_예외가_발생한다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);

        NumbersGenerator winningNumbers = new NumbersGenerator.Fake(Set.of(1));
        assertThatThrownBy(() -> lottoTicket.rank(LottoTicket.from(winningNumbers)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개이어야 합니다.");
    }

    @Test
    void 보너스_숫자의_포함_여부를_판별할_수_있다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);

        assertTrue(lottoTicket.hasBonusNumber(6));
    }
}
