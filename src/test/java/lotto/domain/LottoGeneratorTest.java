package lotto.domain;

import lotto.constant.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class LottoGeneratorTest {
    @Test
    void lotto_생성() {
        List<Integer> shuffledNumbers = List.of(1,2,3,4,5,6);
        assertThat(LottoGenerator.createLotto(shuffledNumbers)).hasSize(Constant.LOTTO_SIZE);
    }

    @Test
    void lotto_중복검사() {
        List<Integer> shuffledNumbers = List.of(1,2,3,4,5,6);
        List<LottoNumber> lotto = LottoGenerator.createLotto(shuffledNumbers);
        List<LottoNumber> checkDuplicate = lotto.stream()
                                                .distinct()
                                                .collect(Collectors.toList());
        assertThat(checkDuplicate).hasSize(lotto.size());
    }

    @Test
    void shuffledList_원소_개수() {
        List<Integer> shuffledNumbers = List.of(1,2,3,4,5,6,7);
        assertThatIllegalArgumentException()
                .isThrownBy(() -> LottoGenerator.createLotto(shuffledNumbers))
                .withMessageMatching("로또 번호는 6개여야 합니다.");
    }

    @Test
    void lottos_생성() {
        Lottos lottos = LottoGenerator.lotteryTickets(1);
        assertThat(lottos).isNotNull();
    }

}
