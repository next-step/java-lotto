package step4.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    @DisplayName("두가지 로또번호 리스트를 합쳐서 Lottos로 return 해주는 정적 팩토리메소드 테스트")
    @Test
    void CombineTest() {
        Lotto firstLotto = Lotto.of("1,2,3,4,5,6");
        Lotto secondLotto = Lotto.of("40,41,42,43,44,45");

        List<Lotto> firstLottos = Arrays.asList(firstLotto);
        List<Lotto> secondLottos = Arrays.asList(secondLotto);

        Lottos lottos = Lottos.of(firstLottos, secondLottos);

        Assertions.assertTrue(lottos.getLottos().contains(firstLotto));
        Assertions.assertTrue(lottos.getLottos().contains(secondLotto));
    }

    @DisplayName("String list를 lottos로 return 해주는 정적 팩토리메소드 테스트")
    @Test
    void stringListToLottos() {
        String firstLotto = "1,2,3,4,5,6";
        String secondLotto = "11,12,13,14,15,16";

        List<String> stringLottos = Arrays.asList(firstLotto, secondLotto);

        Lottos lottos = Lottos.of(stringLottos);

        Assertions.assertTrue(lottos.getLottos().contains(Lotto.of(firstLotto)));
        Assertions.assertTrue(lottos.getLottos().contains(Lotto.of(secondLotto)));
    }
}