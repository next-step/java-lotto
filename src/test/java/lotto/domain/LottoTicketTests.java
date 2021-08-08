package lotto.domain;

import lotto.exception.InvalidLottoNumberCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTicketTests {

    @DisplayName("로또 번호 담는 일급 객체 생성 테스트")
    @Test
    void createLottoNumbersTest() {
        LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(lottoTicket).isEqualTo(LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6)));
    }

    @DisplayName("로또 번호들의 갯수를 7개 생성 시킬 때 에러 처리 테스트")
    @Test
    void invalidCountLottoNumberCreateTest() {
        assertThatExceptionOfType(InvalidLottoNumberCountException.class)
                .isThrownBy(() -> {
                    LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
                }).withMessageMatching("로또 숫자는 반드시 6개 여야 합니다.");
    }

    @DisplayName("중복의 경우 5개만 생성 되므로, 그에 관한 에러 처리 테스트")
    @Test
    void duplicatedCountLottoNumberCreateTest() {
        assertThatExceptionOfType(InvalidLottoNumberCountException.class)
                .isThrownBy(() -> {
                    LottoTicket lottoTicket = LottoTicket.of(Arrays.asList(1, 2, 3, 4, 5, 5));
                }).withMessageMatching("로또 숫자는 반드시 6개 여야 합니다.");
    }
}
