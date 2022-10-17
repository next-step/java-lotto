package lotto.service;

import lotto.domain.Money.Money;
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
                new Lotto(LottoNumberSet.createLottoNumberSet(1, 2, 3, 4, 5, 6)),
                new Lotto(LottoNumberSet.createLottoNumberSet(2, 3, 4, 5, 6, 7)),
                new Lotto(LottoNumberSet.createLottoNumberSet(2, 3, 4, 5, 6, 9)),
                new Lotto(LottoNumberSet.createLottoNumberSet(3, 4, 5, 6, 7, 8)),
                new Lotto(LottoNumberSet.createLottoNumberSet(4, 5, 6, 7, 8, 9)),
                new Lotto(LottoNumberSet.createLottoNumberSet(5, 6, 7, 8, 9, 10)),
                new Lotto(LottoNumberSet.createLottoNumberSet(6, 7, 8, 9, 10, 11)),
                new Lotto(LottoNumberSet.createLottoNumberSet(7, 8, 9, 10, 11, 12))
        );
        LottoWinner winner = new LottoWinner(LottoNumberSet.createLottoNumberSet(1, 2, 3, 4, 5, 6), new LottoNumber(7));

        assertThat(lottoResultService.checkLotto(lottoList, winner))
                .isEqualTo(Map.of(Rank.FIRST, 1,
                        Rank.SECOND, 1,
                        Rank.THIRD, 1,
                        Rank.FOURTH, 1,
                        Rank.FIFTH, 1,
                        Rank.SIXTH, 1,
                        Rank.SEVENTH, 1,
                        Rank.EIGHTH, 1)
                );
    }

    @DisplayName("로또 수익률을 반환한다.")
    @Test
    void yield() {
        List<Lotto> lottoList = Arrays.asList(
                new Lotto(LottoNumberSet.createLottoNumberSet(4, 5, 6, 7, 8, 9)),
                new Lotto(LottoNumberSet.createLottoNumberSet(5, 6, 7, 8, 9, 10)),
                new Lotto(LottoNumberSet.createLottoNumberSet(6, 7, 8, 9, 10, 11)),
                new Lotto(LottoNumberSet.createLottoNumberSet(7, 8, 9, 10, 11, 12))
        );
        LottoWinner winner = new LottoWinner(LottoNumberSet.createLottoNumberSet(1, 2, 3, 4, 5, 6), new LottoNumber(7));


        assertThat(lottoResultService.yield(lottoList, winner, new Money(10000))).isEqualTo(0.5);
    }
}
