package step3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.lottoTests;
import step3.domain.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {

    @Test
    @DisplayName("로또 숫자 생성")
    void test() {
        Integer Integer = new Integer(3);
        assertThat(Integer).isEqualTo(new Integer(3));
    }

    @Test
    @DisplayName("로또 생성")
    void test1() {
        List<Integer> lotto1 = Arrays.asList(1,2,3,4,5,6);
        Lotto lotto = new Lotto();
        assertThat(lotto).isEqualTo(new Lotto());
    }


    @Test
    @DisplayName("입력 받은 돈에 대한 로또 생성")
    void test2() {
        Lottos lottos = new Lottos(new Price(1000));
        Assertions.assertEquals(lottos.getLottoList().size(), 1);
    }

    @Test
    @DisplayName("로또 개수 확인 테스트")
    void test3() {
        Lotto lotto = new Lotto();
        Assertions.assertEquals(lotto.getLotto().size(), 6);
    }

    @Test
    @DisplayName("입력 받은 로또당첨번호")
    void test4() {
        String input = "1,2,3,4,5,6";
        Assertions.assertEquals(new WinningLotto(input).getWinnerLotto().getLotto().size(), 6);
    }

    @Test
    @DisplayName("당첨 결과 조회")
    void test5() {
        String input = "1,2,3,4,5,6";
        Lotto lotto = new Lotto("1,2,3,4,5,6");
        WinningLotto lotto1 = new WinningLotto("1,2,3,4,5,7");
        //LottoResult lottoResult = new LottoResult();
        //Assertions.assertEquals(lottoResult.match(lotto, lotto1,3), 5);
    }
}
