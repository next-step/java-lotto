package me.daeho.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 테스트")
class LottoTicketTest {
    @Test
    public void issue_not_6_count_number() {
        List<LottoNumber> fiveNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5)
        );

        List<LottoNumber> sevenNumbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6),
                LottoNumber.of(7)
        );

        assertThatThrownBy(() -> LottoTicket.issue(fiveNumbers))
                .isInstanceOf(RuntimeException.class);

        assertThatThrownBy(() -> LottoTicket.issue(sevenNumbers))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void containsCountTest() {
        List<LottoNumber> numbers = Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        );

        List<LottoNumber> diffNumbers = Arrays.asList(
                LottoNumber.of(7),
                LottoNumber.of(8),
                LottoNumber.of(9),
                LottoNumber.of(10),
                LottoNumber.of(11),
                LottoNumber.of(12)
        );

        LottoTicket lotto = LottoTicket.issue(numbers);
        assertThat(lotto.containsCount(numbers)).isEqualTo(6);
        assertThat(lotto.containsCount(diffNumbers)).isEqualTo(0);
    }
}