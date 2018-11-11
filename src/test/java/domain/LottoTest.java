package domain;

import org.junit.Test;
import utils.LottoGenerator;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    public void generateLotto() {
        Lotto lotto = new Lotto(6);

        assertThat(lotto.getNumCount()).isEqualTo(6);

    }

    @Test
    public void 중복검사() {
        List<Integer> num = Arrays.asList(1,2,3,4,5,6);
        assertThat(LottoGenerator.isDuplication(num)).isFalse();
    }

    @Test
    public void 중복발생검사() {
        List<Integer> num = Arrays.asList(1,2,3,4,5,5);
        assertThat(LottoGenerator.isDuplication(num)).isTrue();
    }

    @Test
    public void 콜렉션검사() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> numbers1 = new ArrayList<>();
        for (int i = 1; i < 46; i++) {
            numbers.add(i);
            numbers1.add(i);
        }
        Collections.shuffle(numbers, new Random());
        Collections.shuffle(numbers1, new Random());

        assertThat(numbers).isNotEqualTo(numbers1);

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            result.add(numbers.get(i));
        }
        assertThat(numbers.subList(0, 6)).isEqualTo(result);
    }

    @Test
    public void getCombineCount() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 7);
        Lotto originLotto = new Lotto(numbers);
        Lotto lastLotto = new Lotto(numbers2);
        int combineCount = originLotto.getCombineCount(lastLotto);
        assertThat(combineCount).isEqualTo(5);
    }
}