package lotto.domain.data;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LottoTest {

    @DisplayName("로또 DATA 객체가 제대로 생성되는 지 확인")
    @Test
    public void createLottoNumberTest() {
        List<LottoNumber> lottoNumbers = LottoNumberPool.get(List.of(1,2,3,4,5,6));
        Lotto lotto = Lotto.of(lottoNumbers);
        List<LottoNumber> lottoNumberActual = lotto.getNumbers();
        assertAll(
                () -> assertThat(lotto).isNotNull(),
                () -> assertThat(lottoNumbers).containsAll(lottoNumberActual)
        );
    }

    @DisplayName("로또는 6개의 수가 아닐 경우 IllegalArgument 오류가 발생한다")
    @Test
    public void validateSixNumberTest() {
        assertThatThrownBy(() -> {
           Lotto.of(LottoNumberPool.get(List.of(1,2)));
        }).isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("로또 생성 시 중복된 숫자가 들어갈 경우 IllegalArgument 오류가 발생한다. ")
    @Test
    public void validateDuplicateNumberTest() {
        assertThatThrownBy(() -> {
            Lotto.of(LottoNumberPool.get(List.of(1,2,3,4,4,6)));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또에 전달된 숫자들 중 몇개가 포함되어 있는 지 리턴한다.")
    @Test
    public void getContainCountTest() {
        Lotto lotto = Lotto.of(LottoNumberPool.get(List.of(1,2,3,4,5,6)));

        int counts = lotto.getContainCount(LottoNumberPool.get(List.of(1,2,3)));

        assertThat(counts).isEqualTo(3);
    }

    @DisplayName("로또가 몇등인지 학인핳 수 있다.")
    @Test
    public void getRankTest() {
        Lotto lotto = Lotto.of(LottoNumberPool.get(List.of(1,2,3,4,5,6)));
        WinningLotto winningLotto = new WinningLotto(LottoNumberPool.get(List.of(1,2,3,4,5,7)), LottoNumberPool.get(6));

        LottoRank lottoRank = lotto.getWinningRank(winningLotto);

        assertThat(lottoRank).isEqualTo(LottoRank.RANK2);
    }
}
