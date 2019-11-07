package lotto.domain;

import lotto.LottoOrder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

/**
 * @author : 김윤호
 * @version : 1.0
 * @date : 2019-11-02 21:43
 */
public class LottoTest {

    @Test
    void create_lotto_test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isNotEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void create_lotto_number_test() {
        LottoNumberStrategy lottoNumberStrategy = new LottoNumberStrategy();
        List<Integer> lottoNumbers = lottoNumberStrategy.generateLottoNumber();
        assertThat(lottoNumbers).hasSize(6);
        assertThat(lottoNumbers).allMatch(value -> value >= 1 && value <= 45);
    }

    @Test
    void lotto_shuffle_test() {
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto).isNotEqualTo(new Lotto(Arrays.asList(1,2,3,4,5,6)));
    }

    @Test
    void create_amount_test() {
        LottoAmount amount = new LottoAmount(14000);
        assertThat(amount).isEqualTo(new LottoAmount(14000));
    }

    @Test
    void get_purchased_lotto_count() {
        LottoAmount amount = new LottoAmount(14000);
        assertThat(amount.getPurchasedLottoCount()).isEqualTo(14);
    }

    @Test
    void 로또_적은_금액으로_사보기() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            LottoAmount amount = new LottoAmount(500);
        }).withMessageMatching("건네주신 금액으로는 로또를 살 수 없습니다.");
    }

    @Test
    void 구매된_로또_갯수() {
        LottoOrder lottoOrder = new LottoOrder(14000);
        assertThat(lottoOrder.getLottoAmount()).isEqualTo(14);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "2,3,4,5", "3,a,b,c,de,f"})
    void input_lotto_number_test(String lottoNumber) {
        String[] numbers = lottoNumber.split(",");
        for (String number : numbers) {
            is_number(number);
            check_lotto_number_range(Integer.parseInt(number));
        }

        assertThat(numbers).hasSize(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void check_lotto_number_range(int number) {
        final int minValue = 1;
        final int maxValue = 45;
        assertThat(number >= minValue && number <= maxValue).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2"})
    void is_number(String number) {
        final Pattern NUMERIC = Pattern.compile("^[0-9]+$");
        assertThat(NUMERIC.matcher(number).matches()).isTrue();
    }

    @Test
    void 당첨조회_객체_생성() {
        Integer[] number = {1,2,3,4,5,6};
        List<Integer> winningNumbers = Arrays.asList(number);
        WinningNumber checkWinningNumber = new WinningNumber(winningNumbers);
        assertThat(checkWinningNumber).isEqualTo(new WinningNumber(winningNumbers));
    }
    
    @Test
    void 당첨조회() {
        Integer[] number = {1,2,3,4,5,6};
        List<Integer> winningNumbers = Arrays.asList(number);
        Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));
        assertThat(lotto.matchLottoNumberCount(winningNumbers)).isEqualTo(6);
    }
}

