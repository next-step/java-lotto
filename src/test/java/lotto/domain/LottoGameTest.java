package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGameTest {

    WinningLotto winningLotto;
    Lotto myLotto, winningLottoExcludingBonus;
    LottoNumber bonusLottoNumber;

    @BeforeEach
    void setUp() {
        myLotto = new Lotto(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                ).collect(Collectors.toSet()));

        winningLottoExcludingBonus = new Lotto(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(45)
                ).collect(Collectors.toSet()));

        bonusLottoNumber = new LottoNumber(6);

        winningLotto = new WinningLotto(winningLottoExcludingBonus, bonusLottoNumber);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void 수익_계산(int matchCount, long reward) {
        assertThat(LottoGame.reward(matchCount)).isEqualTo(reward);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7})
    void 번호_일치_개수_예외(int matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGame.reward(matchCount))
                .withMessageContaining("당첨에 해당하는 번호 일치 개수가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "0:0"}, delimiter = ':')
    void 구입_매수_계산(long price, long lottoCount) {
        assertThat(LottoGame.lottoCount(price)).isEqualTo(lottoCount);
    }

    @Test
    void 총_수익_계산() {
        //given
        List<Lotto> lottoList = Arrays.asList(myLotto, myLotto);

        //when
        LottoRewards reward = LottoGame.reward(lottoList, winningLotto);

        //then
        assertThat(reward.totalProfit()).isEqualTo(60000000L);
    }

    @Test
    void 총_수익률_계산() {
        //given
        List<Lotto> lottoList = Arrays.asList(myLotto, myLotto);
        long purchasePrice = 2000l;

        //when
        LottoRewards reward = LottoGame.reward(lottoList, winningLotto);

        //then
        assertThat(LottoGame.totalProfitRate(reward, purchasePrice)).isEqualTo(30000);
    }

    @Test
    void 일치_수별_횟수_세기() {
        //given
        List<Lotto> lottoList = Arrays.asList(myLotto, winningLottoExcludingBonus);

        //when
        LottoRewards reward = LottoGame.reward(lottoList, winningLotto);

        //then
        assertThat(reward.get(RewardType.FIVE_AND_BONUS).count()).isEqualTo(1);
        assertThat(reward.get(RewardType.SIX).count()).isEqualTo(1);
    }

    @Test
    void 당첨번호_5개_일치_보너스번호_일치() {
        //given
        List<Lotto> lottoList = Arrays.asList(myLotto);

        //when
        LottoRewards reward = LottoGame.reward(lottoList, winningLotto);

        //then
        assertThat(reward.get(RewardType.FIVE_AND_BONUS).count()).isEqualTo(1);
    }
}
