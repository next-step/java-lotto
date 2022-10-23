package step2.lotto;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
}
