package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.List;
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
    void 당첨번호와_비교하여_당첨등수를_카운팅한다() {
        Lotto lotto1 = create(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = create(7, 8, 9, 10, 11, 12);
        Lotto lotto3 = create(13, 8, 9, 10, 11, 14);
        LottoPaper lottoPaper = new LottoPaper(List.of(lotto1, lotto2, lotto3));

        Prize prize = lottoPaper.matches(new WinningLotto(create(1, 8, 9, 10, 11, 12), new LottoNumber(7)));

        assertThat(prize).isEqualTo(new Prize(new EnumMap<>(Map.of(Rank.NO_MATCH, 1, Rank.FOUR, 1, Rank.TWO, 1))));
    }
}
