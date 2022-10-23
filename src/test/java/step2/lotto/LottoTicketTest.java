package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.*;

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

        OutputView<Integer> outputView = new OutputView.Fake<>();
        assertThatCode(() -> lottoTicket.print(outputView))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또_번호가_몇_개_일치하는지_알_수_있다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);

        Set<Integer> winningNumbers = Set.of(1, 2, 3, 4, 5, 6);
        assertThat(lottoTicket.numberOfMatchingNumbers(winningNumbers)).isEqualTo(6);
    }

    @Test
    void 비교하려는_로또_번호의_개수가_6개가_아닐경우_예외가_발생한다() {
        NumbersGenerator numbersGenerator = new NumbersGenerator.Fake(Set.of(1, 2, 3, 4, 5, 6));

        LottoTicket lottoTicket = LottoTicket.from(numbersGenerator);

        Set<Integer> winningNumbers = Set.of(1);
        assertThatThrownBy(() -> lottoTicket.numberOfMatchingNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 6개이어야 합니다.");
    }
}
