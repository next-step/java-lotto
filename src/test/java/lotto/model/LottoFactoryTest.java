package lotto.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.model.LottoNumber.toLottoNumberSet;
import static org.assertj.core.api.Assertions.assertThat;

class LottoFactoryTest {

    private LottoFactory generator;

    @BeforeEach
    void setup() {
        generator = new LottoFactory();
    }

    @Test
    @DisplayName("입력수량만큼 로또번호 리스트를 생성한다")
    void lottoList() {
        Lotto buyLotto1 = toLottoNumber(List.of(3, 5, 10, 12, 16, 33));
        Lotto buyLotto2 = toLottoNumber(List.of(4, 6, 10, 11, 13, 18));
        Lotto buyLotto3 = toLottoNumber(List.of(7, 8, 14, 18, 19, 35));

        assertThat(generator.addLotto(10, getManualLotto(buyLotto1, buyLotto2, buyLotto3)).size()).isEqualTo(13);
    }

    private List<Lotto> getManualLotto(Lotto buyLotto1, Lotto buyLotto2, Lotto buyLotto3) {
        return List.of(buyLotto1, buyLotto2, buyLotto3);
    }

    private Lotto toLottoNumber(List<Integer> testLotto) {
        return new Lotto(toLottoNumberSet(testLotto));
    }
}