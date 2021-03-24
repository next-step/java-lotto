package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoDiscriminatorTest {
    private LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(2),
                LottoNumber.of(3),
                LottoNumber.of(4),
                LottoNumber.of(5),
                LottoNumber.of(6)
        ));
    }

    @Test
    public void create() {
        assertThat(new LottoDiscriminator(lottoTicket)).isEqualTo(new LottoDiscriminator(lottoTicket));
    }

    @Test
    public void matchingCount() {
        final LottoTicket winningTicket = new LottoTicket(Arrays.asList(
                LottoNumber.of(1),
                LottoNumber.of(23),
                LottoNumber.of(3),
                LottoNumber.of(42),
                LottoNumber.of(5),
                LottoNumber.of(19)
        ));
        final LottoDiscriminator lottoDiscriminator = new LottoDiscriminator(winningTicket);

        assertThat(lottoDiscriminator.matchingCount(lottoTicket)).isEqualTo(3);
    }
}
