package study.lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @DisplayName("로또 한 게임 6개 뽑기 확인")
    @Test
    void createLottoNumbers_로또_한게임_생성_테스트() {
        // given
        Lotto lotto = new Lotto();
        // when
        List<LottoNumber> lottoList = lotto.getLotto();
        int size = lottoList.size();
        // then
        assertThat(size).isEqualTo(6);
    }
}
