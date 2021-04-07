package lotto;

import lotto.domain.*;
import org.assertj.core.api.AssertionsForInterfaceTypes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class LottoShopTest {
    @DisplayName("입력한 금액만큼 로또 게임을 생성한다")
    @Test
    public void make() {
        LottoShop lottoShop = new LottoShop(new Money(14500), new DefaultNumberService(new ArrayList<>(0)));

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

        LottoShop lottoShop = new LottoShop(new Money(3000), new DefaultNumberService(numbers));

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

        Money payMoney = new Money(10000);
        LottoShop lottoShop = new LottoShop(payMoney, new DefaultNumberService(numbers));
        Money autoMoney = payMoney.remainMoney(numbers.size());

        AssertionsForInterfaceTypes.assertThat(lottoShop.getLottoGames())
                .contains(
                        new LottoGame(new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6))),
                        new LottoGame(new Numbers(Arrays.asList(7, 8, 9, 10, 11, 12))),
                        new LottoGame(new Numbers(Arrays.asList(12, 13, 14, 15, 16, 17))));

        assertThat(autoMoney.lottoGameCount()).isEqualTo(7);
    }

    @DisplayName("2000원으로 수동 게임을 3게임 입력시 예외를 반환한다.")
    @Test
    public void limit() {
        List<Numbers> numbers = new ArrayList<>();
        Numbers numbers1 = new Numbers(Arrays.asList(1, 2, 3, 4, 5, 6));
        Numbers numbers2 = new Numbers(Arrays.asList(7, 8, 9, 10, 11, 12));
        Numbers numbers3 = new Numbers(Arrays.asList(12, 13, 14, 15, 16, 17));
        numbers.add(numbers1);
        numbers.add(numbers2);
        numbers.add(numbers3);

        assertThatThrownBy(() -> {
            new LottoShop(new Money(2000), new DefaultNumberService(numbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
