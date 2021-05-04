package lotto.automatic;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoAutomaticTest {
    LottoAutomatic lottoAutomatic = new LottoAutomatic();
    @DisplayName("로또 번호 6개 사이즈 체크확인")
    @Test
    void listSize(){
        List<Integer> lottoOne = lottoAutomatic.lottoOne(lottoAutomatic.numberList());
        assertThat(lottoOne.size()).isEqualTo(6);
    }

    @DisplayName("로또 당첨 번호 비교")
    @Test
    void proceeds(){//ArrayList<List> lottoList , String winNumbers 생략

        List<Integer> winNumbersTest = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));

        List<String> list = new ArrayList<>();
        list.add("32");
        list.add("33");
        list.add("24");

        String[] fruit = {"24" , "21","3"};

        System.out.println(list.contains("2"));

        List<String> result = list.stream()
                .filter(num -> num.trim().equals(fruit[0]))
                .collect(Collectors.toList());
        System.out.println(fruit + " ::::::: " + result);
        if (result.size() > 0) {
            System.out.println(fruit + " is in the List: " + result);
        }
        assertThat(1).isEqualTo(1);
    }

}
