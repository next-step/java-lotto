package nextstep.lotto.view;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import nextstep.lotto.domain.LottoNumber;

public class InputView {

  private final InputSupplier inputSupplier;
  private final OutputConsumer outputConsumer;

  public InputView(InputSupplier inputSupplier, OutputConsumer outputConsumer) {
    this.inputSupplier = inputSupplier;
    this.outputConsumer = outputConsumer;
  }

  public int inputCost() {
    outputConsumer.write("구입금액을 입력해 주세요.");
    final String read = inputSupplier.read();
    return Integer.parseInt(read);
  }

  public Set<LottoNumber> inputWinningNumbers() {
    outputConsumer.write("지난 주 당첨 번호를 입력해 주세요.");
    return parseLottoNumbers(inputSupplier.read());
  }
  private Set<LottoNumber> parseLottoNumbers(final String winningNumbers) {

    if (winningNumbers == null || winningNumbers.isBlank()) {
      throw new IllegalArgumentException("로또 번호는 공백일 수 없습니다.");
    }

    final String[] split = winningNumbers.split(",");
    return Arrays.stream(split)
      .map(String::trim)
      .map(LottoNumber::lottoNumber)
      .collect(Collectors.toSet());
  }
}
