package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @DisplayName("N개의 로또를 가진 로또 그룹 생성이 가능하다")
    @Test
    void createLottoGruop() {
        LottoNumbersGenerater numbersGenerater = new RandomNumbersGenerater();
        Lottos lottos = Lottos.create(3, numbersGenerater);

        assertThat(lottos.count()).isEqualTo(3);
    }

    @DisplayName("로또 번호와 당첨번호와 비교하여 당첨번호와 같은 숫자의 갯수를 알 수 있다")
    @Test
    void countMatchingNumbers(){
        Lottos lottos = createLottos();
        WinningNumbers winningNumbers = new WinningNumbers(
                convertIntToLottoNumber(1, 2, 3, 4, 5, 6),
                new BonusBall(45));

        /*
        첫번째 복권 당첨번호와 번호 같은 갯수 : 6
        두번째 복권 당첨번호와 번호 같은 갯수 : 0
        */
        assertThat(lottos.countMatchingNumbers(winningNumbers)).containsExactly(6, 0);
    }

    @DisplayName("로또 번호들과 보너스볼 번호를 비교하여 일치 여부 목록을 알 수 있다")
    @Test
    void matchingBonusNumbers(){
        Lottos lottos = createLottos();
        WinningNumbers winningNumbers = new WinningNumbers(
                convertIntToLottoNumber(2, 3, 4, 5, 6, 7),
                new BonusBall(1));

        assertThat(lottos.matchingBonusNumbers(winningNumbers)).containsExactly(true, false);
    }



    @DisplayName("로또들을 출력할 수 있다")
    @Test
    void showLottos(){
        Lottos lottos = createLottos();
        String printLotto = lottos.showLottos();

        assertThat(printLotto).isEqualTo("[1, 2, 3, 4, 5, 6]\n[7, 8, 9, 10, 11, 12]\n");
    }

    @DisplayName("로또 그룹들을 합칠 수 있다")
    @Test
    void addLottos(){
        LottoNumbersGenerater numbersGenerater = new RandomNumbersGenerater();
        Lottos lottos = Lottos.create(1, numbersGenerater);
        Lottos otherLottos = Lottos.create(2, numbersGenerater);

        lottos.add(otherLottos);

        assertThat(lottos.count()).isEqualTo(3);
    }


    private Lottos createLottos() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(1, 2, 3, 4, 5, 6)
                        , new Lotto(7, 8, 9, 10, 11, 12)
                )
        );
        return lottos;
    }

    private Set<LottoNumber> convertIntToLottoNumber(int... numbers){
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(toSet());
    }
}
