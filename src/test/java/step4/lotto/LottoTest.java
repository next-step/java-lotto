package step4.lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step4.lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottoTest {
    private List<Integer> winningLotto ;

    @BeforeEach
    void setUp(){
        winningLotto = Arrays.asList(1,2,3,4,5,6);
    }

    @Test
    void create() {
        assertThatCode(() -> new Lotto(Arrays.asList(1,2,3,4,5,6)))
                .doesNotThrowAnyException();
    }

    @Test
    void 로또번호_4개_생성(){
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1,2,3,4));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또번호_중복(){
        assertThatThrownBy(() -> {
            new Lotto(Arrays.asList(1,2,3,4,4,5));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 로또_6개_일치() {
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

        assertThat(userLotto.match(new Lotto(winningLotto))).isEqualTo(6);
    }


    @Test
    void 로또_5개_일치() {
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,8));
        Lotto winning = new Lotto(winningLotto);
        assertThat(userLotto.match(winning)).isEqualTo(5);
    }

    @Test
    void display() {
        Lotto userLotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        System.out.println(userLotto.toString());
    }
}
