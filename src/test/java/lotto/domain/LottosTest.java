package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static lotto.domain.WinningTest.WINNING_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private static int LOTTO_LIST_SIZE = 10;
    private static int LOTTO_SIZE = 6;
    private static int LOTTO_BOUND = 45;

    private Lottos lottos;
    private List<Lotto> lottoList = new ArrayList<>();


    @BeforeEach
    void setUp() {
        Random random = new Random();
        for (int i = 0; i < LOTTO_LIST_SIZE; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < LOTTO_SIZE; j++) {
                numbers.add(1 + random.nextInt(LOTTO_BOUND));
            }
            lottoList.add(new Lotto(numbers));
        }

        lottos = new Lottos(lottoList);
    }

    @Test
    void createTest() {
        assertThat(lottos).isEqualTo(new Lottos(lottoList));
    }

    @Test
    void toStringTest() {
        System.out.println(lottos.toString());
    }

    @Test
    @DisplayName("당첨번호를 확인해서 당첨 개수만큼 match 수를 늘리는지 확인하는 테스트")
    void checkWinningTest() {
        //given
        List<Integer> winningNumbers = new ArrayList<>();
        for (int i = 1; i <= WINNING_SIZE; i++) {
            winningNumbers.add(i);
        }
        Winning winning = new Winning(winningNumbers);
        Winning predictWinning = new Winning(winningNumbers, new int[]{0, 0, 0, 0, 1, 1, 1});
        Lottos testLottos = makeWinningLottos(winningNumbers);

        //when
        testLottos.checkWinning(winning);

        //then
        assertThat(winning).isEqualTo(predictWinning);
    }


    /*
     * 임의의 6개, 5개, 4개 당첨 로또를 만드는 메소드
     * */
    Lottos makeWinningLottos(List<Integer> winningNumbers) {
        List<Lotto> testLottoList = new ArrayList<>();

        testLottoList.add(new Lotto(winningNumbers));   //6개 당첨
        for (int i = 1; i <= 2; i++) {   //5개, 4개 당첨
            testLottoList.add(new Lotto(changeNumbers(winningNumbers, i)));
        }

        return new Lottos(testLottoList);
    }

    /*
    * 번호를 하나씩 늘려주는 메소드 (로또번호 변경용으로 이용)
    * */
    List<Integer> changeNumbers(List<Integer> numbers, int index) {
        return numbers.stream().map(num -> {
            return num + index;
        }).collect(Collectors.toList());
    }
}
