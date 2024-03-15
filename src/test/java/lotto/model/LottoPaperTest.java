package lotto.model;

import lotto.exception.InvalidLottoException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPaperTest {

    @Test
    void nullCheck() {
        assertThatThrownBy(() -> new LottoPaper(null))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void create() {
        List<LottoNumber> selectedNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto = new Lotto(selectedNumbers);
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(lotto));

        assertThat(lottoPaper)
                .isNotNull();
    }

    @Test
    void size() {
        List<LottoNumber> selectedNumbers1 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        List<LottoNumber> selectedNumbers2 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Lotto lotto1 = new Lotto(selectedNumbers1);
        Lotto lotto2 = new Lotto(selectedNumbers2);
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
    void 인덱스를_지정하면_로또번호를_문자열로_확인할수있다() {
        String expected = "[1, 2, 3, 4, 5, 6]";
        List<LottoNumber> selectedNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        LottoPaper lottoPaper = new LottoPaper(List.of(new Lotto(selectedNumbers)));
        String actual = lottoPaper.toStringLotto(0);

        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 2})
    void 잘못된_인덱스로_로또번호_조회시_예외를_던진다(int given) {
        List<LottoNumber> selectedNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        LottoPaper lottoPaper = new LottoPaper(List.of(new Lotto(selectedNumbers)));

        assertThatThrownBy(() -> lottoPaper.toStringLotto(given))
                .isInstanceOf(InvalidLottoException.class);
    }

    @Test
    void 로또번호가_모두_일치하는_경우() {
        List<LottoNumber> selectedNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(new Lotto(selectedNumbers)));

        List<LottoNumber> winningNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));

        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        assertThat(resultMap.get(6)).isEqualTo(1);
    }

    @Test
    void 로또번호가_모두_일치하지_않는경우() {
        List<LottoNumber> selectedNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(new Lotto(selectedNumbers)));

        List<LottoNumber> winningNumbers = Arrays.asList(new LottoNumber(7), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12));

        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        assertThat(resultMap.get(0)).isEqualTo(1);
    }

    @Test
    void 로또번호가_1개만_일치하는_경우() {
        List<LottoNumber> selectedNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoPaper lottoPaper = new LottoPaper(Collections.singletonList(new Lotto(selectedNumbers)));

        List<LottoNumber> winningNumbers = Arrays.asList(new LottoNumber(1), new LottoNumber(8), new LottoNumber(9),
                new LottoNumber(10), new LottoNumber(11), new LottoNumber(12));

        Map<Integer, Integer> resultMap = lottoPaper.matches(winningNumbers);

        assertThat(resultMap.get(1)).isEqualTo(1);
    }
}
