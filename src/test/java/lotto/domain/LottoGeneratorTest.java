package lotto.domain;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;
import lotto.domain.Lottos;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoGeneratorTest {
    private static final int LOTTO_SIZE = 6;
    @Test
    void 리스트_셔플() {
        assertThat(LottoGenerator.shuffleLotto()).hasSize(LOTTO_SIZE);
    }

    @Test
    void 로또_생성_숫자() {
        List<Integer> shuffledLotto = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(LottoGenerator.createLotto(shuffledLotto)).isEqualTo(new Lotto(shuffledLotto));
    }

    @Test
    void 로또_생성_문자열() {
        String[] textLotto = {"1", "2", "3", "4", "5", "6"};
        assertThat(LottoGenerator.createLotto(textLotto)).isEqualTo(new Lotto(textLotto));
    }

    @Test
    void 로또들_생성() {
        List<String> textLotto = List.of("1,2,3,4,5,6");
        int autoCount = 1;
        assertThat(LottoGenerator.createLottos(textLotto, autoCount)).isNotNull();
    }

}
