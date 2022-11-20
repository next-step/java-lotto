package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    private LottoFactory factory;

    @BeforeEach
    void setup() {
        factory = new LottoFactory(3, new Price(3000));
    }

    @Test
    @DisplayName("입력수량만큼 로또번호 리스트를 생성한다")
    void lottoList() {
        List<String> buyLotto1 = List.of("3", "5", "10", "12", "16", "33");
        List<String> buyLotto2 = List.of("4", "6", "10", "11", "13", "18");
        List<String> buyLotto3 = List.of("7", "8", "14", "18", "19", "35");

        Map<Integer, List<String>> map = new HashMap<>();
        map.put(0, buyLotto1);
        map.put(1, buyLotto2);
        map.put(2, buyLotto3);

        assertThat(factory.addLotto(10, map).size()).isEqualTo(13);
    }
}