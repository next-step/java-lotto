package lotto.domains;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 당첨로또_개수_추가하기() {
        LottoResult lottoResult = new LottoResult(4, 5000);
        lottoResult.addWinner(4);

        assertThat(lottoResult).isEqualTo(new LottoResult(4, 5000, 1));
    }
}