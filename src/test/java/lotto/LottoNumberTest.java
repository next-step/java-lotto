package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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

    @DisplayName("모든 로또 번호는 1이상 45이하의 번호로 이루어져 있어야 한다.")
    @Test
    public void getAllLottoNumbers_로또_번호는_1이상_45이하() {
        // given, when
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();

        // then
        for (LottoNumber number : allLottoNumbers) {
            assertThat(number.getNumber())
                    .isBetween(1, 45);
        }
    }
}
