package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {

    @DisplayName("로또 1장은 1000원")
    @Test
    void 금액만큼_로또구매() {
        Store store = new Store();
        Person person = new Person(10000);
        store.sellTo(person);
        assertThat(person.numberOfLotto()).isEqualTo(10);
    }

    @DisplayName("당첨번호와 로또번호는 몇 개 일치하는지 확인")
    @Test
    void 당첨번호와_로또번호_일치하는숫자() {
        Lotto lotto = new Lotto(LottoNumber.of(Arrays.asList(3, 4, 10, 11, 12, 45)));
        List<Integer> winningNumbers = Arrays.asList(2, 10, 11, 18, 35, 45);

        assertThat(lotto.matchedCount(winningNumbers)).isEqualTo(3);
    }

    @DisplayName("당첨번호와 3개 일치하는 로또 개수는 1개이다")
    @Test
    void 당첨통계_당첨된로또개수() {
        List<Integer> number1 = Arrays.asList(1, 2, 3, 6, 7, 10);
        List<Integer> number2 = Arrays.asList(6, 7, 8, 9, 10, 11);
        List<Lotto> lottos = Arrays.asList(new Lotto(LottoNumber.of(number1)), new Lotto(LottoNumber.of(number2)));
        Person person = new Person(2000, lottos);

        List<Integer> winningNumber = Arrays.asList(6, 7, 8, 22, 23, 24);
        LottoStatistics statistics = new LottoStatistics(person, winningNumber);

        assertThat(statistics.numberOfWinningLotto(3)).isEqualTo(1);
    }

    @DisplayName("아래의 로또를 가지고 있으면 수익률은 0.35다")
    @Test
    void 수익률() {
        List<Integer> number1 = Arrays.asList(8, 21, 23, 41, 42, 43);
        List<Integer> number2 = Arrays.asList(3, 5, 11, 16, 32, 38);
        List<Integer> number3 = Arrays.asList(7, 11, 16, 35, 36, 44);
        List<Integer> number4 = Arrays.asList(1, 8, 11, 31, 41, 42);
        List<Integer> number5 = Arrays.asList(13, 14, 16, 38, 42, 45);
        List<Integer> number6 = Arrays.asList(7, 11, 30, 40, 42, 43);
        List<Integer> number7 = Arrays.asList(2, 13, 22, 32, 38, 45);
        List<Integer> number8 = Arrays.asList(23, 25, 33, 36, 39, 41);
        List<Integer> number9 = Arrays.asList(1, 3, 5, 14, 22, 45);
        List<Integer> number10 = Arrays.asList(5, 9, 38, 41, 43, 44);
        List<Integer> number11 = Arrays.asList(2, 8, 9, 18, 19, 21);
        List<Integer> number12 = Arrays.asList(13, 14, 18, 21, 23, 35);
        List<Integer> number13 = Arrays.asList(17, 21, 29, 37, 42, 45);
        List<Integer> number14 = Arrays.asList(3, 8, 27, 30, 35, 44);

        List<Lotto> lottos = Arrays.asList(
                new Lotto(LottoNumber.of(number1)),
                new Lotto(LottoNumber.of(number2)),
                new Lotto(LottoNumber.of(number3)),
                new Lotto(LottoNumber.of(number4)),
                new Lotto(LottoNumber.of(number5)),
                new Lotto(LottoNumber.of(number6)),
                new Lotto(LottoNumber.of(number7)),
                new Lotto(LottoNumber.of(number8)),
                new Lotto(LottoNumber.of(number9)),
                new Lotto(LottoNumber.of(number10)),
                new Lotto(LottoNumber.of(number11)),
                new Lotto(LottoNumber.of(number12)),
                new Lotto(LottoNumber.of(number13)),
                new Lotto(LottoNumber.of(number14))
        );
        Person person = new Person(14000, lottos);

        List<Integer> winningNumber = Arrays.asList(1, 2, 3, 4, 5, 6);
        LottoStatistics statistics = new LottoStatistics(person, winningNumber);

        assertThat(statistics.profitRate()).isEqualTo(0.35);
    }

    @DisplayName("로또가격보다 적은 구입금액 입력시 예외")
    @Test
    void 잔액부족() {
        Store store = new Store();
        Person person = new Person(500);

        assertThatThrownBy(() -> store.sellTo(person))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잔액이 부족합니다.");
    }

}
