package lotto.domain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.beans.Transient;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
public class LottoStatisticsTest {

    List<List<Integer>> lottoNumber = new ArrayList<>();
    @BeforeEach
    private void lotto(){
        List<Integer> number = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            number.add(i);
        }
        lottoNumber.add(number);
    }


    @Test
    @DisplayName("로또 당첨번호 포함 여부")
    public void test1(){

        List<Integer> lottoNumber = new ArrayList<>();
        lottoNumber.add(1);
        lottoNumber.add(2);

        LottoStatistics lottoStatistics = new LottoStatistics("1,2,3,4,5,6");
        assertThat(lottoStatistics.sameNumberQuantity(lottoNumber)).isEqualTo(2);
    }

    @Test
    @DisplayName("일치한 로또 COUNT")
    public void test2(){
        Rank.FIRST.addCount();
        assertThat(Rank.FIRST.getCount()).isEqualTo(1);
        Rank.FIRST.addCount();
        assertThat(Rank.FIRST.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("당첨 금액")
    public void test3(){
        LottoStatistics lottoStatistics = new LottoStatistics("1,2,3,4,5,7");
        lottoStatistics.winningRank(lottoNumber);
        assertThat(lottoStatistics.winningAmount()).isEqualTo(1500000);

    }

    @Test
    @DisplayName("로또 수익률")
    public void test4(){
        LottoStatistics lottoStatistics = new LottoStatistics("1,2,3,7,8,9");
        assertThat(lottoStatistics.winningRank(lottoNumber)).isEqualTo(5);
    }

}
