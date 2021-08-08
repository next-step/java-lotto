package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("로또 테스트")
public class LottoTest {

    @DisplayName("로또의 번호 개수는 6개이어야 한다.")
    @Test
    public void lottoNumberCountTest() {
        // given
        List<LottoNumber> lottoNumbers = new Lotto(new RandomLottoNumberGenerating()).getNumbers();

        // when, then
        assertEquals(lottoNumbers.size(), 6);
    }

    @DisplayName("로또 번호는 중복되지 않은 번호로 이루어져 있어야 한다.")
    @Test
    public void nonDuplicatedLottoNumbersTest() {
        // given
        List<LottoNumber> lottoNumbers = new Lotto(new RandomLottoNumberGenerating()).getNumbers();

        // when
        Set<LottoNumber> nonDuplicatedLottoNumbers = new HashSet<>(lottoNumbers);

        // then
        assertEquals(lottoNumbers.size(), nonDuplicatedLottoNumbers.size());
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어 있어야 한다.")
    @Test
    public void sortedLottoNumbersTest() {
        // given
        Lotto lotto = new Lotto(new RandomLottoNumberGenerating());

        // when
        List<LottoNumber> sortedLottoNumbers = new ArrayList<>();
        for (LottoNumber lottoNumber : lotto.getNumbers()) {
            sortedLottoNumbers.add(lottoNumber);
        }
        Collections.sort(sortedLottoNumbers);

        // then
        assertThat(lotto.getNumbers())
                .containsExactlyElementsOf(sortedLottoNumbers);
    }

    @DisplayName("같은 당첨 로또 번호의 개수를 찾는 기능이 정상 동작해야 한다.")
    @Test
    public void findEqualNumberCountTest() {
        // given
        Lotto lotto = new Lotto(() -> LottoNumber.getAllLottoNumbers()
                .subList(0, 6));

        WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(4, 5, 6, 7, 8, 9));

        // when, then
        assertEquals(lotto.findEqualNumberCount(winningNumbers), 3);
    }

    @DisplayName("로또 번호 포함 여부 기능이 정상 동작해야 한다.")
    @Test
    public void containsTest() {
        // given
        Lotto lotto = new Lotto(() -> LottoNumber.getAllLottoNumbers()
                .subList(0, 6));

        // when, then
        assertTrue(lotto.contains(LottoNumber.valueOf(1)));
        assertTrue(lotto.contains(LottoNumber.valueOf(6)));
        assertFalse(lotto.contains(LottoNumber.valueOf(7)));
    }
}
