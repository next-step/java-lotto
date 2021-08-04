package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("로또 테스트")
public class LottoTest {

    @DisplayName("로또의 번호 개수는 6개이어여 한다.")
    @Test
    public void lottoNumberCountTest() {
        // given, when
        Lotto lotto = new Lotto();

        // then
        assertEquals(lotto.getNumbersSize(), 6);
    }

    @DisplayName("로또 번호는 중복되지 않은 번호로 이루어져 있다.")
    @Test
    public void nonDuplicatedLottoNumbersTest() {
        // given, when
        Lotto lotto = new Lotto();

        // then
        Set<LottoNumber> lottoNumbers = new HashSet<>(lotto.getNumbers());
        assertEquals(lotto.getNumbersSize(), lottoNumbers.size());
    }
}
