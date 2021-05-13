package lotto.automatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoAutomaticTest {
    LottoAutomatic lottoAutomatic = new LottoAutomatic();
    @DisplayName("로또 번호 6개 사이즈 체크확인")
    @Test
    void listSize(){
        List<Integer> lottoOne = lottoAutomatic.lottoOne(lottoAutomatic.numberList());
        assertThat(lottoOne.size()).isEqualTo(6);
    }


    @DisplayName("지난주 로또 당첨 번호 리스트")
    @Test
    void winningNumberListTest(){


    }


    @DisplayName("등수 확인")
    @Test
    void number(){

        assertAll("calculator",
                ()-> assertEquals(Rank.getRank(6,true),Rank.FIRST),
                ()-> assertEquals(Rank.getRank(5,true),Rank.SECOND),
                ()-> assertEquals(Rank.getRank(5,false),Rank.THIRD),
                ()-> assertEquals(Rank.getRank(4,true),Rank.FOURTH),
                ()-> assertEquals(Rank.getRank(3,true),Rank.FIFTH),
                ()-> assertEquals(Rank.getRank(2,true),Rank.MISS),
                ()-> assertEquals(Rank.getRank(1,true),Rank.MISS),
                ()-> assertEquals(Rank.getRank(0,true),Rank.MISS)
        );
    }


}
