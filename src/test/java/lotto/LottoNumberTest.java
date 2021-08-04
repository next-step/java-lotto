package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotSame;

@DisplayName("로또 번호 테스트")
public class LottoNumberTest {

    @DisplayName("모든 로또 번호를 조회할 때 마다, 새로운 컬렉션 객체에 담겨있어야 한다.")
    @Test
    public void getAllLottoNumbers_새로운_컬렉션_객체() {
        // given, when
        List<LottoNumber> firstLottoNumbers = LottoNumber.getAllLottoNumbers();
        List<LottoNumber> secondLottoNumbersTwo = LottoNumber.getAllLottoNumbers();

        // then
        assertNotSame(firstLottoNumbers, secondLottoNumbersTwo);
    }
}
