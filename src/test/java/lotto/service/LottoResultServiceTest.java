package lotto.service;

import lotto.domain.Amount;
import lotto.domain.ProfitRate;
import lotto.domain.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottonumber.LottoNumber;
import lotto.domain.lottonumber.LottoNumberSet;
import lotto.domain.lotto.LottoWinner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

public class LottoResultServiceTest {

    private LottoResultService lottoResultService;

    @BeforeEach
    void setUp() {
        this.lottoResultService = new LottoResultService();
    }

    @DisplayName("당첨번호와 일치하는 갯수 배열을 반환한다.")
    @Test
    void check_lotto() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(1, 2, 3, 4, 5, 6),
                new Lotto(2, 3, 4, 5, 6, 7),
                new Lotto(2, 3, 4, 5, 6, 9),
                new Lotto(3, 4, 5, 6, 7, 8),
                new Lotto(4, 5, 6, 7, 8, 9),
                new Lotto(5, 6, 7, 8, 9, 10)
        );
        LottoWinner winner = new LottoWinner(new LottoNumberSet(1, 2, 3, 4, 5, 6), new LottoNumber(7));
        Map<Rank, Amount> rankAmountMap = lottoResultService.checkLotto(lottoList, winner);

        for (Amount amount : rankAmountMap.values()) {
            assertThat(amount).isEqualTo(new Amount(1));
        }
    }

    @DisplayName("로또 수익률을 반환한다.")
    @Test
    void yield() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(4, 5, 6, 7, 8, 9),
                new Lotto(5, 6, 7, 8, 9, 10),
                new Lotto(6, 7, 8, 9, 10, 11),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(7, 8, 9, 10, 11, 12),
                new Lotto(7, 8, 9, 10, 11, 12)
        );
        LottoWinner winner = new LottoWinner(new LottoNumberSet(1, 2, 3, 4, 5, 6), new LottoNumber(7));


        assertThat(lottoResultService.caculateProfitRate(lottoList, winner)).isEqualTo(new ProfitRate(0.50));
    }
}
