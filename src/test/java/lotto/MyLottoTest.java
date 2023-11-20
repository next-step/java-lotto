package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {

    @Test
    @DisplayName("당첨 번호가 N개 일치하는 로또 개수를 반환한다.")
    void 당첨_번호가_N개_일치하는_로또_개수(){
        MyLottos myLottos = new MyLottos(List.of(
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(2,3,7,8,9,10)),
                new Lotto(Arrays.asList(8,9,10,11,12,13))
        ));
        List<Integer> winningNumbers = Arrays.asList(4,5,6,7,8,9,10);
        Map<Integer, Integer> myMatchResult = myLottos.myMatchResult(winningNumbers);

        assertThat(myMatchResult.get(3)).isEqualTo(2);
        assertThat(myMatchResult.get(4)).isEqualTo(1);
    }
}
