package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottosTest {

    public static Lotto lottoFixture(Integer... numbers) {
        return new Lotto(Arrays.asList(numbers));
    }

    @Test
    @DisplayName("로또 합치기")
    void sumLotto() {
        //give
        List<Lotto> lottoList01 = new ArrayList<>();
        lottoList01.add(lottoFixture(1, 8, 23, 41, 42, 43));
        lottoList01.add(lottoFixture(3, 5, 11, 16, 32, 38));
        lottoList01.add(lottoFixture(7, 11, 16, 35, 36, 44));
        lottoList01.add(lottoFixture(1, 8, 11, 31, 41, 7));

        List<Lotto> lottoList02 = new ArrayList<>();
        lottoList02.add(lottoFixture(1, 8, 23, 41, 42, 44));
        lottoList02.add(lottoFixture(3, 5, 11, 16, 32, 45));
        lottoList02.add(lottoFixture(7, 11, 16, 35, 36, 37));
        lottoList02.add(lottoFixture(1, 8, 11, 31, 41, 42));

        Lottos lottos01 = new Lottos(lottoList01);
        Lottos lottos02 = new Lottos(lottoList02);

        //when
        Lottos allLottos = lottos01.addLottos(lottos02);

        //then
        Assertions.assertThat(allLottos.getLottos()).hasSize(8);

    }
}
