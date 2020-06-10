package step2.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    LottoGenerator lottoGenerator;

    private static List<Integer> generate(int count) {
        return Arrays.asList(1, 2, 3, 4, 5, 6);
    }

    @BeforeEach
    void before() {
        lottoGenerator = new LottoGenerator(LottoGeneratorTest::generate);
    }

    @Test
    public void generateLottos() {
        //given
        UserPrice userPrice = new UserPrice(5000);
        UserLotto lottoResult = new UserLotto(Arrays.asList(1, 2, 3, 4, 5, 6));

        //when
        List<UserLotto> lottos = lottoGenerator.generateLottos(userPrice);

        //then
        assertThat(lottos).hasSize(userPrice.getPrice() / 1000);
        assertTrue(lottos.contains(lottoResult));
    }
}