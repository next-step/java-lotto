package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

@DisplayName("구매한 로또 목록 관련 테스트")
public class LottosTest {

    @Test
    @DisplayName("당첨 번호와 매치한 결과 번호목록에 있는 랭킹 값 목록만 리턴")
    void 로또당첨_목록확인() {
        Lotto winList = new Lotto(Arrays.asList(6, 5, 4, 2, 3, 1));
        LottoNumber bonus = LottoNumber.valueOf(1);

        List<Lotto> list = new ArrayList<>();
        Lotto lotto1 = new Lotto(new ArrayList<>(Arrays.asList(6, 5, 4, 10, 11, 12)));
        Lotto lotto2 = new Lotto(new ArrayList<>(Arrays.asList(1, 2, 3, 20, 21, 22)));
        list.add(lotto1);
        list.add(lotto2);
        Lottos lottos = new Lottos(list);

        assertThat(lottos.findRanks(winList,bonus)).hasSize(1).containsOnly(entry(LottoRank.FIFTH, 2));
    }

}
