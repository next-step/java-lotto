package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGameTest {

    LottoGame lottoGame = new LottoGame();

    @DisplayName("로또 생성 개수 테스트")
    @ParameterizedTest
    @CsvSource({"1000,1", "2000,2", "10000,10"})
    void getBuyCount(int buyPrice, int result) {
        assertThat(lottoGame.getBuyCount(buyPrice)).isEqualTo(result);
    }

    @DisplayName("로또 용지 생성 테스트 ")
    @ParameterizedTest
    @CsvSource({"1,1", "2,2", "15,15"})
    void getLottoList(int buyCount, int result) {
        LottoList lottoList = lottoGame.getLottoList(buyCount);
        assertThat(lottoList.getLottoList().size()).isEqualTo(result);
    }

    @DisplayName("지난주 당첨 번호 입력 결과 테스트")
    @Test
    void getWinningNumbers() {
        WinningLottoNumbers winningLottoNumbers = lottoGame.getWinningNumbers("1,2,3,4,5,6", 7);

        assertThat(winningLottoNumbers.getWinningLottoNumbers().getLottoNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
        assertThat(winningLottoNumbers.getBonusNumber()).isEqualTo(7);
    }

}
