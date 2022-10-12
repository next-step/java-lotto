package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoTicketTest {

    @Test
    @DisplayName("생성자 검증 - 정상 케이스")
    void constructorDI() {
        assertThat(new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6))));
    }

    @Test
    @DisplayName("생성자 검증 - 예외 케이스")
    void constructorDIException() {
        // 중복값
        assertThatThrownBy(() -> new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 1, 2, 2, 3, 3)))).isInstanceOf(IllegalArgumentException.class);

        // 길이
        assertThatThrownBy(() -> new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicket(new TreeSet<Integer>(Arrays.asList(1, 2, 3, 4, 5)))).isInstanceOf(IllegalArgumentException.class);

        // 범위
        assertThatThrownBy(() -> new LottoTicket(new TreeSet<Integer>(Arrays.asList(100, 200, 300, 400, 500, 600)))).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoTicket(new TreeSet<Integer>(Arrays.asList(-1, -2, -3, -4, -5, -6)))).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 반환 검증")
    void lottoTicket() {
        TreeSet<Integer> integers = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        assertThat(new LottoTicket(integers).lottoTicket()).isEqualTo(integers);
    }
}
