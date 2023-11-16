package lotto.domain;

import lotto.dto.WinningInfoDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTest {
//    @DisplayName("1에서 45 사이의 값중 무작위 값 6개를 가진 리스트를 리턴한다.")
//    @Test
//    void 로또_구매() {
//        Lotto lotto = new Lotto();
//        List<Integer> game = lotto.purchasing();
//        assertThat(game.size()).isEqualTo(6);
//        assertThat(game).allSatisfy(number -> {
//            assertThat(number).isGreaterThanOrEqualTo(1).isLessThanOrEqualTo(45);
//        });
//    }

    @DisplayName("당첨번호 포함 갯수에 따른 당첨정보 리턴")
    @Test
    void 당첨정보_리턴() {
        Lotto lotto = new Lotto("5, 2,21,45, 34,30");
        assertThat(lotto.winningInfo("1,2,3,45,5,6"))
                .usingRecursiveComparison()
                .isEqualTo(new WinningInfoDTO(3, 5000));
    }
}