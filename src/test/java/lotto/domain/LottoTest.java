package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    LottoNumbers myLottoNumbers, winningLottoNumbers;

    @BeforeEach
    void setUp() {
        myLottoNumbers = new LottoNumbers(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(4), new LottoNumber(5), new LottoNumber(6)
                ).collect(Collectors.toSet()));

        winningLottoNumbers = new LottoNumbers(
                Stream.of(
                        new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                        new LottoNumber(43), new LottoNumber(44), new LottoNumber(45)
                ).collect(Collectors.toSet()));
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void 수익_계산(int matchCount, long reward) {
        assertThat(Lotto.reward(matchCount)).isEqualTo(reward);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7})
    void 번호_일치_개수_예외(int matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.reward(matchCount))
                .withMessageContaining("당첨에 해당하는 번호 일치 개수가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "0:0"}, delimiter = ':')
    void 구입_매수_계산(long price, long lottoCount) {
        assertThat(Lotto.lottoCount(price)).isEqualTo(lottoCount);
    }

    @Test
    void 총_수익_계산() {
        //given
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(myLottoNumbers);
        lottoNumbersList.add(myLottoNumbers);

        //when
        LottoRewards reward = Lotto.reward(lottoNumbersList, winningLottoNumbers);

        //then
        assertThat(reward.totalProfit()).isEqualTo(10000L);
    }

    @Test
    void 일치_수별_횟수_세기() {
        //given
        List<LottoNumbers> lottoNumbersList = new ArrayList<>();
        lottoNumbersList.add(myLottoNumbers);
        lottoNumbersList.add(winningLottoNumbers);

        //when
        LottoRewards lottoRewards = Lotto.reward(lottoNumbersList, winningLottoNumbers);

        //then
        assertThat(lottoRewards.get(RewardType.THREE).count()).isEqualTo(1);
        assertThat(lottoRewards.get(RewardType.SIX).count()).isEqualTo(1);
    }
}
