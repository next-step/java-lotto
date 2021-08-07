package lotto.domain;

import lotto.strategy.ListMixStrategy;
import lotto.strategy.ListSortStrategy;
import lotto.util.LottoNumberGenerator;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoTest {

    private Lotto randomLotto;
    private Lotto sortedLotto;
    private List<Integer> winnerNumbers = new ArrayList<>();

    @BeforeEach
    void setUp() {
        randomLotto = new Lotto(new ListMixStrategy());
        sortedLotto = new Lotto(new ListSortStrategy());
        winnerNumbers.addAll(Arrays.asList(1, 2, 3, 4, 5, 6));
    }

    @Test
    @DisplayName("생성한 로또의 숫자의 개수가 6임을 확인한다")
    void size() {
        assertThat(randomLotto.getNumbers().size()).isEqualTo(LottoNumberGenerator.SIZE);
        assertThat(sortedLotto.getNumbers().size()).isEqualTo(LottoNumberGenerator.SIZE);
    }

    @Test
    @DisplayName("랜덤 로또를 생성했을 때 각 숫자들은 최소숫자 1 이상, 최대숫자 45 이하임을 확인한다.")
    void lottoWithMixStrategy() {
        LottoNumbers lottoNumbers = randomLotto.getNumbers();
        for (int lottoNumber : lottoNumbers.getLottoNumbers()) {
            assertThat(lottoNumber).isGreaterThanOrEqualTo(LottoNumberGenerator.MIN_NUMBER);
            assertThat(lottoNumber).isLessThanOrEqualTo(LottoNumberGenerator.MAX_NUMBER);
        }
    }

    @Test
    @DisplayName("정렬 로또를 생성했을 때 각 숫자들은 1부터 6임을 확인한다.")
    void lottoWithSortStrategy() {
        LottoNumbers lottoNumbers = sortedLotto.getNumbers();
        for (int i = 0; i < lottoNumbers.size(); i++) {
            int number = i + 1;
            assertEquals(lottoNumbers.getLottoNumbers().get(i), number);
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,7,8:THIRD", "1,2,3,7,8,9:FOURTH", "1,2,7,8,9,10:BANG2", "1,7,8,9,10,11:BANG1", "7,8,9,10,11,12:BANG0"},
            delimiter = ':')
    @DisplayName("1~6까지의 로또에 대하여 winnerNumbers를 지정하여 1등 ~ 6등까지의 당첨을 확인한다.")
    void drawLottoFirstAward(String winnerNumberString, String type) {

        assertEquals(sortedLotto.getAward(), Award.UNIDENTIFIED);

        List<Integer> winnerNumbers = parseStringNumbersToList(winnerNumberString);
        LottoNumbers winnerLottoNumbers = new LottoNumbers(winnerNumbers);

        sortedLotto.drawLotto(winnerLottoNumbers);
        assertEquals(sortedLotto.getAward(), Award.valueOf(type));
    }

    private List<Integer> parseStringNumbersToList(String winnerNumberString) {
        return Arrays.stream(winnerNumberString.split(",")).map(Integer::parseInt).collect(Collectors.toList());
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
        sortedLotto.drawLotto(new LottoNumbers(winnerNumbers));
        assertEquals(sortedLotto.isWinner(Award.valueOf(type)), result);
    }
}