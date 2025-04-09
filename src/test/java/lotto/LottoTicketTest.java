package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.factory.LottoFactory;
import lotto.strategy.AutoLottoStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LottoTicketTest {

    @Test
    @DisplayName("로또번호는 6개로 생성된다.")
    void generateLottoNumbers_6자제한(){
        assertThat(LottoTicket.generateLottoNumbers(new AutoLottoStrategy()).getLottoNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("중복된 숫자가 포함된 6개의 숫자를 입력하면 오류가 발생한다.")
    void validateLottoNumbers_withDuplicateNumbers() {
        List<LottoNumber> duplicateNumbers = List.of(
                LottoNumber.of(1),
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );

        assertThatThrownBy(() -> new LottoTicket(duplicateNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복되지 않은 6개의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("6개 숫자가 아니면 오류가 발생한다.")
    void validateLottoNumbers_withLessThanSixNumbers() {
        List<LottoNumber> lessNumbers = List.of(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3)
        );

        assertThatThrownBy(() -> new LottoTicket(lessNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 중복되지 않은 6개의 숫자여야 합니다.");
    }

    @Test
    @DisplayName("contains()는 LottoNumber가 리스트에 포함되어 있는지 확인한다")
    void contains_LottoNumberExists() {
        String input = "1, 2, 3, 4, 5, 6";
        LottoTicket lottoTicket = LottoFactory.createLottoTicket(input);
        LottoNumber targetNumber = LottoNumber.of(3);

        assertTrue(lottoTicket.contains(targetNumber));
    }

    @Test
    @DisplayName("contains()는 LottoNumber가 리스트에 포함되어 있지 않으면 false를 반환한다")
    void contains_LottoNumberDoesNotExist() {
        String input = "1, 2, 3, 4, 5, 6";
        LottoTicket lottoTicket = LottoFactory.createLottoTicket(input);
        LottoNumber targetNumber = LottoNumber.of(7);

        assertFalse(lottoTicket.contains(targetNumber));
    }
}
