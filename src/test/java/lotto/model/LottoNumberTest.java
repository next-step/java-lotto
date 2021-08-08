package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
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
    public void getAllLottoNumbers_모든_로또_번호_조회시_객체_재사용() {
        // given, when
        List<LottoNumber> firstAllLottoNumbers = LottoNumber.getAllLottoNumbers();
        List<LottoNumber> secondAllLottoNumbers = LottoNumber.getAllLottoNumbers();

        // then
        for (int i = 0; i < firstAllLottoNumbers.size(); i++) {
            assertSame(firstAllLottoNumbers.get(i), secondAllLottoNumbers.get(i));
        }
    }

    @DisplayName("로또 번호를 생성할 때, 로또 번호 객체는 재사용되어야 한다.")
    @Test
    public void getAllLottoNumbers_로또_번호_생성시_객체_재사용() {
        // given, when
        LottoNumber firstLottoNumber = LottoNumber.valueOf(1);
        LottoNumber secondLottoNumber = LottoNumber.valueOf(1);

        // then
        assertSame(firstLottoNumber, secondLottoNumber);
    }

    @DisplayName("모든 로또 번호는 1이상 45이하의 번호로 이루어져 있어야 한다.")
    @Test
    public void getAllLottoNumbers_로또_번호는_1이상_45이하() {
        // given, when
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();
        LottoNumber firstLottoNumber = new LottoNumber(1);
        LottoNumber lastLottoNumber = new LottoNumber(45);

        // then
        for (LottoNumber number : allLottoNumbers) {
            assertThat(number)
                    .isBetween(firstLottoNumber, lastLottoNumber);
        }
    }

    @DisplayName("모든 로또 번호는 45개 번호로 이루어져 있어야 한다.")
    @Test
    public void getAllLottoNumbers_로또_번호는_45개() {
        // given, when
        List<LottoNumber> allLottoNumbers = LottoNumber.getAllLottoNumbers();

        // then
        assertEquals(allLottoNumbers.size(), 45);
    }

    @DisplayName("LottoNumber.class의 compareTo() 메소드는 로또 번호를 비교한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:1:0", "1:2:-1", "3:1:1", "2:3:-1"}, delimiter = ':')
    public void compareToLottoNumberTest(int number, int otherNumber, int result) {
        // given
        LottoNumber lottoNumber = new LottoNumber(number);
        LottoNumber otherLottoNumber = new LottoNumber(otherNumber);

        // when, then
        assertEquals(lottoNumber.compareTo(otherLottoNumber), result);
    }

    @DisplayName("로또 번호 생성시, 1이상 45 이하의 번호가 아니면 Exception이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void createOutOfBoundsLottoNumberExceptionTest(int number) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new LottoNumber(number))
                .withMessage("로또 번호는 1이상 45이하의 숫자이어야 합니다.");
    }

    @DisplayName("로또 번호 조회시, 1이상 45 이하의 번호가 아니면 Exception이 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void getOutOfBoundsLottoNumberExceptionTest(int number) {
        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoNumber.valueOf(number))
                .withMessage("로또 번호는 1이상 45이하의 숫자이어야 합니다.");
    }
}
