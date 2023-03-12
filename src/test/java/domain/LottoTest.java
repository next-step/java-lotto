package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.hamcrest.CoreMatchers.is;

import domain.Lotto;
import view.InputView;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class LottoTest {
    // 구입금액을 입력해 주세요.
    // 14000
    // 14개를 구매했습니다.
    // [8, 21, 23, 41, 42, 43]
    // [3, 5, 11, 16, 32, 38]
    // [7, 11, 16, 35, 36, 44]
    // [1, 8, 11, 31, 41, 42]
    // [13, 14, 16, 38, 42, 45]
    // [7, 11, 30, 40, 42, 43]
    // [2, 13, 22, 32, 38, 45]
    // [23, 25, 33, 36, 39, 41]
    // [1, 3, 5, 14, 22, 45]
    // [5, 9, 38, 41, 43, 44]
    // [2, 8, 9, 18, 19, 21]
    // [13, 14, 18, 21, 23, 35]
    // [17, 21, 29, 37, 42, 45]
    // [3, 8, 27, 30, 35, 44]

    // 지난 주 당첨 번호를 입력해 주세요.
    // 1, 2, 3, 4, 5, 6
    // 보너스 볼을 입력해 주세요.
    // 7

    // 당첨 통계
    // ---------
    // 3개 일치 (5000원)- 1개
    // 4개 일치 (50000원)- 0개
    // 5개 일치 (1500000원)- 0개
    // 5개 일치, 보너스 볼 일치(30000000원) - 0개
    // 6개 일치 (2000000000원)- 0개
    // 총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

    List<Lotto> lottoList;

    // @BeforeEach
    void getLottoNumber() {
        lottoList = new ArrayList<Lotto>();

        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("8, 21, 23, 41, 42,
        // 43")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("3, 5, 11, 16, 32,
        // 38")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("7, 11, 16, 35, 36,
        // 44")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("1, 8, 11, 31, 41,
        // 42")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("13, 14, 16, 38, 42,
        // 45")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("7, 11, 30, 40, 42,
        // 43")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("2, 13, 22, 32, 38,
        // 45")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("23, 25, 33, 36, 39,
        // 41")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("1, 3, 5, 14, 22, 45")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("5, 9, 38, 41, 43,
        // 44")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("2, 8, 9, 18, 19, 21")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("13, 14, 18, 21, 23,
        // 35")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("17, 21, 29, 37, 42,
        // 45")));
        // lottoList.add(new Lotto(LottoUtil.stringSplitToList("3, 8, 27, 30, 35,
        // 44")));

        // [8, 21, 23, 41, 42, 43]
        // [3, 5, 11, 16, 32, 38]
        // [7, 11, 16, 35, 36, 44]
        // [1, 8, 11, 31, 41, 42]
        // [13, 14, 16, 38, 42, 45]
        // [7, 11, 30, 40, 42, 43]
        // [2, 13, 22, 32, 38, 45]
        // [23, 25, 33, 36, 39, 41]
        // [1, 3, 5, 14, 22, 45]
        // [5, 9, 38, 41, 43, 44]
        // [2, 8, 9, 18, 19, 21]
        // [13, 14, 18, 21, 23, 35]
        // [17, 21, 29, 37, 42, 45]
        // [3, 8, 27, 30, 35, 44]
    }

    @DisplayName("숫자 1입력시 LottoNumber 객체 1 리턴 확인")
    @ParameterizedTest
    @ValueSource(ints = { 1 })
    void lottoNumberTest(int input) {
        var integer = Integer.valueOf(input);

        var number = new LottoNumber(integer);
        assertThat(number.getLottoNumber(), is(1));
    }

    @DisplayName("숫자 0,-1 입력시 lottoNumber 오류 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1 })
    void lottoNumberZeroTest(int input) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(input));

    }

    @DisplayName("45 이상 숫자 입력시 lottoNumber 오류 확인")
    @ParameterizedTest
    @ValueSource(ints = { 0, -1 })
    void lottoNumberOver45Test(int input) {
        assertThrows(IllegalArgumentException.class, () -> new LottoNumber(input));
    }

    @Test
    void test123() {
        int num[] = { 1, 2, 3, 4 };
        Collections.shuffle(Arrays.asList(num));

        System.out.println(Arrays.toString(num));
        Collections.shuffle(Arrays.asList(num));

        System.out.println(Arrays.toString(num));
    }

    @Test
    void setLottoNumberTest() {
        // var lotto = new Lotto();
        // lotto.setLottoNumber();
        // lotto.getLottoNumber().forEach(System.out::println);

        LottoNumbers lottoNumbers = new LottoNumbers();
        List<LottoNumber> lottoNumber = lottoNumbers.getNumbers();
        Collections.shuffle(lottoNumber);
        // lottoNumber.subList(0, 6).stream()
        // .sorted().toList();
        lottoNumber.subList(0, 6).forEach(it -> System.out.println(it.getLottoNumber()));

        System.out.println("=====================================");

        List<LottoNumber> newNumber = lottoNumber.subList(0, 6);
        // Collections.sort(newNumber, new Comparator<LottoNumber>() {
        // @Override
        // public int compare(LottoNumber o1, LottoNumber o2) {
        // return o1.getLottoNumber() - o2.getLottoNumber();
        // }
        // });
        Collections.sort(lottoNumber.subList(0, 6), (o1, o2) -> o1.getLottoNumber() - o2.getLottoNumber());
        newNumber.forEach(it -> System.out.println(it.getLottoNumber()));
    }

    @DisplayName("로또 출력 테스트")
    @Test
    void printLottoTest() {
        Lotto lotto = new Lotto();
        InputView.printLotto(lotto);

        lotto = new Lotto();
        InputView.printLotto(lotto);

        lotto = new Lotto();
        InputView.printLotto(lotto);

        lotto = new Lotto();
        InputView.printLotto(lotto);

        lotto = new Lotto();
        InputView.printLotto(lotto);

        lotto = new Lotto();
        InputView.printLotto(lotto);

    }

}
