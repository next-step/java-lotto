package lotto.domain;

import lotto.domain.*;
import lotto.domain.purchaseStrategy.AutoPurchaseStrategy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class LottoMachineTest {

    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        lottoMachine = new LottoMachine();
    }

    @DisplayName("구입금액이 1000원 미만일때 예외 throw")
    @ParameterizedTest
    @ValueSource(ints = {999, 0, -1000})
    void validateAmount_구입가격이_1000원_미만(int input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            lottoMachine.buyLotto(input, new AutoPurchaseStrategy());
        }).withMessageMatching("최소 1000원 이상 지불하셔야 합니다.");
    }

    @DisplayName("로또용지가 넣은 돈만큼 나오는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"1700:1", "5600:5", "20000:20"}, delimiter = ':')
    void validateAmount_로또용지(int amount, int lottoCount) {
        assertThat(lottoMachine.buyLotto(amount, new AutoPurchaseStrategy()).getLottos().size()).isEqualTo(lottoCount);
    }

    @DisplayName("번호 매칭 확인")
    @Test
    void checkLottoMatching_일치여부_확인() {
        WinningLotto winningLotto = new WinningLotto("5,15,20,35,40,45");
        List<Lotto> Lottolist = new ArrayList<>();
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,40,45)));  // 6개일치 > FIRST
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,40,42))); // 5개일치 > SECOND
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,35,41,42))); // 4개일치 > THIRD
        Lottolist.add(new Lotto(Arrays.asList(11,12,23,35,40,45))); // 3개일치 > FOURTH
        Lottolist.add(new Lotto(Arrays.asList(5,15,20,31,32,33))); // 3개일치 > FOURTH
        Lottolist.add(new Lotto(Arrays.asList(5,15,30,31,32,33))); // 2개일치 > MISS
        Lottolist.add(new Lotto(Arrays.asList(6,7,8,9,10,11))); // 0개일치 > MISS
        Lottolist.add(new Lotto(Arrays.asList(21,22,23,24,25,26))); // 0개일치 > MISS
        Lottolist.add(new Lotto(Arrays.asList(36,37,38,39,41,42))); // 0개일치 > MISS

        Map<Rank, MatchingCount> matcingInfo = lottoMachine.checkLottoMatching(winningLotto, new Lottos(Lottolist));

        assertThat(matcingInfo.get(Rank.FIRST).getMatchingCount()).isEqualTo(1);
        assertThat(matcingInfo.get(Rank.SECOND).getMatchingCount()).isEqualTo(1);
        assertThat(matcingInfo.get(Rank.THIRD).getMatchingCount()).isEqualTo(1);
        assertThat(matcingInfo.get(Rank.FOURTH).getMatchingCount()).isEqualTo(2);
        assertThat(matcingInfo.get(Rank.MISS).getMatchingCount()).isEqualTo(4);
    }
    
    @DisplayName("상금 총합을 계산해서 반환")
    @Test
    void test() {
        WinningLotto winningLotto = new WinningLotto("5,15,20,35,40,45");

        List<Lotto> firstLottolist = new ArrayList<>();
        firstLottolist.add(new Lotto(Arrays.asList(5,15,20,31,32,33)));
        firstLottolist.add(new Lotto(Arrays.asList(36,37,38,39,41,42)));

        Map<Rank, MatchingCount> matcingInfo = lottoMachine.checkLottoMatching(winningLotto, new Lottos(firstLottolist));

        assertThat(lottoMachine.calculateProfits(matcingInfo)).isEqualTo(2.5);


        winningLotto = new WinningLotto("1,2,3,4,5,6");

        List<Lotto> secondLottolist = new ArrayList<>();
        secondLottolist.add(new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)));
        secondLottolist.add(new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)));
        secondLottolist.add(new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)));
        secondLottolist.add(new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)));
        secondLottolist.add(new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)));
        secondLottolist.add(new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)));
        secondLottolist.add(new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)));
        secondLottolist.add(new Lotto(Arrays.asList(23, 25, 33, 36, 39, 41)));
        secondLottolist.add(new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45)));
        secondLottolist.add(new Lotto(Arrays.asList(5, 9, 38, 41, 43, 44)));
        secondLottolist.add(new Lotto(Arrays.asList(2, 8, 9, 18, 19, 21)));
        secondLottolist.add(new Lotto(Arrays.asList(13, 14, 18, 21, 23, 35)));
        secondLottolist.add(new Lotto(Arrays.asList(17, 21, 29, 37, 42, 45)));
        secondLottolist.add(new Lotto(Arrays.asList(3, 8, 27, 30, 35, 44)));

        matcingInfo = lottoMachine.checkLottoMatching(winningLotto, new Lottos(secondLottolist));

        assertThat(lottoMachine.calculateProfits(matcingInfo)).isEqualTo(0.36);
    }

}
