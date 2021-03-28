package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoDiscriminatorTest {
    private LottoTicket winningTicket;
    private LottoNumber bonusNumber;

    @BeforeEach
    void setUp() {
        winningTicket = new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(2),
                        LottoNumber.of(3),
                        LottoNumber.of(4),
                        LottoNumber.of(5),
                        LottoNumber.of(6)
                )
        );
        bonusNumber = LottoNumber.of(7);
    }

    @Test
    public void create() {
        final LottoDiscriminator expected = new LottoDiscriminator(winningTicket, bonusNumber);

        final LottoDiscriminator result = new LottoDiscriminator(winningTicket, bonusNumber);

        assertThat(result).isEqualTo(expected);
    }


    @Test
    public void createDuplicateLottoNumbersAndBonusNumber() {
        final LottoNumber duplicateBonusNumber = LottoNumber.of(6);

        assertThatIllegalArgumentException().isThrownBy(() -> new LottoDiscriminator(winningTicket, duplicateBonusNumber));
    }

    @Test
    public void lottoRank() {
        final LottoRank expected = LottoRank.FIFTH;

        final LottoTicket lottoTicket = new LottoTicket(
                Arrays.asList(
                        LottoNumber.of(1),
                        LottoNumber.of(23),
                        LottoNumber.of(3),
                        LottoNumber.of(42),
                        LottoNumber.of(5),
                        LottoNumber.of(19)
                )
        );
        final LottoDiscriminator lottoDiscriminator = new LottoDiscriminator(winningTicket, bonusNumber);
        final LottoRank result = lottoDiscriminator.lottoRank(lottoTicket);

        assertThat(result).isEqualTo(expected);
    }
}
