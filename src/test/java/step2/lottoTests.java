package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.LottoMoney;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class lottoTests {

    @DisplayName("로또 크기 테스트")
    @Test
    public void test1() {
        Lotto lotto = new Lotto();
        System.out.println(lotto.getInteger());
        assertEquals(lotto.getInteger().size(), 6);
    }

    @DisplayName("돈에 따라 로또 생성하는 개수 테스트")
    @Test
    public void test2() {
        Lottos lottos = new Lottos(14000);
        assertEquals(lottos.getLottos().size(), 14);
    }

    @DisplayName("지난 당첨번호 제대로 나오는지 확인")
    @Test
    public void test4() {
        Lotto lotto = new Lotto("2,1,3,5,4,6");

        assertEquals(lotto.getInteger(),lotto.lastWinner("1,2,3,4,5,6"));
    }

    @DisplayName("지난 당첨번호와 현재 번호가 맞는지 테스트")
    @Test
    public void test3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 7; i++) {
            list.add(i);
        }
        String winner = "1,2,3,4,7,9";
        Lotto lotto = new Lotto(list, winner);

        assertEquals(lotto.getMatchesCount(),4);
    }
}
