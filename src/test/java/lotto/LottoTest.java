package lotto;

import lotto.domain.Lotto;
import lotto.domain.MatchInfo;
import lotto.domain.MyLotto;
import lotto.domain.PrizeResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @DisplayName("로또 1장 가격 1000원 및 금액에 해당하는 로또 발급 여부 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {14000, 8000, 999, 2000})
    void lottoCountTest(int money){
        MyLotto myLotto = new MyLotto(money);
        assertThat(myLotto.getLottoList().size()).isEqualTo(money/LOTTO_PRICE);
    }

    @DisplayName("로또 중복 번호 존재 유무 테스트")
    @RepeatedTest(value = 10)
    void lottoNumberDuplicateTest(){
        Lotto lotto = new Lotto();
        assertThat(new HashSet<>(lotto.getLottoNumberList()).size()).isEqualTo(LOTTO_NUMBER_COUNT);
    }

    @DisplayName("로또 번호 오름차순 정렬 유무 테스트")
    @RepeatedTest(value = 10)
    void lottoNumberSortingTest(){
        Lotto lotto = new Lotto();
        List<Integer> lottoNumberList = lotto.getLottoNumberList();
        assertThat(lottoNumberList).allSatisfy(val ->{
            int idx = lottoNumberList.indexOf(val);
            assertThat(Collections.max(lottoNumberList.subList(0, idx+1))).isEqualTo(val);
        });
    }

    @DisplayName("로또 당첨 통계 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    void lottoMatchTest(int matchCount){
        Lotto lotto = new Lotto();
        List<Integer> winningNumbers = Arrays.asList(0, 0, 0, 0, 0, 0);
        for(int i=0; i<matchCount; i++){
            winningNumbers.set(i, lotto.getLottoNumberList().get(i));
        }
        assertThat(MatchInfo.checkMatch(lotto.getMatchCount(winningNumbers)))
                .isEqualTo(MatchInfo.checkMatch(matchCount));
    }

    @DisplayName("로또 수익률 테스트")
    @ParameterizedTest()
    @ValueSource(ints = {14000, 8000, 999, 2000})
    void lottoEarnRateTest(int inputMoney){
        List<MatchInfo> matchInfoList = new ArrayList<>();
        PrizeResult prizeResult = new PrizeResult();
        for(int i=0; i<inputMoney/1000; i++){
            int rand = (int) (Math.random()*7);
            MatchInfo matchInfo = MatchInfo.checkMatch(rand);
            matchInfoList.add(matchInfo);
            prizeResult.addPrizeResult(matchInfo);
        }

        int reward = matchInfoList.stream()
                .mapToInt(MatchInfo::getReward)
                .sum();

        assertThat(prizeResult.getEarnRate(inputMoney)).isEqualTo((double) (reward/inputMoney));
    }
}
