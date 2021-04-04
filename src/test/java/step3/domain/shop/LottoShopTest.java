package step3.domain.shop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.LottoNumber;
import step3.strategy.LottoShuffleStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LottoShopTest {

    private List<Lotto> lottos;

    @BeforeEach
    void beforeEach(){
        Set<LottoNumber> lottoNumbers = IntStream.range(1, 7)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toCollection(TreeSet::new));

        Lotto lotto = Lotto.of(lottoNumbers);
        lottos = new ArrayList<>();
        lottos.add(lotto);
    }

    @DisplayName("LottoShop 인스턴스 생성 여부 테스트")
    @Test
    void 생성() {

        // when
        LottoShop lottoShop = LottoShop.getInstance();

        // then
        assertThat(lottoShop).isNotNull();
    }

    @DisplayName("LottoShop 인스턴스 로또 반환 여부 테스트")
    @Test
    void 반환_로또() {
        // given
        LottoShuffleStrategy strategy = lottoNumbers -> {};
        int money = 1000;
        int expected = 1;

        // when
        LottoShop lottoShop = LottoShop.getInstance();
        List<Lotto> lottos = lottoShop.buyLottos(money, strategy);

        // then
        assertAll(
                () -> assertThat(lottos).isNotNull(),
                () -> assertThat(lottos.size()).isEqualTo(expected)
        );
    }

    @DisplayName("LottoShop 인스턴스 정렬된 로또 반환 여부 테스트")
    @Test
    void 반환_로또_셔플() {
        // given
        LottoShuffleStrategy strategy = lottoNumbers -> Collections.sort(lottoNumbers);
        List<Lotto> expected = lottos;
        int money = 1000;


        // when
        LottoShop lottoShop = LottoShop.getInstance();
        List<Lotto> actual = lottoShop.buyLottos(money, strategy);

        // then
        assertThat(actual).isEqualTo(expected);
    }

}