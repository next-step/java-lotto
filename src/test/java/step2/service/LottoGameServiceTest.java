package step2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.domain.LottoWinners;
import step2.domain.Lottos;
import step2.domain.Rank;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoGameServiceTest {

    @DisplayName("로또 당첨번호 추출")
    @Test
    void pickLottoNumberOfWeekTest() {
        LottoGameService lottoGameService = new LottoGameService();

        List<Integer> result = lottoGameService.pickLottoNumberOfWeek("10, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(10, 2, 3, 4, 5, 6);
    }

    @DisplayName("로또 당첨번호는 empty 거나 null 이 아니어야 한다")
    @ParameterizedTest
    @NullAndEmptySource
    void pickLottoNumberOfWeekEmptyOrNullTest(String input) {
        assertThatThrownBy(() -> {
            LottoGameService lottoGameService = new LottoGameService();
            List<Integer> result = lottoGameService.pickLottoNumberOfWeek(input);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("로또 당첨번호가 비어있습니다");
    }

    @DisplayName("로또 당첨번호는 6개이다")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "3,2,1", "3,3","1", "1,2,3,4,5,6,7"})
    void pickLottoNumberOfWeekNumberCountTest(String input) {
        assertThatThrownBy(() -> {
            LottoGameService lottoGameService = new LottoGameService();
            List<Integer> result = lottoGameService.pickLottoNumberOfWeek(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("로또 당첨번호는 6개이다");
    }

    @DisplayName("로또 당첨자들 추출")
    @Test
    void matchTest() {
        LottoGameService lottoGameService = new LottoGameService();
        Lottos lottos = new Lottos(3000, new TestPick(Arrays.asList(10, 2, 3, 4, 5, 9)));
        LottoWinners winners = lottoGameService.match(lottos, Arrays.asList(1, 2, 3, 4, 5, 6));

        assertThat(winners.count(Rank.POSTION_3)).isEqualTo(3);
    }
    
    @DisplayName("수익률 테스트")
    @Test
    void moneyRateTest() {
        LottoGameService lottoGameService = new LottoGameService();
        LottoWinners lottoWinners = new LottoWinners();
        lottoWinners.refresh(3);

        double result = lottoGameService.moneyProfitRate(1000, lottoWinners);
        assertThat(result).isEqualTo(20);
    }
}