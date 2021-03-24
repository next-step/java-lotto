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
                new LottoNumber(1),
                new LottoNumber(2),
                new LottoNumber(3),
                new LottoNumber(4),
                new LottoNumber(5),
                new LottoNumber(6)
        ));
    }

    @Test
    public void create() {
        assertThat(new LottoDiscriminator(lottoTicket)).isEqualTo(new LottoDiscriminator(lottoTicket));
    }

    @Test
    public void matchingCount() {
        final LottoTicket winningTicket = new LottoTicket(Arrays.asList(
                new LottoNumber(1),
                new LottoNumber(23),
                new LottoNumber(3),
                new LottoNumber(42),
                new LottoNumber(5),
                new LottoNumber(19)
        ));
        final LottoDiscriminator lottoDiscriminator = new LottoDiscriminator(winningTicket);

        assertThat(lottoDiscriminator.matchingCount(lottoTicket)).isEqualTo(3);
    }
}
