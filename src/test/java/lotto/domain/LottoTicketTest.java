package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private static LottoNumbers lottoNumbers;

    @BeforeAll
    static void setUp() {
        Set<LottoNumber> lottoNumbers = new HashSet<>(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)));
        LottoTicketTest.lottoNumbers = () -> lottoNumbers;
    }

    @DisplayName("로또 티켓 생성 성공")
    @Test
    void new_success() {
        assertThat(new LottoTicket(lottoNumbers));
    }
}