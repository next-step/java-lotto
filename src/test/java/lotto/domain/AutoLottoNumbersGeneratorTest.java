package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AutoLottoNumbersGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("구입 개수 만큼 로또 티켓을 발급한다")
    void ticketBuyTest(int count) {
        LottoNumbersGenerator lottoNumbersGenerator = new AutoLottoNumbersGenerator(count, new RandomNumbersGenerator());
        List<LottoNumbers> lottoTickets = lottoNumbersGenerator.generate();
        assertThat(lottoTickets.size()).isEqualTo(count);
    }
}
