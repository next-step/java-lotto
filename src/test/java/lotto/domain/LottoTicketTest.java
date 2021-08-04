package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTicketTest {
    private static LottoNumbers lottoNumbers;

    @BeforeAll
    static void setUp() {
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoTicketTest.lottoNumbers = () -> lottoNumbers;
    }

    @DisplayName("로또 티켓 생성 성공")
    @Test
    void new_success() {
        assertThat(new LottoTicket(lottoNumbers));
    }
}