package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import java.util.Collections;

import static lotto.model.LottoFactory.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @Test
    void 초기화시_빈리스트를_넘기면_예외를_던진다() {
        assertThatThrownBy(() -> new Lotto(Collections.emptyList()))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 로또번호는_6개만_선택가능하다() {
        assertThatThrownBy(() -> create(1, 2, 3, 4, 5))
                .isInstanceOf(InvalidLottoException.class);
        assertThatThrownBy(() -> create(1, 2, 3, 4, 5, 6, 7))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 로또번호를_선택할때_중복번호_없이_6개를_선택해야한다() {
        assertThatThrownBy(() -> create(1, 1, 1, 4, 5, 6))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 여러개의_번호를_로또번호와_매칭한다() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        Rank actual = lotto.match(create(1, 2, 3, 4, 5, 6));

        assertThat(actual).isEqualTo(Rank.ONE);
    }

    @Test
    void 여러개의_번호를_매치할때_null_넘기면_예외를_던진다() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lotto.match(null))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 여러개의_번호를_매치할때_일차하는_볼이_없는경우_NO_MATCH반환한다() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        Rank actual = lotto.match(create(7, 8, 9, 10, 11, 12));

        assertThat(actual).isEqualTo(Rank.NO_MATCH);
    }

    @Test
    void 중복번호를_매칭할경우_예외를_반환한다() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);

        assertThatThrownBy(() -> lotto.match(create(1, 1, 1, 1, 1, 1)))
                .isInstanceOf(InvalidLottoException.class)
                .hasMessage("중복을 제외한 6개의 로또 번호가 필요합니다");
    }
}
