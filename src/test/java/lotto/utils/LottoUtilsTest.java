package lotto.utils;

import lotto.domain.Lotto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoUtilsTest {

    @Test
    void 문자열배열_파싱후_로또리스트() {
        List<Lotto> lottos = Arrays.asList(new Lotto("1, 2, 3, 4, 5, 6"), new Lotto("4, 5, 6, 10, 11, 12"));
        List<Lotto> parsed = LottoUtils.extractLottosFromStrings(new String[]{"1, 2, 3, 4, 5, 6", "4, 5, 6, 10, 11, 12"});
        assertThat(lottos).isEqualTo(parsed);
    }

    @Test
    void create_Lottos() {
        List<Lotto> lottos = LottoUtils.generateLottos(4);
        assertThat(lottos).hasSize(4);
    }
}
