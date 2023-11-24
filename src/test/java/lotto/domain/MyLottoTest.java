package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyLottoTest {

    @Test
    @DisplayName("입력 개수만큼 로또를 생성한다.")
    void 입력_개수만큼_로또_생성(){
        MyLottos myLottos = new MyLottos(14);

        assertThat(myLottos.myLottos()).hasSize(14);
        assertThat(myLottos.myLottos().get(13)).isInstanceOf(Lotto.class);
    }

    @Test
    @DisplayName("당첨 번호가 N개 일치하는 로또 개수를 반환한다.")
    void 당첨_번호가_N개_일치하는_로또_개수(){
        MyLottos myLottos = new MyLottos(List.of(
                new Lotto(Arrays.asList(1,2,3,4,10,11)),
                new Lotto(Arrays.asList(1,2,3,4,5,6)),
                new Lotto(Arrays.asList(2,3,7,8,9,10)),
                new Lotto(Arrays.asList(6,7,8,9,10,11))
        ));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(4,5,6,7,8,9));
        MatchResult matchResult = myLottos.matchMyLotto(winningLotto);

        assertThat(matchResult.matchCountOf(1)).isEqualTo(1);
        assertThat(matchResult.matchCountOf(3)).isEqualTo(2);
        assertThat(matchResult.matchCountOf(4)).isEqualTo(1);
    }
}
