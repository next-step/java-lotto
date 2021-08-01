package lotto.domain.lotto.number;

import lotto.domain.lotto.WinningLotto;
import lotto.domain.prize.MatchInfo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

import static lotto.fixture.LottoFixture.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LottoNumbersTest {
    @DisplayName("LottoNumber 6개 이면 LottoNumbers 객체를 만든다")
    @Test
    public void should_make_object_with_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();

        //act
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);

        //assert
        assertThat(lottoNumbers.getLottoNumbers()).isEqualTo(new HashSet(lottoNumberList));
    }

    @DisplayName("LottoNumber 6개 보다작으면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_under_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToFiveLottoNumberSequence();

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(lottoNumbers));
    }


    @DisplayName("LottoNUmber 6개 보다 크면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_over_count_6_lotto_number() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToSevenLottoNumberSequence();

        //act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> LottoNumbers.of(lottoNumbers));
    }

    @DisplayName("WinningLottoNumber와 매치가 되면 매치되는 count를 계산하여 반환한다")
    @Test
    public void shoud_return_match_count() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);
        LottoNumber bonusNumber = LottoNumber.of(43);
        WinningLotto winningLotto = WinningLotto.of(
                LottoNumbers.of(createOneToThreeAndDifferentThreeNumberSequence()),
                bonusNumber
        );

        //act
        MatchInfo matchInfo = lottoNumbers.match(winningLotto);

        //assert
        assertTrue(matchInfo.isEqualCount(3));
    }
}