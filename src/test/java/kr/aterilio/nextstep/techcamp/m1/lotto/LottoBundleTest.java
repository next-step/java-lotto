package kr.aterilio.nextstep.techcamp.m1.lotto;

import kr.aterilio.nextstep.techcamp.m1.utils.LottoParser;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoBundleTest {

    public static final String SPLIT_TOKEN_LOTTERIES = "\\|";

    @DisplayName("로또 구입 금액을 입력받으면 로또를 구매한다. (1000원당 1장)")
    @ParameterizedTest
    @CsvSource(value = {"3000,3", "14000,14", "8000,8"})
    public void buyLotto(int money, int count) {
        LottoBundle lottoBundle = new LottoBundle(money);
        assertThat(lottoBundle.count()).isEqualTo(count);
    }

    @DisplayName("로또 구입 금액이 음수이면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-2000, -5000, -100})
    public void buyLottoFailed(int money) {
        assertThatThrownBy(() -> {
            new LottoBundle(money);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("0원 이상");
    }

    @DisplayName("'수동으로 구매할 로또 수'가 구매 금액으로 구매할 수 있는 것보다 클 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000_2_1,2,3,4,5,6|1,2,3,4,5,7"}, delimiter = '_')
    public void buyLottoFailed_insufficientMoney(int money, int manualCount, String manualBuyLotto) {
        List<Lotto> lotteries = parseLottoList(manualBuyLotto);
        assertThatThrownBy(() -> {
            new LottoBundle(money, new LottoBundle(manualCount, lotteries));
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("충분하지 않습니다");
    }

    @DisplayName("입력한 추첨 번호의 갯수가 '수동으로 구매할 로또 수' 와 일치하지 않을 경우 예외가 발생한다.")
    @ParameterizedTest
    @CsvSource(value = {"2000_2_1,2,3,4,5,6"}, delimiter = '_')
    public void buyLottoFailed_insufficientCount(int money, int manualCount, String manualBuyLotto) {
        List<Lotto> lotteries = parseLottoList(manualBuyLotto);
        assertThatThrownBy(() -> {
            new LottoBundle(manualCount, lotteries);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("일치하지 않습니다");
    }

    @DisplayName("'수동으로 구매할 로또 수' 만큼의 금액을 제외한 잔액만큼 추첨 번호를 자동으로 추첨하여 구매한다.")
    @ParameterizedTest
    @CsvSource(value = {
            "2000_1_1,2,3,4,5,6_2",
            "4000_1_1,2,3,4,5,6_4",
    }, delimiter = '_')
    public void buyLotto_withManual(int money, int manualCount, String manualBuyLotto, int totalCount) {
        List<Lotto> lotteries = parseLottoList(manualBuyLotto);
        LottoBundle manualLottoBundle = new LottoBundle(manualCount, lotteries);
        LottoBundle lottoBundle = new LottoBundle(money, manualLottoBundle);
        assertThat(lottoBundle.count()).isEqualTo(totalCount);
    }

    private List<Lotto> parseLottoList(String manualBuyLotto) {
        String[] splits = manualBuyLotto.split(SPLIT_TOKEN_LOTTERIES);
        List<Lotto> list = new ArrayList<>();
        for (String split : splits) {
            list.add(new Lotto(LottoParser.parse(split)));
        }
        return list;
    }
}
