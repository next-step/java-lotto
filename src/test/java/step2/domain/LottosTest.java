package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottosTest {

    private Lottos lottos;

    @BeforeEach
    void init(){
        lottos = new Lottos();
    }

    @DisplayName("로또 생성를 생성")
    @Test
    void createLotto(){
        int count = 4;

        List<Lotto> lottoList = lottos.createLottoList(count);

        assertThat(lottoList.size()).isEqualTo(4);
    }

    @DisplayName("받은 돈에 따라 만들 로또 갯수를 생성")
    void getLottoCount(){
        int money = 12400;

        int lottoCount = lottos.getLottoCount(money);

        assertThat(lottoCount).isEqualTo(12);
    }
}