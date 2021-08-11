package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    private Set<LottoNumber> winnerNumbers = new HashSet<>();
    private Set<LottoNumber> lottoNumberList = new HashSet<>();
    private Lotto winnerLotto;
    private Lotto lotto;

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
        IntStream.rangeClosed(1, 6).forEach(number -> lottoNumberList.add(new LottoNumber(number)));
        winnerLotto = new Lotto(winnerNumbers);
        lotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("생성한 로또의 숫자의 개수가 6임을 확인한다")
    void size() {
        assertThat(lotto.getNumbers().size()).isEqualTo(Lotto.SIZE);
    }

    @Test
    @DisplayName("정렬 로또를 생성했을 때 각 숫자들은 1부터 6임을 확인한다.")
    void lottoWithSortStrategy() {
        Set<LottoNumber> lottoNumbers = lotto.getNumbers();
        IntStream.rangeClosed(1,6).forEach(number -> lottoNumbers.contains(new LottoNumber(number)));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,7,8:THIRD", "1,2,3,7,8,9:FOURTH", "1,2,7,8,9,10:BANG", "1,7,8,9,10,11:BANG", "7,8,9,10,11,12:BANG"},
            delimiter = ':')
    @DisplayName("1~6까지의 로또에 대하여 winnerNumbers를 지정하여 1등 ~ 6등까지의 당첨을 확인한다.")
    void drawLottoFirstAward(String winnerNumberString, String type) {

        assertEquals(lotto.getAward(), Award.UNIDENTIFIED);

        Set<LottoNumber> winnerNumbers = parseStringNumbersToList(winnerNumberString);
        Lotto winnerLotto = new Lotto(winnerNumbers);

        lotto.drawLotto(winnerLotto);
        assertEquals(lotto.getAward(), Award.valueOf(type));
    }

    private Set<LottoNumber> parseStringNumbersToList(String winnerNumberString) {
        return Arrays.stream(winnerNumberString.split(",")).map(Integer::parseInt).map(LottoNumber::new).collect(Collectors.toSet());
    }

    @ParameterizedTest
    @EnumSource(names = {"UNIDENTIFIED"})
    @DisplayName("isWinner 함수를 통해 디폴트 award 상태가 UNIDENTIFIED 임을 확인한다.")
    void isWinnerUnidentified(Award award) {
        assertTrue(lotto.isWinner(award));
    }

    @ParameterizedTest
    @CsvSource(value = {"FIRST:true","SECOND:false"}, delimiter = ':')
    @DisplayName("1등으로 당첨 로또의 isWinner 함수의 parameter로 First, Second를 넣었을 때 각각 ture, false를 리턴한다.")
    void isWinnerFirstAward(String type, boolean result){
        lotto.drawLotto(winnerLotto);
        assertEquals(lotto.isWinner(Award.valueOf(type)), result);
    }

    @Test
    @DisplayName("LottoNumbers 생성 시 리스트의 사이즈가 6이 아니면 IllegalArgumentException이 발생한다")
    void sizeException() {
        Set<LottoNumber> smallSizeNumberList = new HashSet<>();
        IntStream.rangeClosed(1, 5).forEach(number -> smallSizeNumberList.add(new LottoNumber(number)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(smallSizeNumberList))
                .withMessage("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + smallSizeNumberList.size());
    }

    @Test
    @DisplayName("중복된 숫자로 LottoNumbers생성 시 IllegalArgumentException이 발생한다.")
    void duplicateNumbers(){
        Set<LottoNumber> duplicateNumbers = new HashSet<>();
        IntStream.rangeClosed(1, 6).forEach(number -> duplicateNumbers.add(new LottoNumber(1)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(duplicateNumbers));

    }
}