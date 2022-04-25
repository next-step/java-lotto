package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberGeneratorTest {

    @Test
    void generateLottoNumbers() {
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator(new RandomGenerateStrategy());
        Set<LottoNumber> lottoNumbers = lottoNumberGenerator.generateLottoNumbers();
        LottoTicket lottoTicket = new LottoTicket(lottoNumbers);
        assertThat(lottoTicket.getLottoNumbers()).hasSize(6);
    }

}