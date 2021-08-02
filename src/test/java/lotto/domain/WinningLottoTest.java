package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class WinningLottoTest {

    @DisplayName("객체생성")
    @Test
    void create() {
        assertThat(new WinningLotto("1,2,3,4,5,6")).isInstanceOf(WinningLotto.class);
    }

    @DisplayName("수동-입력값이 길이가 6이 아닐 경우 예외 throw")
    @Test
    void validate_수동_길이가_6이_아님() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto("");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto("1,2,3,4,5");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");

        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto("1,2,3,4,5,6,7");
        }).withMessageMatching("6개의 숫자를 등록해야 합니다.");
    }

    @DisplayName("수동-중복값이 있을 경우 예외 throw")
    @Test
    void validate_수동_중복된_숫자() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new WinningLotto("1,2,3,4,1,6");
        }).withMessageMatching("중복된 숫자가 있습니다.");
    }

    @DisplayName("해당등수에 당첨된 로또가 몇갠지 반환")
    @Test
    void getMatchingLottoNumberCount_해당_등수에_맞는_로또_갯수() {
        WinningLotto winningLotto = new WinningLotto("5,15,20,35,40,45");
        List<Lotto> Lottolist = new ArrayList<>();
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,40,45)));  // 6개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,40,42))); // 5개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,41,42))); // 4개일치
        Lottolist.add(new Lotto(Arrays.asList(11,12,23,35,40,45))); // 3개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,31,32,33))); // 3개일치
        Lottolist.add(new Lotto(Arrays.asList(5,15,30,31,32,33))); // 2개일치
        Lottolist.add(new Lotto(Arrays.asList(6,7,8,9,10,11))); // 0개일치
        Lottolist.add(new Lotto(Arrays.asList(21,22,23,24,25,26))); // 0개일치
        Lottolist.add(new Lotto(Arrays.asList(36,37,38,39,41,42))); // 0개일치
        Lottos lottos = new Lottos(Lottolist);

        assertThat(winningLotto.getMatchingLottoNumberCount(Rank.FIRST, lottos)).isEqualTo(1);
        assertThat(winningLotto.getMatchingLottoNumberCount(Rank.SECOND, lottos)).isEqualTo(1);
        assertThat(winningLotto.getMatchingLottoNumberCount(Rank.THIRD, lottos)).isEqualTo(1);
        assertThat(winningLotto.getMatchingLottoNumberCount(Rank.FOURTH, lottos)).isEqualTo(2);
        assertThat(winningLotto.getMatchingLottoNumberCount(Rank.MISS, lottos)).isEqualTo(3);
    }

}