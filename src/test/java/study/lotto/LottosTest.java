package study.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.lotto.domain.Lotto;
import study.lotto.domain.LottoNumber;
import study.lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("로또 목록 생성 테스트")
    @Test
    void create_lottos() {
        List<LottoNumber> lottoNumbers1 = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto1 = Lotto.of(lottoNumbers1);

        List<LottoNumber> lottoNumbers2 = Stream.of(2, 4, 6, 8, 10, 12).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto2 = Lotto.of(lottoNumbers2);

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(lotto1);
        lottoList.add(lotto2);

        Lottos lottos = Lottos.of(lottoList);

        assertThat(lottos)
                .extracting("lottos")
                .isEqualTo(Arrays.asList(lotto1, lotto2));

    }

    @DisplayName("로또 목록 병합 테스트")
    @Test
    void merge_two_lottos() {
        List<LottoNumber> lottoNumbers1 = Stream.of(1, 3, 5, 7, 9, 11).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto1 = Lotto.of(lottoNumbers1);
        List<Lotto> lottoList1 = new ArrayList<>();
        lottoList1.add(lotto1);
        Lottos lottos1 = Lottos.of(lottoList1);

        List<LottoNumber> lottoNumbers2 = Stream.of(2, 4, 6, 8, 10, 12).map(LottoNumber::of).collect(Collectors.toList());
        Lotto lotto2 = Lotto.of(lottoNumbers2);
        List<Lotto> lottoList2 = new ArrayList<>();
        lottoList2.add(lotto2);
        Lottos lottos2 = Lottos.of(lottoList2);

        lottos1.addAll(lottos2);

        assertThat(lottos1)
                .extracting("lottos")
                .isEqualTo(Arrays.asList(lotto1, lotto2));

    }
}
