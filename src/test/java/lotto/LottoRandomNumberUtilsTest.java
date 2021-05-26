package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static lotto.LottoRank.FIRST;
import static org.assertj.core.api.Assertions.assertThat;

public class LottoRandomNumberUtilsTest {
    @DisplayName("로또 번호 랜덤 생성 후 정상 생성 테스트")
    @Test
    void creatRandomLottoNumber_랜덤_로또_번호_생성() {
        LottoNumber lottoNumber = new LottoRandomNumberUtils().createRandomLotto();
        assertThat(lottoNumber.lottoSize(6)).isTrue();
    }

    @DisplayName("로또 랜덤 번호 테스트 코드 위해 함수형 인터페이스 생성")
    @Test
    void createRandomLottoNumberTest_로또_넘버_테스트_넘기기_테스트() {
        Lotto lotto = new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8)));
        LottoRank lottoRank = lotto.compareWinLottoNumber(new Lotto(() -> new LottoNumber(Arrays.asList(1, 2, 3, 4, 7, 8))));
        assertThat(lottoRank).isEqualTo(FIRST);
    }

}
