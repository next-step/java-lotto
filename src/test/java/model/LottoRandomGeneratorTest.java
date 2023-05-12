package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoRandomGeneratorTest {
    @Test
    @DisplayName("로또 랜덤 생성시 숫자 범위 테스트")
    void grossTest() {
        //give // when
        LottoRandomGenerator lottoRandomGenerator = new LottoRandomGenerator();
        List<Lotto> lotto = lottoRandomGenerator.generatorLotto(1);

        //then
        boolean expected = false;
        assertEquals(expected, lotto.get(0).getLotto().contains(46));

    }

    @Test
    @DisplayName("로또 랜덤 생성시 갯수 테스트")
    void lottoCount() {
        //given //when
        LottoRandomGenerator lottoRandomGenerator = new LottoRandomGenerator();
        List<Lotto> lottos = lottoRandomGenerator.generatorLotto(3);

        //then
        int expected = 3;

        assertEquals(expected, lottos.size());

    }
}
