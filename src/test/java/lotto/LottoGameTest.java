package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class LottoGameTest {

    @Test
    @DisplayName("로또 Game수 확인")
    void gameCount() {
        assertThat(LottoGame.countGame(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 번호 정렬")
    void sortLottoNumber_로또넘버정렬() {

        List<Integer> numbers = new ArrayList(Arrays.asList(1, 4, 3, 5, 2, 6));
        Lotto lotto1 = new Lotto(LottoGame.sortLottoNumber((ArrayList<Integer>) numbers));
        Lotto lotto2 = new Lotto(new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("입력한 게임수 만큼 로또 생성")
    void creatLotto_로또넘버생성() {
        List<Lotto> lottos = LottoGame.createLottoGames(14);
        assertThat(lottos.size()).isEqualTo(14);
    }

    @Test
    @DisplayName("지난 당첨 번호 와 이번 당첨 번화 매칭 갯수 테스트")
    void compareLotto_로또매치넘버갯수() {

        String values = "1, 2, 3, 4, 5, 6";
        List<Integer> convertLastLottoNumbers = LottoGame.convertLastLottoNumbers(values);
        Lotto lotto = new Lotto(new ArrayList(Arrays.asList(1, 4, 6, 7, 8, 9)));
        int matchCount = lotto.matchCount(convertLastLottoNumbers);
        assertThat(matchCount).isEqualTo(3);
    }

}