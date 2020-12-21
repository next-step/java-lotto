package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 확인을 하기위한 로또 정보를 가진 `WinningLotto`에 대한 테스트")
class WinningLottoTest {

    @DisplayName("당첨 로또 생성")
    @Test
    void createWinningLottoTest() {
        // Given
        Lotto lotto = new Lotto();
        LottoNumber lottoNumber = new LottoNumber(provideBonusNumber(lotto));
        // When
        WinningLotto actual = new WinningLotto(lotto, lottoNumber);
        // Then
        assertThat(actual).isNotNull();
    }

    @DisplayName("로또 당첨 결과 반환")
    @Test
    void matchTest() {
        // Given
        Lotto lotto = new Lotto();
        LottoNumber lottoNumber = new LottoNumber(provideBonusNumber(lotto));
        WinningLotto winningLotto = new WinningLotto(lotto, lottoNumber);
        // When
        LottoRank actual = winningLotto.match(lotto);
        // Then
        assertThat(actual).isEqualTo(LottoRank.FIRST);
    }

    private int provideBonusNumber(Lotto winningLotto) {
        return IntStream.rangeClosed(LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER)
                .filter(number -> !winningLotto.getLottoNumbers().contains(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 갯수의 숫자로 구성된 당첨 로또입니다."));
    }
}
