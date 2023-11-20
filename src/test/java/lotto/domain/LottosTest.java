package lotto.domain;

import lotto.domain.strategy.AutoLottoGeneration;
import lotto.domain.strategy.LottoGeneration;
import lotto.domain.strategy.ManualLottoGeneration;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LottosTest {

    public static final LottoGeneration LOTTO_GENERATION = new AutoLottoGeneration(LottoNumberCache.values());

    List<LottoGeneration> generationList;
    Lottos lottos;
    @BeforeEach
    void create(){
        generationList = new ArrayList<>();
        generationList.add(new ManualLottoGeneration(Arrays.asList(1,2,3,4,5,6)));

        lottos = new Lottos(new PurchaseQuantity(0), generationList,LOTTO_GENERATION);
    }

    @Test
    @DisplayName("로또목록 생성 확인")
    void 로또_목록_리턴() {
        assertThat(lottos.find())
                .containsOnly(new Lotto(generationList.get(0).generate()));
    }

    @Test
    @DisplayName("당첨번호와 로또 목록 비교하여 값이 있는 랭킹 값 목록만 리턴")
    void 로또당첨_확인() {
        Lotto winLotto = new Lotto(new ManualLottoGeneration(Arrays.asList(1, 2, 3, 4, 5, 6)).generate());
        LottoNumber bonus = new LottoNumber(7);

        assertThat(lottos.findRanks(winLotto,bonus)).hasSize(1).containsOnly(entry(LottoRank.FIRST,1));

    }
}
