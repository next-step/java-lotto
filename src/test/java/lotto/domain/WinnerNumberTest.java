package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinnerNumberTest {

    private WinnerNumber winnerNumber;

    void createTest(String lottoNumbers) {
        this.winnerNumber = new WinnerNumber(lottoNumbers);
    }

    @Test
    void 당첨_번호_생성() {
        // given
        String lottoNumbers = "1,2,3,4,5,6";
        // when
        createTest(lottoNumbers);
        Lotto result = winnerNumber.resultLotto();
        // then
        assertThat(result.lottoNumbers()).hasSize(6);
    }

    @Test
    void 구매로또와_당첨결과에_대한_통계() {
        // given
        String winNumber = "1,2,3,4,5,6";
        int bonusNumber = 7;
        winnerNumber = new WinnerNumber(winNumber, bonusNumber);
        Lotto buyLotto = new Lotto(1, 2, 3, 4, 5, 6);
        List<Lotto> buyLottos = List.of(buyLotto);
        // when
        Map<RankLotto, Integer> result = winnerNumber.statisticsResult(buyLottos);
        // then
        assertThat(result.get(RankLotto.FIRST)).isEqualTo(1);
    }

    @DisplayName("당첨 번호 생성 실패")
    @Nested
    class 생성_실패 {

        @Test
        void 당첨_번호_이탈_생성_실패() {
            // given
            String lottoNumbers = "1,2,3,46,5,6";
            // when
            // then
            assertThatThrownBy(() -> {
                createTest(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_번호_7개_입력_생성_실패() {
            // given
            String lottoNumbers = "1,2,3,7,5,6,7";
            // when
            // then
            assertThatThrownBy(() -> {
                createTest(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_번호_4개_입력_생성_실패() {
            // given
            String lottoNumbers = "1,2,3,4,5";
            // when
            // then
            assertThatThrownBy(() -> {
                createTest(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨_번호_입력_오류() {
            // given
            String lottoNumbers = "1,2,q,4,5";
            // when
            // then
            assertThatThrownBy(() -> {
                createTest(lottoNumbers);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 당첨번호와_동일한_보너스_번호_입력_오류() {
            // given
            String lottoNumbers = "1,2,3,4,5,6";
            int bonusNumber = 6;
            // when
            // then
            assertThatThrownBy(() -> {
                winnerNumber = new WinnerNumber(lottoNumbers, bonusNumber);
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        void 보너스_번호_입력_범위_이탈_오류() {
            // given
            String lottoNumbers = "1,2,3,4,5,6";
            int bonusNumber = 46;
            // when
            // then
            assertThatThrownBy(() -> {
                winnerNumber = new WinnerNumber(lottoNumbers, bonusNumber);
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
