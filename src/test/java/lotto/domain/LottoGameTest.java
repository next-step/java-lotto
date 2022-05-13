package lotto.domain;

import lotto.exception.InvalidManualLottoNumberCount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoGameTest {

    @Test
    @DisplayName("15000원으로 로또 게임 생성 시 15개의 로또를 생성한다.")
    void initialize() {
        LottoGame lottoGame = new LottoGame(new Cash(15000), Collections.emptyList());

        assertThat(lottoGame.lottos().count()).isEqualTo(15);
    }

    @Test
    @DisplayName("수동 로또 번호를 입력하면 해당 번호를 가진 로또들을 포함한다.")
    void manualLotto() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
        lottoNumbers.add(new LottoNumbers("1,2,3,4,7,8"));

        LottoGame lottoGame = new LottoGame(new Cash(15000), lottoNumbers);

        assertThat(lottoGame.lottos().toList()).contains(Lotto.valueOf(new LottoNumbers("1,2,3,4,5,6")),
                Lotto.valueOf(new LottoNumbers("1,2,3,4,7,8")));
    }

    @Test
    @DisplayName("수동로또정보와 총 생성할 로또 수가 같으면 수동로또번호를 가진 로또만 생성한다.")
    void allManualLotto() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
        lottoNumbers.add(new LottoNumbers("1,2,3,4,7,8"));
        LottoGame lottoGame = new LottoGame(new Cash(2000), lottoNumbers);

        assertThat(lottoGame.lottos().toList()).containsExactly(Lotto.valueOf(new LottoNumbers("1,2,3,4,5,6")),
                Lotto.valueOf(new LottoNumbers("1,2,3,4,7,8")));
    }

    @Test
    @DisplayName("총 로또 개수보다 수동로또 정보가 많을 경우 InvalidManualLottoNumberCount 를 반환한다.")
    void invalidManualLotto() {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumbers("1,2,3,4,5,6"));
        lottoNumbers.add(new LottoNumbers("1,2,3,4,7,8"));

        assertThatThrownBy(() -> new LottoGame(new Cash(1000), lottoNumbers))
                .isInstanceOf(InvalidManualLottoNumberCount.class)
                .hasMessage("수동 로또 번호 개수가 총 로또 개수(1)를 초과할 수 없습니다.");
    }
}