package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    Lotto lotto;

    private static final String DELIMITER = ", ";

    private static final int LOTTO_PRICE = 1000;

    private static int LOTTO_PURCHASE_PRICE;

    @BeforeEach
    void setUp() {
        lotto = new Lotto();
    }
    @DisplayName("로또금액이 1000원 이상이어야 한다.")
    @ParameterizedTest
    @ValueSource(ints = {500,0})
    public void 로또금액체크(final int number){
        assertThatExceptionOfType(IllegalStateException.class)
                .isThrownBy(() -> lotto.getLottoCount(number));
    }
    @DisplayName("로또 금액에 따른 로또티켓 갯수 체크")
    @Test
    public void 로또갯수체크(){
        assertThat(lotto.getLottoNumberList(lotto.getLottoCount(13000)).size()).isEqualTo(13);
    }
    @DisplayName("로또 당첨번호 입력값 리스트로 생성")
    @Test
    public void 로또당첨번호리스트생성(){
        String[] numberArr = "1, 2, 3, 4, 6, 10".split(DELIMITER);
        List<Integer> list = lotto.getWinnerNumbers(numberArr);

        assertThat(list).asList().contains(1, 2, 3, 4, 6, 10);
    }

    @DisplayName("로또 당첨번호 입력값 6개가 아닐경우")
    @Test
    public void 로또당첨번호갯수체크(){
        String[] numberArr = "1, 2, 3, 4, 6, 10, 12".split(DELIMITER);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->lotto.getWinnerNumbers(numberArr));

    }

    @DisplayName("로또 당첨번호 입력값 0~45 사이 값아닐경우")
    @Test
    public void 로또당첨번호범위체크(){
        String[] numberArr = "1, 2, 3, 4, 6, 50".split(DELIMITER);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->lotto.getWinnerNumbers(numberArr));

    }
    @DisplayName("로또 번호가 중복될 경우")
    @Test
    public void 로또당첨번호중복체크(){
        String[] numberArr = "1, 2, 3, 4, 6, 2".split(DELIMITER);

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(()->lotto.getWinnerNumbers(numberArr));
    }
    @DisplayName("5등 확인")
    @Test
    public void 당첨5등확인(){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        List<Integer> lottoNumber = List.of(1,2,3,9,10,11);
        lottoNumberList.add(lottoNumber);
        List<Integer> winnerNumbers = List.of(1,2,3,4,5,6);

        lotto.winnerCheck(lottoNumberList,winnerNumbers,7);

        assertThat(Winner.FIFTH.getWinnerCount()).isEqualTo(1);
    }

    @DisplayName("4등 확인")
    @Test
    public void 당첨4등확인(){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        List<Integer> lottoNumber = List.of(1,2,3,4,10,11);
        lottoNumberList.add(lottoNumber);
        List<Integer> winnerNumbers = List.of(1,2,3,4,5,6);

        lotto.winnerCheck(lottoNumberList,winnerNumbers,7);

        assertThat(Winner.FOURTH.getWinnerCount()).isEqualTo(1);
    }

    @DisplayName("3등 확인")
    @Test
    public void 당첨3등확인(){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        List<Integer> lottoNumber = List.of(1,2,3,4,5,11);
        lottoNumberList.add(lottoNumber);
        List<Integer> winnerNumbers = List.of(1,2,3,4,5,6);

        lotto.winnerCheck(lottoNumberList,winnerNumbers,7);

        assertThat(Winner.THIRD.getWinnerCount()).isEqualTo(1);
    }

    @DisplayName("2등 확인")
    @Test
    public void 당첨2등확인(){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        List<Integer> lottoNumber = List.of(1,2,3,4,5,7);
        lottoNumberList.add(lottoNumber);
        List<Integer> winnerNumbers = List.of(1,2,3,4,5,6);
        lotto.winnerCheck(lottoNumberList,winnerNumbers,7);

        assertThat(Winner.SECOND.getWinnerCount()).isEqualTo(1);
    }

    @DisplayName("1등 확인")
    @Test
    public void 당첨1등확인(){
        List<List<Integer>> lottoNumberList = new ArrayList<>();
        List<Integer> lottoNumber = List.of(1,2,3,4,5,6);
        lottoNumberList.add(lottoNumber);
        List<Integer> winnerNumbers =List.of(1,2,3,4,5,6);

        lotto.winnerCheck(lottoNumberList,winnerNumbers,7);

        assertThat(Winner.FIRST.getWinnerCount()).isEqualTo(1);
    }

}