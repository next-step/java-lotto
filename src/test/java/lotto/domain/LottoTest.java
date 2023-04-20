package lotto.domain;

import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {

    @Test
    @DisplayName("Lotto 추첨 대상 번호 생성")
    void lottoNumbersTest() {
        assertThat(Lotto.LOTTO_NUMBERS)
                .hasSize(45);
    }

    @Test
    @DisplayName("Lotto 발급")
    void publishLottoTest() {
        Lotto lotto = Lotto.initLotto();
        assertThat(lotto.getLottoSize())
                .isEqualTo(6);
    }

    @Test
    @DisplayName("Lotto 셔플 테스트")
    void lottoShuffleTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));
        List<Integer> lottoNumbers2 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));

        Collections.shuffle(lottoNumbers1);

        assertThat(new Lotto(lottoNumbers1))
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(lottoNumbers2));
    }

    @Test
    @DisplayName("Lotto 정렬 테스트")
    void lottoSortTest() {
        List<Integer> lottoNumbers1 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));
        List<Integer> lottoNumbers2 = new ArrayList<>(List.of(11, 5, 3, 4, 2, 9));

        Collections.sort(lottoNumbers2);

        assertThat(new Lotto(lottoNumbers1))
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(lottoNumbers2));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "1,2,3,4,5,6"})
    @DisplayName("Lotto 당첨 번호 테스트")
    void winningLottoTest(String input) {
        List<Integer> lottoNumber = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        List<String> winningNumbers = List.of(input.split(InputView.DELIMITER));

        Lotto winningLotto = Lotto.initWinningLotto(winningNumbers);

        assertThat(winningLotto)
                .usingRecursiveComparison()
                .isEqualTo(new Lotto(lottoNumber));
    }

    @Test
    @DisplayName("Lotto 당첨 번호 에러 테스트 - 문자가 섞인 케이스")
    void winningLottoContainStringTest() {
        String stringLottos = "1,2,3,4,5,a";
        List<String> wrongNumbers = List.of(stringLottos.split(InputView.DELIMITER));

        assertThatThrownBy(() -> Lotto.initWinningLotto(wrongNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자만 입력해주세요!");
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "1", "1,2,3,4,5", "1,2,3,4,5,6,7"})
    @DisplayName("Lotto 당첨 번호 에러 테스트 - 6자리가 아닌 케이스")
    void winningLottoSizeErrorTest(String input) {
        List<String> wrongNumbers = List.of(input.split(InputView.DELIMITER));

        assertThatThrownBy(() -> Lotto.initWinningLotto(wrongNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자 6개를 입력해주세요!");
    }

    @Test
    @DisplayName("Lotto 당첨 번호 에러 테스트 - 같은 번호가 있을 때")
    void winningLottoSameNumberTest() {
        String stringLottos = "1,2,3,4,5,1";
        List<String> wrongNumbers = List.of(stringLottos.split(InputView.DELIMITER));

        assertThatThrownBy(() -> Lotto.initWinningLotto(wrongNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("같은 번호가 있습니다!");
    }

}