package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottosTest {
    private Lottos lottos;

    @BeforeEach
    void setUp(){
        lottos = new Lottos();
    }

    @Test
    @DisplayName("구입금액에 맞게 구매한 로또 개수 출력")
    void 로또_구매(){
        assertThat(lottos.countByAmount(14000)).isEqualTo(14);
    }

    @Test
    @DisplayName("구입금액이 로또 금액보다 적은 금액인 경우")
    void 로또_구매_적은_금액(){
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    lottos.countByAmount(900);
                }).withMessageMatching("지불한 금액이 로또 금액보다 적습니다.");
    }

    @Test
    @DisplayName("당첨된 로또 개수 확인")
    void 당첨_개수(){
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
        lottoList.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        lottoList.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        lottoList.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        lottoList.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        lottoList.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        lottoList.add(new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)));
        lottoList.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
        lottoList.add(new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)));
        lottoList.add(new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)));
        lottoList.add(new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)));
        lottoList.add(new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)));
        lottoList.add(new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44)));

        lottos = new Lottos(lottoList);
        List<Integer> winningNumbers = Arrays.asList(1,2,3,4,5,6);
        for(Lotto lotto : lottoList){
            lotto.checkMatchNumberCount(winningNumbers);
        }

        Map<Integer, Integer> winningLottoMap = lottos.getWinningLottoCount();
        assertThat(winningLottoMap.get(3)).isEqualTo(1);
        assertThat(winningLottoMap.get(4)).isEqualTo(0);
        assertThat(winningLottoMap.get(5)).isEqualTo(0);
        assertThat(winningLottoMap.get(6)).isEqualTo(0);
    }

    @Test
    void 수익률_계산(){
        assertThat(lottos.calculateRateOfReturn( 5000, 14000)).isEqualTo(0.35);
    }
}
