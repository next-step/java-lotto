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

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

class WinnerLottoTest {


    private Set<LottoNumber> lottoNumberList = new HashSet<>();
    public static final WinnerLotto winnerLotto = new WinnerLotto(createWinnerLottoNumbers(), new LottoNumber(7));
    private Lotto lotto;

    private static Lotto createWinnerLottoNumbers() {
        Set<LottoNumber> winnerNumbers = new HashSet<>();
        IntStream.rangeClosed(1, 6).forEach(number -> winnerNumbers.add(new LottoNumber(number)));
        return new Lotto(winnerNumbers);
    }

    @BeforeEach
    void setUp() {
        IntStream.rangeClosed(1, 6).forEach(number -> lottoNumberList.add(new LottoNumber(number)));
        lotto = new Lotto(lottoNumberList);
    }

    @Test
    @DisplayName("로또 당첨번호와 보너스번호가 중복이면 IllegalArgumentException이 발생한다.")
    void validateBonusNumber(){
        Lotto winnerLottoNumbers = createWinnerLottoNumbers();
        int bonus = 1;
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new WinnerLotto(winnerLottoNumbers, new LottoNumber(bonus)))
                .withMessage("로또번호와 보너스 번호가 중복입니다. bonusNumber : " + bonus);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3,4,5,6:7:FIRST", "1,2,3,4,5,7:6:SECOND", "1,2,3,4,5,8:9:THIRD", "1,2,3,4,8,9:10:FOURTH", "1,2,3,8,9,10:11:FIFTH", "1,7,8,9,10,11:12:BANG", "7,8,9,10,11,12:13:BANG"},
            delimiter = ':')
    @DisplayName("1~6까지의 로또에 대하여 winnerNumbers를 지정하여 1등 ~ 6등까지의 당첨을 확인한다.")
    void drawLottoFirstAward(String winnerNumberString, int bonus, String type) {

        Set<LottoNumber> winnerNumbers = parseStringNumbersToList(winnerNumberString);
        Lotto winlotto = new Lotto(winnerNumbers);
        WinnerLotto winnerLotto = new WinnerLotto(winlotto, new LottoNumber(bonus));
        Award award = winnerLotto.drawLotto(lotto.getNumbers());
        assertEquals(award, Award.valueOf(type));
    }

    private Set<LottoNumber> parseStringNumbersToList(String winnerNumberString) {
        return Arrays.stream(winnerNumberString.split(","))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }
}