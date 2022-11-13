package nextstep.lotto.view;

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

  public String inputWinningNumbers() {
    outputConsumer.write("지난 주 당첨 번호를 입력해 주세요.");
    return inputSupplier.read();
  }
}
