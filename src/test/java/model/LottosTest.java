package model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LottosTest {

    @Test
    @DisplayName("로또 합치기")
    void sumLotto() {
        //give // when
        List<Lotto> lottoList01 = new ArrayList<>();
        lottoList01.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43)));
        lottoList01.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottoList01.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottoList01.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 7)));

        List<Lotto> lottoList02 = new ArrayList<>();
        lottoList02.add(new Lotto(Arrays.asList(1, 8, 23, 41, 42, 43)));
        lottoList02.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottoList02.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottoList02.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 7)));

        Lottos allLottos = new Lottos(new Lottos(lottoList01), new Lottos(lottoList02));

        //then
        Assertions.assertThat(allLottos.getLottos().size()).isEqualTo(8);

    }
}