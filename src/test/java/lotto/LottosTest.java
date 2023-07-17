package lotto;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
public class LottosTest {

    @DisplayName("로또 리스트 객체가 정상적으로 생성된다")
    @Test
    void 로또_리스트_객체_생성() {
        List<Integer> list1 = List.of(8, 21, 23, 41, 42, 43);
        List<Integer> list2 = List.of(3, 5, 11, 16, 32, 38);
        List<Integer> list3 = List.of(7, 11, 16, 35, 36, 44);

        Lotto lotto1 = new Lotto(list1);
        Lotto lotto2 = new Lotto(list2);
        Lotto lotto3 = new Lotto(list3);
        List<Lotto> lottos = List.of(lotto1, lotto2, lotto3);

        assertDoesNotThrow(() -> new Lottos(lottos));
    }

}
