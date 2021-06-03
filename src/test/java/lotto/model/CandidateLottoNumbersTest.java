package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CandidateLottoNumbersTest {

    @Test
    void 같은객체를가리키지않는지(){
        CandidateLottoNumbers candidate = CandidateLottoGenerator.generate();
        LottoTicket try1 = candidate.getRandomLottoTicket();
        LottoTicket try2 = candidate.getRandomLottoTicket();
        assertThat(try1 == try2).isFalse();
    }
}