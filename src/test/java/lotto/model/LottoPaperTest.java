package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;

import java.util.Collections;
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
    void 생성() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        assertThat(lottoPaper)
                .isNotNull();
    }

    @Test
    void size는_보유한_Lotto의_개수를_반환한다() {
        Lotto lotto1 = create(1, 2, 3, 4, 5, 6);
        Lotto lotto2 = create(7, 8, 9, 10, 11, 12);
        LottoPaper lottoPaper = new LottoPaper(List.of(lotto1, lotto2));

        assertThat(lottoPaper.size())
                .isEqualTo(2);
    }

    @Test
    void 빈_로또종이의_사이즈는_0개이다() {
        LottoPaper lottoPaper = new LottoPaper(Collections.emptyList());
        assertThat(lottoPaper.size()).isEqualTo(0);
    }

    @Test
    void 로또번호가_모두_일치하는_경우() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        List<LottoNumber> winningNumbers = LottoNumbers.of(1, 2, 3, 4, 5, 6);

        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        assertThat(resultMap.get(6)).isEqualTo(1);
    }

    @Test
    void 로또번호가_모두_일치하지_않는경우() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        List<LottoNumber> winningNumbers = LottoNumbers.of(7, 8, 9, 10, 11, 12);

        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        assertThat(resultMap.get(0)).isEqualTo(1);
    }

    @Test
    void 로또번호가_1개만_일치하는_경우() {
        Lotto lotto = create(1, 2, 3, 4, 5, 6);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        List<LottoNumber> winningNumbers = LottoNumbers.of(1, 8, 9, 10, 11, 12);

        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        assertThat(resultMap.get(1)).isEqualTo(1);
    }
}
