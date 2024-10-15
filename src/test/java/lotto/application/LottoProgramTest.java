package lotto.application;

import lotto.application.strategy.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramTest {

    @DisplayName("구매한 로또 티켓 갯수만큼 로또 생성기를 이용해 로또 티켓 생성하여 반환한다.")
    @Test
    void generate_LottoTickets() {
        LottoNumbers lottoNumbers = new LottoNumbers(List.of(1, 2, 3, 4, 5, 6));
        LottoProgram lottoProgram = new LottoProgram(new LottoNumberGenerator() {
            @Override
            public List<LottoNumbers> generate(int generateCount) {
                return List.of(lottoNumbers);
            }
        });

        List<LottoNumbers> result = lottoProgram.generateLottoTickets(1);

        assertThat(result).hasSize(1)
                .containsExactly(lottoNumbers);
    }

}
