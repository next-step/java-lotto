package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 테스트")
public class LottoTest {

    @DisplayName("로또의 번호 개수는 6개이어야 한다.")
    @Test
    public void lottoNumberCountTest() {
        // given
        Lotto lotto = new Lotto();

        // when, then
        assertEquals(lotto.getNumbersSize(), 6);
    }

    @DisplayName("로또 번호는 중복되지 않은 번호로 이루어져 있어야 한다.")
    @Test
    public void nonDuplicatedLottoNumbersTest() {
        // given
        Lotto lotto = new Lotto();

        // when
        Set<LottoNumber> lottoNumbers = new HashSet<>(lotto.getNumbers());

        // then
        assertEquals(lotto.getNumbersSize(), lottoNumbers.size());
    }

    @DisplayName("로또 번호는 오름차순으로 정렬되어 있어야 한다.")
    @Test
    public void sortedLottoNumbersTest() {
        // given
        Lotto lotto = new Lotto();

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
}
