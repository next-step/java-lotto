package lotto.domain;

import lotto.exception.InvalidLottoLengthException;
import lotto.util.Utility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class LottoTest {
    @DisplayName("로또 생성을 위해서 유효 길이(6)의 리스트가 인자로 전달되어야 한다.")
    @Test
    void 로또_생성_성공() {
        List<Integer> lottoNumbers = Arrays.asList(new Integer[]{1, 3, 4, 7, 22, 59});
        Lotto lotto = new Lotto(lottoNumbers);

        assertThat(lotto.getLottoNumbers().size()).isEqualTo(6);
    }

    @DisplayName("유효 길이(6)의 리스트가 인자로 전달되지 않는 경우 로또 생성 실패한다.")
    @Test
    void 로또_생성_실패() {
        assertThatThrownBy(() -> {
            List<Integer> lottoNumbers = Arrays.asList(new Integer[]{1, 3, 4, 7, 22, 59, 60});
            Lotto lotto = new Lotto(lottoNumbers);
        }).isInstanceOf(InvalidLottoLengthException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1, 4, 5, 17, 27, 39:3", "8, 14, 19, 28, 35, 39:2"}, delimiter = ':')
    void 로또_중복_개수_테스트(String previousLottoString, int duplicated) {
        List<Integer> lottoNumber = Arrays.asList(new Integer[]{5,27,29,35,39,44});
        Lotto lotto = new Lotto(lottoNumber);

        String[] previousLottoStringList = Utility.split(previousLottoString);
        Integer[] previousLottoIntegerList = Utility.convertStringArrayToIntegerArray(previousLottoStringList);
        Lotto previousLotto = new Lotto(previousLottoIntegerList);

        assertThat(lotto.countDuplicateValue(previousLotto)).isEqualTo(duplicated);
    }

    @Test
    void 로또_정렬_반환_테스트() {
        assertAll(
                () -> {
                    String[] unsortedLottoStrings = Utility.split("39, 4, 27, 17, 5, 1");
                    Integer[] unsortedLottoNumbers = Utility.convertStringArrayToIntegerArray(unsortedLottoStrings);
                    Lotto unsortedLotto = new Lotto(unsortedLottoNumbers);

                    assertFalse(unsortedLotto.getLottoNumbers().toString().equals("[1, 5, 4, 17, 27, 39]"));
                },
                () -> {
                    String[] unsortedLottoStrings = Utility.split("39, 4, 27, 17, 5, 1");
                    Integer[] unsortedLottoNumbers = Utility.convertStringArrayToIntegerArray(unsortedLottoStrings);
                    Lotto unsortedLotto = new Lotto(unsortedLottoNumbers);

                    assertTrue(unsortedLotto.getLottoNumbers().toString().equals("[1, 4, 5, 17, 27, 39]"));
                }
        );
    }

    @Test
    void 로또_당첨_타입_반환_테스트() {
        List<Integer> lottoNumber = Arrays.asList(new Integer[]{5,27,29,35,39,44});
        Lotto lotto = new Lotto(lottoNumber);

        assertAll(
                () -> {
                    List<Integer> previousLottoNumber = Arrays.asList(new Integer[]{5,28,29,35,39,44});
                    Lotto previousLotto = new Lotto(previousLottoNumber);
                    int bonusNumber = 28;

                    assertThat(lotto.winLotto(previousLotto, bonusNumber)).isEqualTo(LottoWinnerType.valueOf(5, false));
                },
                () -> {
                    List<Integer> previousLottoNumber = Arrays.asList(new Integer[]{5,28,29,35,39,44});
                    Lotto previousLotto = new Lotto(previousLottoNumber);
                    int bonusNumber = 27;

                    assertThat(lotto.winLotto(previousLotto, bonusNumber)).isEqualTo(LottoWinnerType.valueOf(5, true));
                },
                () -> {
                    List<Integer> previousLottoNumber = Arrays.asList(new Integer[]{4,28,29,35,39,44});
                    Lotto previousLotto = new Lotto(previousLottoNumber);
                    int bonusNumber = 4;

                    assertThat(lotto.winLotto(previousLotto, bonusNumber)).isEqualTo(LottoWinnerType.valueOf(4, false));
                }
        );
    }

    @Test
    void 로또_당첨_상금_반환_테스트() {
        List<Integer> lottoNumber = Arrays.asList(new Integer[]{5,27,29,35,39,44});
        Lotto lotto = new Lotto(lottoNumber);

        assertAll(
                () -> {
                    List<Integer> previousLottoNumber = Arrays.asList(new Integer[]{5,28,29,35,39,44});
                    Lotto previousLotto = new Lotto(previousLottoNumber);
                    int bonusNumber = 28;

                    assertThat(lotto.winLotto(previousLotto, bonusNumber).getPrize()).isEqualTo(LottoWinnerType.prize(5, false));
                },
                () -> {
                    List<Integer> previousLottoNumber = Arrays.asList(new Integer[]{5,28,29,35,39,44});
                    Lotto previousLotto = new Lotto(previousLottoNumber);
                    int bonusNumber = 27;

                    assertThat(lotto.winLotto(previousLotto, bonusNumber).getPrize()).isEqualTo(LottoWinnerType.prize(5, true));
                },
                () -> {
                    List<Integer> previousLottoNumber = Arrays.asList(new Integer[]{4,28,29,35,39,44});
                    Lotto previousLotto = new Lotto(previousLottoNumber);
                    int bonusNumber = 4;

                    assertThat(lotto.winLotto(previousLotto, bonusNumber).getPrize()).isEqualTo(LottoWinnerType.prize(4, false));
                }
        );
    }
}