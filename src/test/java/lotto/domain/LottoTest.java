package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTest {

    private Set<LottoNumber> lottoNumberList = new HashSet<>();
    public static final Lotto winnerLotto = new Lotto(createWinnerLottoNumbers());
    private Lotto lotto;

    private static Set<LottoNumber> createWinnerLottoNumbers() {
        Set<LottoNumber> winnerNumbers = new HashSet<>();
        IntStream.rangeClosed(1, 6).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
        return winnerNumbers;
    }

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> lottoNumberList.add(new LottoNumber(number)));
        lotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("생성한 로또의 숫자의 개수가 6임을 확인한다")
    void size() {
        assertThat(lotto.getNumbers().size()).isEqualTo(Lotto.SIZE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:FIRST", "1,2,3,4,5,7:SECOND", "1,2,3,4,7,8:THIRD", "1,2,3,7,8,9:FOURTH", "1,2,7,8,9,10:BANG", "1,7,8,9,10,11:BANG", "7,8,9,10,11,12:BANG"},
            delimiter = ':')
    @DisplayName("1~6까지의 로또에 대하여 winnerNumbers를 지정하여 1등 ~ 6등까지의 당첨을 확인한다.")
    void drawLottoFirstAward(String winnerNumberString, String type) {

        Set<LottoNumber> winnerNumbers = parseStringNumbersToList(winnerNumberString);
        Lotto winnerLotto = new Lotto(winnerNumbers);

        Award award = lotto.drawLotto(winnerLotto);
        assertEquals(award, Award.valueOf(type));
    }

    private Set<LottoNumber> parseStringNumbersToList(String winnerNumberString) {
        return Arrays.stream(winnerNumberString.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    @Test
    @DisplayName("LottoNumbers 생성 시 리스트의 사이즈가 6이 아니면 IllegalArgumentException이 발생한다")
    void sizeException() {
        Set<LottoNumber> smallSizeNumberList = new HashSet<>();
        IntStream.rangeClosed(1, 5).forEach(number -> smallSizeNumberList.add(new LottoNumber(number)));
        assertThatIllegalArgumentException().isThrownBy(() -> new Lotto(smallSizeNumberList))
                .withMessage("LottoNumbers의 사이즈가 잘못 입력되었습니다. 입력 사이즈 : " + smallSizeNumberList.size());
    }

}