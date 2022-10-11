package step2.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

class LottoGameTest {

    @DisplayName("playLotto 구매 갯수 만큼의 로또 번호 객체를 생성한다")
    @ParameterizedTest
    @ValueSource(ints = {1,3,5,6,9})
    void playLotto_make_purchaseCount_lottoNumber(int purchaseCount){
        LottoGame lottoGame = LottoGame.newInstance();
        List<LottoNumber> lottoNumbers = lottoGame.playLotto(purchaseCount);
        Assertions.assertThat(lottoNumbers.size()).isEqualTo(4);
    }
}