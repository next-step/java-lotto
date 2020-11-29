package my.project.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created : 2020-11-27 오전 9:55
 * Developer : Seo
 */
class LottoTest {

    @DisplayName("6개의 번호여야 한다.")
    @Test
    void shouldHaveParamSixDigit_OtherwiseThrowException() {
        List<LottoNumber> lotto = new ArrayList<>();
        lotto.add(new LottoNumber(1));
        lotto.add(new LottoNumber(2));
        lotto.add(new LottoNumber(3));
        lotto.add(new LottoNumber(4));
        lotto.add(new LottoNumber(5));
        assertThatThrownBy(() -> new Lotto(lotto))
                .hasMessage("로또 한 장은 6개 번호입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 번호가 있어선 안된다.")
    @Test
    void shouldNotBeDuplicated() {
        List<LottoNumber> lotto = new ArrayList<>();
        lotto.add(new LottoNumber(1));
        lotto.add(new LottoNumber(2));
        lotto.add(new LottoNumber(3));
        lotto.add(new LottoNumber(4));
        lotto.add(new LottoNumber(5));
        lotto.add(new LottoNumber(5));
        assertThatThrownBy(() -> new Lotto(lotto))
                .hasMessage("로또 한 장은 6개 번호입니다.")
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testConstructor() {
        List<LottoNumber> lotto = new ArrayList<>();
        lotto.add(new LottoNumber(1));
        lotto.add(new LottoNumber(2));
        lotto.add(new LottoNumber(3));
        lotto.add(new LottoNumber(4));
        lotto.add(new LottoNumber(5));
        lotto.add(new LottoNumber(6));
        assertThat(lotto).isNotNull();
    }

    @Test
    void testMatch() {
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(2));
        list.add(new LottoNumber(3));
        list.add(new LottoNumber(4));
        list.add(new LottoNumber(5));
        list.add(new LottoNumber(6));
        Lotto lotto = new Lotto(list);

        List<LottoNumber> winning = new ArrayList<>();
        winning.add(new LottoNumber(1));
        winning.add(new LottoNumber(2));
        winning.add(new LottoNumber(3));
        winning.add(new LottoNumber(4));
        winning.add(new LottoNumber(5));
        winning.add(new LottoNumber(6));
        Lotto winningLotto = new Lotto(winning);
        assertThat(lotto.match(winningLotto, new LottoNumber(7))).isEqualTo(Rank.FIRST);
    }

    @Test
    void testMatch_2nd() {
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(2));
        list.add(new LottoNumber(3));
        list.add(new LottoNumber(4));
        list.add(new LottoNumber(5));
        list.add(new LottoNumber(7));
        Lotto lotto = new Lotto(list);

        List<LottoNumber> winning = new ArrayList<>();
        winning.add(new LottoNumber(1));
        winning.add(new LottoNumber(2));
        winning.add(new LottoNumber(3));
        winning.add(new LottoNumber(4));
        winning.add(new LottoNumber(5));
        winning.add(new LottoNumber(6));
        Lotto winningLotto = new Lotto(winning);
        assertThat(lotto.match(winningLotto, new LottoNumber(7))).isEqualTo(Rank.SECOND);
    }

    @Test
    void testContains() {
        List<LottoNumber> list = new ArrayList<>();
        list.add(new LottoNumber(1));
        list.add(new LottoNumber(2));
        list.add(new LottoNumber(3));
        list.add(new LottoNumber(4));
        list.add(new LottoNumber(5));
        list.add(new LottoNumber(7));
        Lotto lotto = new Lotto(list);
        assertThat(lotto.contains(new LottoNumber(1))).isTrue();
    }

}