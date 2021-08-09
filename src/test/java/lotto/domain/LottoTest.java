package lotto.domain;

import lotto.util.LottoListGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    private List<LottoNumber> winnerNumbers = new ArrayList<>();
    private List<LottoNumber> lottoNumberList = new ArrayList<>();
    private Lotto randomLotto;
    private Lotto sortedLotto;

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
        IntStream.rangeClosed(1, 6).forEach(number -> lottoNumberList.add(new LottoNumber(number)));
        randomLotto = new Lotto(LottoListGenerator.createLottoNumbers());
        sortedLotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("생성한 로또의 숫자의 개수가 6임을 확인한다")
    void size() {
        assertThat(randomLotto.getNumbers().size()).isEqualTo(Lotto.SIZE);
        assertThat(sortedLotto.getNumbers().size()).isEqualTo(Lotto.SIZE);
    }

    @Test
    @DisplayName("랜덤 로또를 생성했을 때 각 숫자들은 최소숫자 1 이상, 최대숫자 45 이하임을 확인한다.")
    void lottoWithMixStrategy() {
        List<LottoNumber> lottoNumbers = randomLotto.getNumbers();
        for (LottoNumber lottoNumber : lottoNumbers) {
            assertThat(lottoNumber.getLottoNumber()).isGreaterThanOrEqualTo(LottoNumber.MIN_NUMBER);
            assertThat(lottoNumber.getLottoNumber()).isLessThanOrEqualTo(LottoNumber.MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("정렬 로또를 생성했을 때 각 숫자들은 1부터 6임을 확인한다.")
    void lottoWithSortStrategy() {
        List<LottoNumber> lottoNumbers = sortedLotto.getNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            LottoNumber number = new LottoNumber(i + 1);
            assertEquals(lottoNumbers.get(i), number);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,7,8:THIRD", "1,2,3,7,8,9:FOURTH", "1,2,7,8,9,10:BANG", "1,7,8,9,10,11:BANG", "7,8,9,10,11,12:BANG"},
            delimiter = ':')
    @DisplayName("1~6까지의 로또에 대하여 winnerNumbers를 지정하여 1등 ~ 6등까지의 당첨을 확인한다.")
    void drawLottoFirstAward(String winnerNumberString, String type) {

        assertEquals(sortedLotto.getAward(), Award.UNIDENTIFIED);

        List<LottoNumber> winnerNumbers = parseStringNumbersToList(winnerNumberString);

        sortedLotto.drawLotto(winnerNumbers);
        assertEquals(sortedLotto.getAward(), Award.valueOf(type));
    }

    private List<LottoNumber> parseStringNumbersToList(String winnerNumberString) {
        return Arrays.stream(winnerNumberString.split(",")).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toList());
    }

    @ParameterizedTest
    @EnumSource(names = {"UNIDENTIFIED"})
    @DisplayName("isWinner 함수를 통해 디폴트 award 상태가 UNIDENTIFIED 임을 확인한다.")
    void isWinnerUnidentified(Award award) {
        assertTrue(sortedLotto.isWinner(award));
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:true","SECOND:false"}, delimiter = ':')
    @DisplayName("1등으로 당첨 로또의 isWinner 함수의 parameter로 First, Second를 넣었을 때 각각 ture, false를 리턴한다.")
    void isWinnerFirstAward(String type, boolean result){
        sortedLotto.drawLotto(winnerNumbers);
        assertEquals(sortedLotto.isWinner(Award.valueOf(type)), result);
    }

    @Test
    @DisplayName("LottoNumbers 생성 시 리스트의 사이즈가 6이 아니면 IllegalArgumentException이 발생한다")
    void sizeException() {
        List<LottoNumber> smallSizeNumberList = new ArrayList<>();
        IntStream.rangeClosed(1, 5).forEach(number -> smallSizeNumberList.add(new LottoNumber(number)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(smallSizeNumberList))
                .withMessage("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + smallSizeNumberList.size());
    }

    @Test
    @DisplayName("중복된 숫자로 LottoNumbers생성 시 IllegalArgumentException이 발생한다.")
    void duplicateNumbers(){
        List<LottoNumber> duplicateNumbers = new ArrayList<>();
        IntStream.rangeClosed(1, 6).forEach(number -> duplicateNumbers.add(new LottoNumber(1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(duplicateNumbers));

    }
}