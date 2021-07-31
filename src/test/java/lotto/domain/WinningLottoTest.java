package lotto.domain;

import lotto.exception.OverlapNumberException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class WinningLottoTest {
    @CsvSource(value = {
            "1,2,3,4,5,6|45",
            "1,2,3,4,5,6|7"
    }, delimiter = '|')
    @ParameterizedTest
    @DisplayName("ctor Test")
    public void ctorTest(String strLottoNumbers, int bonusNumber) {
        assertThatCode(() ->
                new WinningLotto(
                        Lotto.of(strLottoNumbers),
                        new LottoNumber(bonusNumber)
                )
        ).doesNotThrowAnyException();
    }

    @CsvSource(value = {
            "1,2,3,4,5,6|4",
            "1,2,3,4,5,6|6"
    }, delimiter = '|')
    @ParameterizedTest
    @DisplayName("ctor OverlapNumberException Test - 당첨 번호와 보너스 번호는 중복되지 않아야 한다.")
    public void ctorTest_OverlapNumberException(String strLottoNumbers, int bonusNumber) {
        assertThatThrownBy(() ->
                new WinningLotto(
                        Lotto.of(strLottoNumbers),
                        new LottoNumber(bonusNumber)
                )
        ).isInstanceOf(OverlapNumberException.class);
    }


    @CsvSource(value = {
            "1,2,3,4,5,6|1,2,3,4,5,6|45|FIRST_PLACE",   // 1등 :: 6개 일치
            "1,2,3,4,5,45|1,2,3,4,5,6|45|SECOND_PLACE",   // 2등 :: 5개 + 보너스 볼 일치
            "1,2,3,4,5,6|1,2,3,4,5,7|45|THREE_PLACE",   // 3등 :: 5개 일치
            "1,2,3,4,5,6|1,2,3,4,11,12|45|FOUR_PLACE",  // 4등 :: 4개 일치
            "1,2,3,4,5,6|1,2,3,10,11,12|45|FIVE_PLACE", // 5등 :: 3개 일치
            "1,2,3,4,5,6|1,2,9,10,11,12|45|LAST_PLACE", // 순위 없음
            "1,2,3,4,5,6|1,7,9,10,11,12|45|LAST_PLACE", // 순위 없음
            "1,2,3,4,5,6|6,7,9,10,11,12|45|LAST_PLACE", // 순위 없음

            // 2등 아래로 내려가면 보너스 번호를 포함해서 순위가 결정되면 안된다.
            "1,2,3,4,7,45|1,2,3,4,5,6|45|FOUR_PLACE",
            "1,2,3,7,8,45|1,2,3,4,5,6|45|FIVE_PLACE",
    }, delimiter = '|')
    @DisplayName("rank Test")
    @ParameterizedTest
    public void rankTest(String strLottoNumbers, String strWinningLottoNumbers, int bonusNumber, String rankName) {
        Lotto lotto = Lotto.of(strLottoNumbers);
        WinningLotto winningLotto = new WinningLotto(
                Lotto.of(strWinningLottoNumbers), new LottoNumber(bonusNumber)
        );

        LottoRank expertRank = LottoRank.valueOf(rankName);

        assertThat(winningLotto.rank(lotto))
                .isEqualTo(expertRank);
    }
}