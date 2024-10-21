package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {

    @RepeatedTest(value = 6)
    @DisplayName("사용자가 사용할 로또 숫자를 뽑는다.")
    public void randomLottoNumber(RepetitionInfo repetitionInfo) {
        LottoGenerator lottoGenerator = new LottoGenerator();
        List<Lotto> lottoList = lottoGenerator.generateLottoTickets(12000);

        assertThat(lottoList.size()).isEqualTo(12);
        assertThat(lottoList.get(repetitionInfo.getCurrentRepetition()).getNumbers().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("로또를 구매한다.")
    public void purchase() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        assertThat(lottoGenerator.getPurchaseCount(12000)).isEqualTo(12);
    }

}
