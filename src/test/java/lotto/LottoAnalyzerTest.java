package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 분석기(LottoAnalyzer) 테스트")
public class LottoAnalyzerTest {

    @DisplayName("등수들로 로또 결과 만든다")
    @Test
    void analyze() {
        // given
        LottoTickets lottoTickets = LottoTickets.of(Arrays.asList(
                LottoTicket.of(1, 2, 3, 4, 5, 6),
                LottoTicket.of(2, 3, 4, 5, 6, 7)
        ));
        LottoTicket winning = LottoTicket.of(1, 2, 3, 4, 5, 6);

        // when
        LottoReport lottoReport = LottoAnalyzer.analyze(lottoTickets, winning);

        // then
        assertThat(lottoReport).isNotNull();
    }
}
