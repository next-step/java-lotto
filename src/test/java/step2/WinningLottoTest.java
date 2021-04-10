package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.*;

import java.util.*;

import static java.util.stream.Collectors.groupingBy;
import static org.assertj.core.api.Assertions.assertThat;

public class WinningLottoTest {

    @Test
    @DisplayName("지난 주 당첨번호 생성 테스트")
    void create_last_winning_lotto() {
        InputNumber inputNumber = new InputNumber("1,2,3,4,5,6");
        WinningLotto winningLotto = new WinningLotto(new Lotto(inputNumber), new LottoNumber(7));
        assertThat(winningLotto.getLottoNumberList().size()).isEqualTo(6);
    }

    @Test
    @DisplayName("지난주 당첨번호와 로또 리스트와 비교하여 맞는 개수 리턴 테스트")
    void lotto_compare() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers = new InputNumber("1,3,5,7,9,11");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusBall);
        Lotto purchasedLotto = new Lotto(purchasedNumbers);
        assertThat(winningLotto.getLottoNumberList().stream()
                .filter(winningNumber -> purchasedLotto.getLottoNumberList().contains(winningNumber))
                .count()).isGreaterThan(2);
    }

    @Test
    @DisplayName("지난주 당첨 번호와 몇 개 일치하는지 테스트 + 숫자 5개 맞췄을때(보너스볼 포함)")
    void statistic_test_number() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers = new InputNumber("1,2,3,4,5,7");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusBall);
        Lotto purchasedLotto = new Lotto(purchasedNumbers);
        assertThat(purchasedLotto.isWinningLottoList(winningLotto)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    @DisplayName("숫자 5개 맞췄을때(보너스볼 포함)")
    void bonus_five_include_bonus_number() {
        assertThat(LottoPrize.valueOf(new HitCount(5),true)).isEqualTo(LottoPrize.SECOND);
    }

    @Test
    @DisplayName("숫자 5개 맞췄을때(보너스볼 미포함) && 4개 맞췄을때, 하나도 안걸렸을때")
    void bonus_five_exclude_bonus_number() {
        assertThat(LottoPrize.valueOf(new HitCount(5),false)).isEqualTo(LottoPrize.THIRD);
        assertThat(LottoPrize.valueOf(new HitCount(4),false)).isEqualTo(LottoPrize.FOURTH);
        assertThat(LottoPrize.valueOf(new HitCount(4),true)).isEqualTo(LottoPrize.FOURTH);
        assertThat(LottoPrize.valueOf(new HitCount(2),true)).isEqualTo(LottoPrize.BLANK);
        assertThat(LottoPrize.valueOf(new HitCount(2),false)).isEqualTo(LottoPrize.BLANK);
    }

    @Test
    @DisplayName("지난주 당첨 번호와 몇 개 일치했는지 통계 생성 테스트 - 3개일치 1개, 4개 일치 1개")
    void statistic_test() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,43,44,45");
        InputNumber purchasedNumbers2 = new InputNumber("1,2,3,4,44,45");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), bonusBall);
        LottoNumberGenerator generator = () -> Arrays.asList(new Lotto(purchasedNumbers1),
                new Lotto(purchasedNumbers2));

        Lottos lottos = Lottos.of(new MergeGenerator(Arrays.asList(generator)));

        Map<LottoPrize, List<Lotto>> rankInfo = lottos.getLottos().stream()
                .collect(groupingBy(lotto -> lotto.isWinningLottoList(winningLotto)));

        assertThat(rankInfo.keySet()).contains(LottoPrize.FIFTH, LottoPrize.FOURTH);
    }

    @Test
    @DisplayName("당첨 된 통계 리스트 개수 테스트")
    void statistic_test_size() {
        InputNumber winningNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber purchasedNumbers1 = new InputNumber("1,2,3,43,44,45");
        LottoNumber bonusBall = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers),bonusBall);
        LottoNumberGenerator generator = () -> Arrays.asList(new Lotto(purchasedNumbers1));
        Lottos lottoList = Lottos.of(new MergeGenerator(Arrays.asList(generator)));

        Rank rankInfo = new Rank(lottoList.getLottos().stream()
                .collect(groupingBy(lotto -> lotto.isWinningLottoList(winningLotto))));

        assertThat(rankInfo.size(LottoPrize.FIFTH)).isEqualTo(1);
        assertThat(rankInfo.size(LottoPrize.FOURTH)).isEqualTo(0);

    }
}
