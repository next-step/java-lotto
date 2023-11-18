package lotto;

import lottoController.LottoDomain;
import lottoModel.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {

    @Test
    @DisplayName("지난 당첨 번호 와 이번 당첨 번화 매칭 갯수 테스트")
    void compareLotto_로또매치넘버갯수() {

        String values = "1, 2, 3, 4, 5, 6";
        Set<Integer> convertLastLottoNumbers = LottoDomain.convertLastLottoNumbers(values);
        Lotto lotto = new Lotto(new ArrayList(Arrays.asList(1, 4, 6, 7, 8, 9)));
        int matchCount = lotto.matchCount(new ArrayList<>(convertLastLottoNumbers));
        assertThat(matchCount).isEqualTo(3);
    }

}
