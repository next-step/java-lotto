package lotto.domain.model.lotto;

import lotto.domain.model.game.MatchCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTicketTest {

    @DisplayName("로또 티켓 생성 테스트")
    @Test
    void createLottoTicket() {
        Set<LottoNumber> numbers = createLottoNumbers(1, 2, 3, 4, 5, 6);

        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.getNumbers()).hasSize(6);
        assertThat(lottoTicket.getNumbers()).isEqualTo(numbers);
    }

    @DisplayName("로또 티켓 번호 개수 검증 테스트")
    @Test
    void validateLottoTicketNumberCount() {
        Set<LottoNumber> invalidNumbers = createLottoNumbers(1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoTicket(invalidNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 번호는 반드시 6개의 숫자로 구성되어야 합니다");
    }

    @DisplayName("로또 티켓 번호 포함 여부 테스트")
    @Test
    void containsLottoNumber() {
        Set<LottoNumber> numbers = createLottoNumbers(1, 2, 3, 4, 5, 6);
        LottoTicket lottoTicket = new LottoTicket(numbers);

        assertThat(lottoTicket.contains(new LottoNumber(1))).isTrue();
        assertThat(lottoTicket.contains(new LottoNumber(7))).isFalse();
    }

    @DisplayName("로또 티켓 일치 번호 개수 테스트")
    @Test
    void countMatchingNumbers() {
        LottoTicket ticket1 = new LottoTicket(createLottoNumbers(1, 2, 3, 4, 5, 6));
        LottoTicket ticket2 = new LottoTicket(createLottoNumbers(1, 2, 3, 7, 8, 9));

        MatchCount matchCount = ticket1.countMatchingNumbers(ticket2);

        assertThat(matchCount).isEqualTo(new MatchCount(3));
        assertThat(matchCount.getValue()).isEqualTo(3);
    }

    private Set<LottoNumber> createLottoNumbers(final int... numbers) {
        Set<LottoNumber> lottoNumbers = new TreeSet<>();
        for (int number : numbers) {
            lottoNumbers.add(new LottoNumber(number));
        }
        return lottoNumbers;
    }
} 
