package lotto;

import lotto.domain.LottoGame;
import lotto.domain.LottoShop;
import lotto.domain.Money;
import lotto.domain.Numbers;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LottoShopTest {
    @DisplayName("입력한 금액만큼 로또 게임을 생성한다")
    @Test
    public void make() {
        LottoShop lottoShop = new LottoShop();
        lottoShop.purchase(new Money(14500));

        assertThat(lottoShop.getGameCount()).isEqualTo(14);
    }

    @DisplayName("수동 게임 생성")
    @Test
    public void create_수동() {
        List<Numbers> numbers = new ArrayList<>();
        Numbers numbers1 = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = new Numbers(Arrays.asList(7, 8, 9, 10, 11, 12));
        Numbers numbers3 = new Numbers(Arrays.asList(12, 13, 14, 15, 16, 17));
        numbers.add(numbers1);
        numbers.add(numbers2);
        numbers.add(numbers3);

        LottoShop lottoShop = new LottoShop();
        lottoShop.purchase(new Money(3000), numbers);

        AssertionsForInterfaceTypes.assertThat(lottoShop.getLottoGames())
                .contains(
                        new LottoGame(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoGame(new Numbers(Arrays.asList(7, 8, 9, 10, 11, 12))),
                        new LottoGame(new Numbers(Arrays.asList(12, 13, 14, 15, 16, 17))));
    }

    @DisplayName("자동 수동 게임 생성")
    @Test
    public void create_자동수동() {
        List<Numbers> numbers = new ArrayList<>();
        Numbers numbers1 = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = new Numbers(Arrays.asList(7, 8, 9, 10, 11, 12));
        Numbers numbers3 = new Numbers(Arrays.asList(12, 13, 14, 15, 16, 17));
        numbers.add(numbers1);
        numbers.add(numbers2);
        numbers.add(numbers3);

        LottoShop lottoShop = new LottoShop();
        lottoShop.purchase(new Money(10000), numbers);

        AssertionsForInterfaceTypes.assertThat(lottoShop.getLottoGames())
                .contains(
                        new LottoGame(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoGame(new Numbers(Arrays.asList(7, 8, 9, 10, 11, 12))),
                        new LottoGame(new Numbers(Arrays.asList(12, 13, 14, 15, 16, 17))));

        assertThat(lottoShop.getAutoGameCount()).isEqualTo(7);
    }
}
