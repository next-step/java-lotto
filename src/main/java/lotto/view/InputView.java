package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
  private final BufferedReader reader;

  public InputView() {
    this.reader = new BufferedReader(new InputStreamReader(System.in));
  }

  public int getLottoPrice() throws IOException {
    System.out.print("구입금액을 입력해 주세요.\n");
    String lottoPrice = reader.readLine();
    return Integer.parseInt(lottoPrice);
  }

  public List<Integer> getLastWeekLottoNumbers () throws IOException {
    System.out.print("\n지난 주 당첨 번호를 입력해 주세요.\n");
    String lottoPrice = reader.readLine();
    return Arrays.stream(lottoPrice.split(","))
        .map(String::strip)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }

  public int getBonusNumber () throws IOException {
    System.out.println("보너스 볼을 입력해 주세요.\n");
    String lottoPrice = reader.readLine();
    return Integer.parseInt(lottoPrice);
  }

  public void tearDown() throws IOException {
    this.reader.close();
  }
}
