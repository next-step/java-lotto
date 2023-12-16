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

        assertThat(matchResult.matchCountOf(Rank.MISS)).isEqualTo(1);
        assertThat(matchResult.matchCountOf(Rank.FIFTH)).isEqualTo(2);
        assertThat(matchResult.matchCountOf(Rank.FOURTH)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호 5개와 보너스볼이 일치하면 당첨 결과 2등에 추가한다.")
    void 당첨_번호가_5개_일치하고_보너스볼이_일치하면_2등(){
        MyLottos myLottos = new MyLottos(List.of(
                new Lotto(Arrays.asList(4,5,6,7,8,11))
        ));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(4,5,6,7,8,9), 11);
        MatchResult matchResult = myLottos.matchMyLotto(winningLotto);

        assertThat(matchResult.matchCountOf(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호 6개가 일치하면 당첨 결과 1등에 추가한다.")
    void 당첨_번호가_6개_일치하면_1등(){
        MyLottos myLottos = new MyLottos(List.of(
                new Lotto(Arrays.asList(4,5,6,7,8,10))
        ));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(4,5,6,7,8,10), 11);
        MatchResult matchResult = myLottos.matchMyLotto(winningLotto);

        assertThat(matchResult.matchCountOf(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    @DisplayName("당첨 번호만 5개가 일치하면 당첨 결과 3등에 추가한다.")
    void 당첨_번호만_5개_일치하면_3등(){
        MyLottos myLottos = new MyLottos(List.of(
                new Lotto(Arrays.asList(4,5,6,7,8,10))
        ));
        WinningLotto winningLotto = new WinningLotto(Arrays.asList(4,5,6,7,8,9), 11);
        MatchResult matchResult = myLottos.matchMyLotto(winningLotto);

        assertThat(matchResult.matchCountOf(Rank.THIRD)).isEqualTo(1);
    }
}
