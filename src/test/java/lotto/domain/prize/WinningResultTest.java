package lotto.domain.prize;

import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.LottoTicket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class WinningResultTest {
    WinningResult winningResult;
    LottoTicket lottoTicket;

    @BeforeEach
    void setUp() {
        lottoTicket = new LottoTicket(1) {
            @Override
            public List<LottoNumbers> getLottoTicket() {
                LottoNumbers lottoNumbers = new LottoNumbers() {
                    @Override
                    public List<Integer> getLottoNumbers() {
                        return Arrays.asList(1, 11, 14, 23, 31, 44);
                    }
                };
                return Arrays.asList(lottoNumbers);
            }

            ;
        };
    }

    @Test
    void 당첨결과를_생성한다() {
        String enteredWinNumber = "1, 11, 17, 23, 31, 43";
        int expectedMatchCount = 4;
        int expectedWinCount = 1;

        winningResult = WinningResult.create(lottoTicket, enteredWinNumber);
        assertThat(winningResult.getWinningResult().get(expectedMatchCount)).isEqualTo(expectedWinCount);
    }

    @Test
    void 수익율을_계산한다() {
        String enteredWinNumber = "1, 11, 17, 23, 31, 43";
        winningResult = WinningResult.create(lottoTicket, enteredWinNumber);

        double winningRate = winningResult.calculateWinningRate(14000);
        assertThat(winningRate).isEqualTo(3.57);

    }


}