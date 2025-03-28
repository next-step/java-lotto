package lotto.domain.model;

import lotto.domain.strategy.RandomLottoNumberGeneratorStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    @DisplayName("로또 티켓을 생성할 수 있다.")
    void shouldCreateValidLottoTicket() {
        Set<LottoNumber> validNumbers = new RandomLottoNumberGeneratorStrategy().generate();

        LottoTicket lottoTicket = new LottoTicket(validNumbers);

        assertThat(lottoTicket.getNumbers()).containsExactlyElementsOf(validNumbers);
    }

    @Test
    @DisplayName("로또 티켓 번호가 6개가 아니면 예외를 던진다.")
    void shouldThrowExceptionWhenNumberCountIsInvalid() {
        Set<LottoNumber> validNumbers = new RandomLottoNumberGeneratorStrategy().generate();

        Set<LottoNumber> invalidNumbers = new HashSet<>(validNumbers);
        invalidNumbers.remove(invalidNumbers.iterator().next());

        assertThatThrownBy(() -> new LottoTicket(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 반드시 6개의 숫자로 구성되어야 합니다.");
    }
}
