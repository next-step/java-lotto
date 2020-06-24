package step4.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoNumberTest {

    public static final int LOTTO_DRAW_LIMIT = 6;

    @DisplayName("입력갯수에 맞는 로또 생성")
    @ParameterizedTest
    @CsvSource(value = {"1:1", "10:10", "9999:9999"}, delimiter = ':')
    public void issueLotto(int input, int result) {
        LottoTickets lottoTickets = LottoNumber.issueLotto(input);
        assertThat(lottoTickets.getLottoTickets().size()).isEqualTo(result);
    }

    //    @ValueSource(strings = {"6,5,4,3,2,1,7,8,9"})
    @DisplayName("LOTTO_DRAW_LIMIT 갯수에 맞는 당첨번호 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9", "2,1,43,44,33,4,22,23,12,3", "6,5,4,3,2,1,7,8,9"})
    void drawLottoNumbers(String input) {
        Lotto lotto = new Lotto(input);
        assertThat(lotto.getNumbers().size()).isEqualTo(LOTTO_DRAW_LIMIT);
    }

    @DisplayName("LOTTO_DRAW_LIMIT 갯수에 맞는 당첨번호 반환 범위초과")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6,7,8,9,0", "2,1,43,44,33,4,49,22,23,12,3", "6,5,4,3,2,1,7,8,9,90"})
    void drawLottoNumbersOverRanage(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
                {
                    Set<LottoNumber> result =
                            Arrays.stream(input.split(","))
                                    .map(x -> LottoNumber.of(Integer.valueOf(x)))
                                    .collect(Collectors.toSet());
                    Lotto lotto = new Lotto(result);
                    assertThat(lotto.getNumbers().size()).isEqualTo(LOTTO_DRAW_LIMIT);
                }
        );
    }

}
