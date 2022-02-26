package lotto.domain;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    @DisplayName("로또의_개수_사이즈_확인_테스트")
    @Test
    void countLottoCount() {
        List<Lotto> lottos = LottoGenerator.lottoBundle(5, new NonShuffleLottoNumber());
        assertThat(lottos.size()).isEqualTo(5);
    }

    @DisplayName("로또_구입_테스트")
    @Test
    void purchaseLottoTest() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Lotto lotto_two = new Lotto(Arrays.asList(7,8,9,10,11,12)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));

        Lotto lotto_three = new Lotto(Arrays.asList(13,14,15,16,17,18)
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
        List<Lotto> lottto = new ArrayList<>();

        lottto.add(lotto);
        lottto.add(lotto_two);
        lottto.add(lotto_three);

        Lottos lottos = new Lottos();
        lottos.purchaseLottos(lottto, "3", new Money(14000));

        assertThat(
            lottos.purchaseLottos(lottto, "3", new Money(14000))
        ).isEqualTo(11);
    }
}
