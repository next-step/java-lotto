package domain;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

import static org.assertj.core.api.Assertions.assertThat;
public class LottoTest {

    @Test
    public void generateLotto() {
        Lotto lotto = new Lotto(6);

        assertThat(lotto.getNumbers()).hasSize(6);

    }

    @Test
    public void 중복검사(){
        Lotto lotto = new Lotto(6);
        for (Integer number : lotto.getNumbers()){
            assertThat(lotto.getNumbers().stream().filter(obj-> obj.equals(number)).count()).isLessThanOrEqualTo(1);
        }
    }

    @Test
    public void 콜렉션검사(){
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers1 = new ArrayList<>();
        for(int i = 1; i < 46; i++){
            numbers.add(i);
            numbers1.add(i);
        }
        Collections.shuffle(numbers, new Random());
        Collections.shuffle(numbers1, new Random());

        assertThat(numbers).isNotEqualTo(numbers1);

        List<Integer> result = new ArrayList<>();
        for(int i =0; i< 6; i++){
            result.add(numbers.get(i));
        }
//        Collections.sort(result);
        assertThat(numbers.subList(0,6)).isEqualTo(result);


    }

}