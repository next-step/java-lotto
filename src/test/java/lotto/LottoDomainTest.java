package lotto;

import lottoModel.Lotto;
import lottoController.LottoDomain;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


class LottoDomainTest {

    @Test
    @DisplayName("로또 Game수 확인")
    void gameCount() {
        assertThat(LottoDomain.countGame(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("로또 번호 정렬")
    void sortLottoNumber_로또넘버정렬() {

        Integer[] array = {1, 4, 3, 5, 2, 6};
        Set<Integer> set = Arrays.stream(array).collect(Collectors.toSet());
        Lotto lotto1 = new Lotto(LottoDomain.sortLottoNumber(set));
        Lotto lotto2 = new Lotto(new ArrayList(Arrays.asList(1, 2, 3, 4, 5, 6)));

        assertThat(lotto1).isEqualTo(lotto2);
    }

    @Test
    @DisplayName("입력한 게임수 만큼 로또 생성")
    void creatLotto_로또넘버생성() {
        List<Lotto> lottos = LottoDomain.createLottoGames(14);
        assertThat(lottos.size()).isEqualTo(14);
    }



}