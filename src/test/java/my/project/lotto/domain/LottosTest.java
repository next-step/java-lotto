package my.project.lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-23 오후 2:06
 * Developer : Seo
 */
class LottosTest {
    private List<Lotto> lottos;

    @BeforeEach
    void setUp() {
        lottos = new ArrayList<>();
        lottos.add(LottoNumber.generate());
    }

    @Test
    void testConstructor() {
        assertThat(new Lottos(lottos)).isNotNull();
    }

    @Test
    void testSize() {
        assertThat(new Lottos(lottos).size()).isEqualTo(1);
    }

}
