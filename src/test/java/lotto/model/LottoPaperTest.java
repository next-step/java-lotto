package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.EnumMap;
import java.util.Map;

import static lotto.model.LottoFactory.create;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPaperTest {

    @Test
    void 생성자에_null넘길경우_예외를_던진다() {
        assertThatThrownBy(() -> new LottoPaper(null))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 생성() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        assertThat(lottoPaper)
                .isNotNull();
    }

    @Test
    void 로또번호가_모두_일치하는_경우() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        Prize prize = lottoPaper.matches(new WinningLotto(create(1, 2, 3, 4, 5, 6), new LottoNumber(7)));

        assertThat(prize).isEqualTo(new Prize(new EnumMap<>(Map.of(Rank.ONE, 1))));
    }

    @Test
    void 로또번호가_모두_일치하지_않는경우() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        Prize prize = lottoPaper.matches(new WinningLotto(create(7, 8, 9, 10, 11, 12), new LottoNumber(13)));

        assertThat(prize).isEqualTo(new Prize(new EnumMap<>(Map.of(Rank.NO_MATCH, 1))));
    }

    @Test
    void 로또번호가_1개만_일치하는_경우() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        Prize prize = lottoPaper.matches(new WinningLotto(create(1, 8, 9, 10, 11, 12), new LottoNumber(13)));

        assertThat(prize).isEqualTo(new Prize(new EnumMap<>(Map.of(Rank.NO_MATCH, 1))));
    }
}
