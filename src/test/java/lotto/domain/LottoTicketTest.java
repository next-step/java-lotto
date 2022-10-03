package lotto.domain;

import static java.util.stream.Collectors.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {
    @Test
    @DisplayName("6개 숫자들로 티켓 생성 시 정렬되어서 보관")
    void orderedLottoTicket() {
        LottoTicket lottoTicket = new LottoTicket(createLottoNumbers(List.of(6, 5, 3, 4, 1, 2)));
        List<LottoNumber> expected = createLottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(lottoTicket.getLottoNumbers()).isEqualTo(expected);
    }

    @Test
    @DisplayName("같은 로또 숫자이더라도 다른 티켓이다")
    void createWithSameNumbers() {
        List<LottoNumber> lottoNumbers = createLottoNumbers(List.of(1, 2, 3, 4, 5, 6));

        assertThat(new LottoTicket(lottoNumbers)).isNotEqualTo(new LottoTicket(lottoNumbers));
    }

    @Test
    @DisplayName("중복 숫자들로 티켓 생성 시 예외 생성")
    void createWithDuplicateNumbers() {
        assertThatThrownBy(() -> new LottoTicket(createLottoNumbers(List.of(1, 2, 3, 4, 5, 5))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("중복이 없어야 합니다");
    }

    @Test
    @DisplayName("6개보다 적은 숫자로 티켓 생성 시 예외 생성")
    void createWithNotEnoughNumbers() {
        assertThatThrownBy(() -> new LottoTicket(createLottoNumbers(List.of(1))))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("6개여야 합니다");
    }

    private List<LottoNumber> createLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(LottoNumber::new)
            .collect(toList());
    }
}
