package lotto.domain;

import static lotto.util.Constant.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.EnumMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    private Lotto lotto;

    @BeforeEach
    void setUp() {
        lotto = new Lotto(10000);
    }

//    @Test
//    void 로또숫자들은_1부터45까지의_중복되지_않은_6개의_수들이다() {
//        List<Integer> lottoNumbers = lotto.generateRandoms();
//        long given = lottoNumbers.stream().distinct().count();
//        assertThat(given).isEqualTo(LOTTO_SIZE);
//    }
//
//    @ValueSource(ints = {2, 3, 4})
//    @ParameterizedTest
//    void 구입금액에_맞는_로또를_발급한다(int number) {
//        List<LottoTicket> generatedTickets = lotto.generateLottoTickets(number);
//        int given = generatedTickets.size();
//        assertThat(given).isEqualTo(number);
//    }
//
//    @Test
//    void 로또넘버중_당첨넘버와_일치하는_수에_따라_당첨결과가_나온다_1등() {
//        final LottoTicket lottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
//        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6),
//            40);
//
//        LottoRank given = lotto.compareWithWinning(lottoNumbers, winningNumbers);
//        assertThat(given).isEqualTo(LottoRank.FIRST);
//    }
//
//    @Test
//    void 로또넘버중_당첨넘버와_일치하는_수에_따라_당첨결과가_나온다_2등() {
//        final LottoTicket lottoNumbers = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
//        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7),
//            6);
//
//        LottoRank given = lotto.compareWithWinning(lottoNumbers, winningNumbers);
//        assertThat(given).isEqualTo(LottoRank.SECOND);
//    }

    // TODO :: 랜덤 값에 대한 테스트 처리 질문
    /*
    @Test
    void 티켓의_등수별_당첨결과를_반환한다() {
        lotto.generateLottoTickets(4);
        final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 7),
            6);
        Map<LottoRank, Integer> result = lotto.getWinningResult(winningNumbers);
    }
     */

//    @Test
//    void 당첨결과에_따라_수익률을_구한다() {
//        Map<LottoRank, Integer> map = new EnumMap<>(LottoRank.class);
//        map.put(LottoRank.THIRD, 1);
//        map.put(LottoRank.FOURTH, 1);
//        map.put(LottoRank.FIFTH, 1);
//        final int price = 10000;
//
//        double profit = lotto.getProfit(price);
//        assertThat(profit).isEqualTo(155.50);
//    }
}