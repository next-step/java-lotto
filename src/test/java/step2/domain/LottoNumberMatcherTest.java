package step2.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoNumberMatcherTest {
    List<List<Integer>> lottoNumbers = new ArrayList<>();
    String[] winningLottoNumbers = new String[]{"1", "2", "3", "4", "5", "6"};
    String[] doubleWinningLottoNumbers = new String[]{"1", "2", "3", "10","11","13"};
    private static final int FOURTH_PRIZE = 5000;
    private static final int THIRD_PRIZE = 50000;
    private static final int SECOND_PRIZE = 1500000;
    private static final int FIRST_PRIZE = 2000000000;

    @BeforeEach
    void setUp() {
        lottoNumbers.add(Arrays.asList(1, 2, 3, 7, 8, 9));
        lottoNumbers.add(Arrays.asList(10,11,13,15,17,18));
    }

    @DisplayName("두개의 로또가 당첨되는 경우 테스트")
    @Test
    void doubleWinningLottoNumbersTest(){
        LottoNumberMatcher.getNumberMatch(doubleWinningLottoNumbers, lottoNumbers);
        HashMap<Integer, Integer> ranks = LottoNumberMatcher.getEachPrizeMoney();
        assertThat(ranks.get(FOURTH_PRIZE)).isEqualTo(2);
        assertThat(ranks.get(THIRD_PRIZE)).isEqualTo(0);
        assertThat(ranks.get(SECOND_PRIZE)).isEqualTo(0);
        assertThat(ranks.get(FIRST_PRIZE)).isEqualTo(0);
    }

    @DisplayName("Rank에 따른 개수 가져오기 테스트")
    @Test
    void countOfEachRanks() {
        LottoNumberMatcher.getNumberMatch(winningLottoNumbers, lottoNumbers);
        HashMap<Integer, Integer> ranks = LottoNumberMatcher.getEachPrizeMoney();
        assertThat(ranks.get(FOURTH_PRIZE)).isEqualTo(1);
        assertThat(ranks.get(THIRD_PRIZE)).isEqualTo(0);
        assertThat(ranks.get(SECOND_PRIZE)).isEqualTo(0);
        assertThat(ranks.get(FIRST_PRIZE)).isEqualTo(0);
    }

    @DisplayName("총 당첨 금액 테스트")
    @Test
    void getLottoRateOfReturn() {
        LottoNumberMatcher.getNumberMatch(winningLottoNumbers, lottoNumbers);
        LottoNumberMatcher.getEachPrizeMoney();
        int sum = LottoNumberMatcher.sumOfTotalPrizeMoney();
        assertThat(sum).isEqualTo(FOURTH_PRIZE);

    }

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(ints = 14000)
    void countOfMathRanks(int money) {
        LottoNumberMatcher.getNumberMatch(winningLottoNumbers, lottoNumbers);
        assertThat(LottoNumberMatcher.getLottoRateOfReturn(money)).isEqualTo("0.35");
    }
}
