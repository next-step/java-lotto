package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @Test
    @DisplayName("번호가 6개가 아니라면 예외가 발생한다.")
    void lottoSize() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("개의 중복되지 않은 숫자만 들어올 수 있습니다.");
    }

    @Test
    @DisplayName("로또정보를 반환할때는 기존로또를 복사해서 다른 인스턴스를 반환")
    void retrieveCopyLotto() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lottoNumbers).isNotSameAs(lotto.retrieveNumbers());
    }

    @Test
    @DisplayName("당첨번호와 비교해 맞춘 갯수 반환")
    void getCorrectNumber() {
        List<Integer> lottoNumbers = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(lottoNumbers);
        Lotto correctLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));

        assertThat(lotto.retrieveWinnerLottoBallCount(correctLotto)).isEqualTo(5);
    }
}