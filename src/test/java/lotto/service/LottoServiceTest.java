package lotto.service;

import lotto.domain.LottoConstraint;
import lotto.domain.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService(1000, new LottoConstraint(6, 45));
    @Test
    void testGetPrice(){
        assertThat(lottoService.getPrice()).isEqualTo(1000);
    }

    @Test
    void testGetConstraint(){
        LottoConstraint lottoConstraint = lottoService.getConstraint();
        assertThat(lottoConstraint).isNotNull();
    }

    @Test
    void testAddPrize(){
        long expected = 2000000000L;
        lottoService.addPrize(Rank.FIRST, expected);
        Long prize = lottoService.getPrize(Rank.FIRST);
        assertThat(prize).isEqualTo(expected);
    }
}
