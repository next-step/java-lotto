package step2.view;

public class InputView {

  public static InputView instance;

  public static InputView getInstance () {
    if (instance != null) instance = new InputView();
    return instance;
  }
}
