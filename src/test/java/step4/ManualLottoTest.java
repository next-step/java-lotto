package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.Domain.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ManualLottoTest {
    @Test
    @DisplayName("수동로또 생성 테스트")
    void manual_lotto_test(){
        String manualNumbers = "1,2,3,4,5,6";
        assertThat(new Lotto(new InputNumber(manualNumbers))).isEqualTo(new Lotto(new InputNumber(manualNumbers)));
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 6개가 아닐 경우")
    void manual_lotto_test_6개가_아닐_경우(){
        String manualNumbers = "1,2,3,4,5,6,7";
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(new InputNumber(manualNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 중복일 경우")
    void manual_lotto_test_중복일_경우(){
        String manualNumbers = "1,2,3,4,5,5";
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(new InputNumber(manualNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 문자가 들어간 경우")
    void manual_lotto_test_문자가_들어간_경우(){
        String manualNumbers = "1,2,3,4,a,5";
        assertThatThrownBy(()->{
            Lotto lotto = new Lotto(new InputNumber(manualNumbers));
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("수동로또 생성 테스트, 입력한 숫자만큼 로또 번호 생성하는 테스트")
    void manual_lotto_test_입력한_숫자만큼_생성(){
        InputNumber manualNumbers = new InputNumber("1,2,3,4,5,6");
        InputNumber manualNumbers2 = new InputNumber("1,22,33,40,41,42");
        InputNumber manualNumbers3 = new InputNumber("1,15,23,40,43,45");
        Lottos manualLottos = Lottos.of(new ManualLottoGenerator(Arrays.asList(manualNumbers,manualNumbers2,manualNumbers3)));
        assertThat(manualLottos.getLottos()).contains(new Lotto(manualNumbers),new Lotto(manualNumbers2),new Lotto(manualNumbers3));
    }

    @Test
    @DisplayName("수동로또와 자동로또 결과를 합치는 테스트")
    void manual_lotto_test_수동로또와_자동로또_결과를_합치는_테스트(){
        InputNumber winningNumbers = new InputNumber("1,2,3,10,20,30");
        InputNumber manualNumbers = new InputNumber("1,2,3,10,20,30");
        InputNumber manualNumbers2 = new InputNumber("1,2,3,10,20,7");
        InputNumber manualNumbers3 = new InputNumber("1,2,3,40,43,45");
        Lottos manualLottos = Lottos.of(new ManualLottoGenerator(Arrays.asList(manualNumbers,manualNumbers2,manualNumbers3)));
        Lottos autoLottos = Lottos.of(new RandomLottoNumberGenerator(new Money(5000)));
        WinningLotto winningLotto = new WinningLotto(new Lotto(winningNumbers), new LottoNumber(7));
        Rank manualRank = manualLottos.makeStatistic(winningLotto);
        Rank autoRank = autoLottos.makeStatistic(winningLotto);

        Map<LottoPrize, List<Lotto>> mergedLotto = Stream.of(manualRank, autoRank)
                .flatMap(mergedMap -> mergedMap.getRank().entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        v -> new ArrayList<>(v.getValue()),
                        (left, right) -> {left.addAll(right); return left;}
                ));

        assertThat(mergedLotto.keySet()).contains(LottoPrize.FIRST,LottoPrize.SECOND,LottoPrize.FIFTH);
        Rank mergeRank = new Rank(mergedLotto);
        assertThat(Arrays.stream(LottoPrize.values())
                .mapToInt(lottoPrize -> mergeRank.size(lottoPrize))
                .sum()).isEqualTo(8);
    }

}
