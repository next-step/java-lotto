package lotto.domain.lotto;

import lotto.domain.lotto.number.LottoNumber;
import lotto.domain.lotto.number.LottoNumbers;
import lotto.domain.prize.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static lotto.fixture.LottoFixture.createOneToSixLottoNumberSequence;
import static lotto.fixture.LottoFixture.createOneToThreeAndDifferentThreeNumberSequence;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoTest {
    @DisplayName("LottoNumber 리스트를 가지고 Lotto객체를 만든다")
    @Test
    public void should_make_object_with_lotto_obj_list() throws Exception {
        //arrange
        List<LottoNumber> lottoNumberList = createOneToSixLottoNumberSequence();
        List<Integer> expectedLottoNumbers =
                lottoNumberList.stream().map(LottoNumber::getNumber).collect(Collectors.toList());
        LottoNumbers lottoNumbers = LottoNumbers.of(lottoNumberList);

        //act
        Lotto lotto = Lotto.of(lottoNumbers);

        //assert
        assertThat(lotto.getLottoNumbers()).isEqualTo(expectedLottoNumbers);
    }

    @DisplayName("LottoNumber 리스트가 null이면 IllegalArgumentException을 리턴한다")
    @Test
    public void should_throw_exception_under_count_6_lotto_number() throws Exception {
        //arrange, act, assert
        assertThatIllegalArgumentException().isThrownBy(() -> Lotto.of(null));
    }

    @DisplayName("WinningLottoNumber와 매치가 되면 LottoPrize 값을 반환한다 ")
    @Test
    public void shoud_return_prize_when_match_lotto() throws Exception {
        //arrange
        List<LottoNumber> lottoNumbers = createOneToSixLottoNumberSequence();
        Lotto lotto = Lotto.of(LottoNumbers.of(lottoNumbers));
        WinningLotto winningLotto = WinningLotto.of(LottoNumbers.of(createOneToThreeAndDifferentThreeNumberSequence()));

        //act
        LottoPrize lottoPrize = lotto.match(winningLotto);

        //act, assert
        assertAll(
                () -> assertThat(lottoPrize.getMatchCount()).isEqualTo(3),
                () -> assertThat(lottoPrize).isEqualTo(LottoPrize.FOURTH)
        );
    }
}