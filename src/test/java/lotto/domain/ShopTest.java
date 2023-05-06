package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ShopTest {

    private static final String LOTTOS_SPLIT_SEPARATOR = "-";
    private static final String LOTTO_SPLIT_SEPARATOR = ",";
    private static final List<Integer> WIN_LOTTO_NUMBER = Arrays.asList(1,2,3,4,5,6);

    @ParameterizedTest(name = "buyPrice금액에 따라 lottoCount만큼 로또가 생성되야한다.")
    @CsvSource(value = {
            "11,12,13,14,18,19|1000|1",
            "1,2,3,14,18,19|1000|1",
            "1,2,3,4,8,9-1,2,3,4,5,6|2000|2",
            "11,12,13,17,18,19-11,12,13,14,15,16-11,12,13,14,15,17|3000|3",
    }, delimiter = '|')
    void 로또구매갯수검증(String buyLottos, int buyPrice, int lottoCount) {
        Shop shop = new Shop(new TestLottoGenerator(toLottos(buyLottos)));
        assertThat(shop.buy(buyPrice).size()).isEqualTo(lottoCount);
    }

    @ParameterizedTest(name = "입력한 로또번호에 따라 winMoney값과 당첨금액이 일치해야 한다.")
    @CsvSource(value = {
            "11,12,13,14,18,19|1000|0",
            "1,2,3,14,18,19|1000|5000",
            "1,2,3,4,8,9-1,2,3,4,5,6|2000|2000050000",
            "11,12,13,17,18,19-11,12,13,14,15,16-11,12,13,14,15,17|3000|0",
    }, delimiter = '|')
    void 로또당첨금액검증(String buyLottos, int buyPrice, int winMoney) {
        Shop shop = new Shop(new TestLottoGenerator(toLottos(buyLottos)));
        WinResult result = shop.win(shop.buy(buyPrice), WIN_LOTTO_NUMBER);
        assertThat(result.winMoney()).isEqualTo(winMoney);
    }

    private List<List<Integer>> toLottos(String lottos) {
        return Arrays.stream(lottos.split(LOTTOS_SPLIT_SEPARATOR))
                .map(lottoNumbers -> toLotto(lottoNumbers))
                .collect(Collectors.toList());
    }

    private List<Integer> toLotto(String lottoNumbers) {
        return Arrays.stream(lottoNumbers.split(LOTTO_SPLIT_SEPARATOR))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}