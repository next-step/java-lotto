package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("로또 번호 테스트")
public class LottoNumberTest {

    @DisplayName("모든 로또 번호를 조회할 때 마다, 새로운 컬렉션 객체에 담겨있어야 한다.")
    @Test
    public void getAllLottoNumbers_새로운_컬렉션_객체() {
        // given, when
        List<LottoNumber> firstAllLottoNumbers = LottoNumber.getAllLottoNumbers();
        List<LottoNumber> secondAllLottoNumbers = LottoNumber.getAllLottoNumbers();

        // then
        assertNotSame(firstAllLottoNumbers, secondAllLottoNumbers);
    }

    @DisplayName("모든 로또 번호를 조회할 때 마다, 로또 번호 객체는 재사용되어야 한다.")
    @Test
    public void getAllLottoNumbers_로또_번호_객체_재사용() {
        // given, when
        List<LottoNumber> firstAllLottoNumbers = LottoNumber.getAllLottoNumbers();
        List<LottoNumber> secondAllLottoNumbers = LottoNumber.getAllLottoNumbers();

        // then
        for (int i = 0; i < firstAllLottoNumbers.size(); i++) {
            assertSame(firstAllLottoNumbers.get(i), secondAllLottoNumbers.get(i));
        }
    }
}
