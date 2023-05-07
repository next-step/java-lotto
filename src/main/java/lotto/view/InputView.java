package lotto.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    String lottoNumbers = reader.readLine();
    return splitAndGetLottoRound(lottoNumbers);
  }

  public int getManualLottoNumberCount() throws IOException {
    System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    String manualNumberCount = reader.readLine();
    return Integer.parseInt(manualNumberCount);
  }

  public int getBonusNumber () throws IOException {
    System.out.println("보너스 볼을 입력해 주세요.");
    String lottoPrice = reader.readLine();
    return Integer.parseInt(lottoPrice);
  }

  public void tearDown() throws IOException {
    this.reader.close();
  }

  public List<List<Integer>> generateManualLottoRound (int manualLottoNumberCount) throws IOException {
    System.out.println("수동으로 구매할 번호를 입력해 주세요.");

    List<List<Integer>> manualLottoRounds = new ArrayList<>(manualLottoNumberCount);
    for (int i = 0; i < manualLottoNumberCount; i++) {
      manualLottoRounds.add(splitAndGetLottoRound(reader.readLine()));
    }

    return manualLottoRounds;
  }

  private List<Integer> splitAndGetLottoRound(String lottoNumberLine) {
    return Arrays.stream(lottoNumberLine.split(","))
        .map(String::strip)
        .map(Integer::parseInt)
        .collect(Collectors.toList());
  }
}
