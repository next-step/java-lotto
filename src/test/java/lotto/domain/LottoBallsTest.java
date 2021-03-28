package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoBallsTest {

  private LottoBalls lottoBalls;

  @BeforeEach
  void setUp() {
    lottoBalls = new LottoBalls(
        Arrays.asList(
            new LottoBall(1), new LottoBall(2), new LottoBall(3),
            new LottoBall(4), new LottoBall(5), new LottoBall(6)
        )
    );
  }

  @DisplayName("당첨 번호 개수 구하기")
  @ParameterizedTest
  @CsvSource(value = {"3,4,7,8,9,10:2", "1,3,5,7,8,9:3", "1,2,3,4,5,6:6"} , delimiter = ':')
  void test(String winLottoNumber, String result) {
    int count = lottoBalls.countContainingWinNumbers(new LottoBalls(createLottoList(winLottoNumber)));
    assertThat(count).isEqualTo(Integer.parseInt(result));
  }

  private List<LottoBall> createLottoList(String input) {
    String[] stringArr = input.split(",");
    List<LottoBall> lottoBalls = new ArrayList<>();
    for (String numberString : stringArr) {
      lottoBalls.add(new LottoBall(Integer.parseInt(numberString)));
    }
    return lottoBalls;
  }

}