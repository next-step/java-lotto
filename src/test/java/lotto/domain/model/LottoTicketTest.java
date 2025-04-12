package lotto.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTicketTest {
    @DisplayName("중복이 있는 로또 번호를 생성할 수 없다.")
    @Test
    void createDuplicateTest() {
        try {
            new LottoTicket(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(5) // 중복된 번호
            ));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Lotto numbers must not contain duplicates.");
        }
    }

    @DisplayName("로또 번호의 개수가 6개가 아니면 예외를 발생시킨다.")
    @Test
    void createSizeTest() {
        try {
            new LottoTicket(List.of(
                    new LottoNumber(1),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5)
            ));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Lotto numbers must contain exactly 6 numbers.");
        }
    }

    @DisplayName("로또 번호의 범위가 1~45가 아니면 예외를 발생시킨다.")
    @Test
    void createRangeTest() {
        try {
            new LottoTicket(List.of(
                    new LottoNumber(0),
                    new LottoNumber(2),
                    new LottoNumber(3),
                    new LottoNumber(4),
                    new LottoNumber(5),
                    new LottoNumber(6)
            ));
        } catch (IllegalArgumentException e) {
            assertThat(e.getMessage()).isEqualTo("Lotto number must be between 1 and 45.");
        }
    }

    @DisplayName("로또 번호를 포함하는지 확인한다.")
    @Test
    void containsTest() {
        LottoTicket lottoTicket = new LottoTicket(List.of(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));

        assertThat(lottoTicket.contains(new LottoNumber(1))).isTrue();
        assertThat(lottoTicket.contains(new LottoNumber(7))).isFalse();
    }
}
