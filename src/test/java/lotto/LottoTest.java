package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class LottoTest {

    @Test
    void 로또_번호와_당첨_번호_일치_개수_계산() {
        //given
        List<LottoNumber> myLottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumbers myLottoNumbers = new LottoNumbers(myLottoNumberList);

        List<LottoNumber> winningLottoNumberList = Arrays.asList(new LottoNumber(1), new LottoNumber(2),
                new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        LottoNumbers winningLottoNumbers = new LottoNumbers(winningLottoNumberList);

        //when
        int result = Lotto.matchCount(myLottoNumbers, winningLottoNumbers);

        //then
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @CsvSource(value = {"3:5000", "4:50000", "5:1500000", "6:2000000000"}, delimiter = ':')
    void 수익_계산(int matchCount, long reward) {
        assertThat(Lotto.reward(matchCount)).isEqualTo(reward);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 7})
    void 번호_일치_개수_예외(int matchCount) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Lotto.reward(matchCount))
                .withMessageContaining("당첨에 해당하는 번호 일치 개수가 아닙니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"14000:14", "1000:1", "0:0"}, delimiter = ':')
    void 구입_매수_계산(long price, long lottoCount) {
        assertThat(Lotto.lottoCount(price)).isEqualTo(lottoCount);
    }
}
