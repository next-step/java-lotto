package lotto;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.MatchResult;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumbersTest {
    @DisplayName("LottoNumber 동일 번호 몇개인지 테스트")
    @Test
    public void intersectCount() throws Exception {
        LottoNumbers lottoNumbers = new LottoNumbers("1,2,3,4,5,6");
        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,2,3,4,5,6"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(6, false));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,2,3,4,5,7"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(5, true));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,2,3,4,5,8"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(5, false));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,2,3,4,7,8"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(4, true));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,2,3,10,8,9"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(3, false));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,2,7,8,9,10"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(2, true));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("1,7,8,9,10,11"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(1, true));

        assertThat(lottoNumbers.intersectCount(new LottoNumbers("13,8,9,10,11,12"), new LottoNumber(7)))
                .isEqualTo(new MatchResult(0, false));
    }

    @DisplayName("로또 6개 숫자만 허용 테스트")
    @Test
    public void validateLottoNumber() throws Exception {
        assertThat(new LottoNumbers("1,2,3,4,5,6"))
                .isNotNull();

        assertThatThrownBy(() -> new LottoNumbers("1,2,3,4,5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageStartingWith("Lotto requires ");
    }
}