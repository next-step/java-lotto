package step2.view;

public class ResultView {

  public static ResultView instance;

  public static ResultView getInstance () {
    if (instance != null) instance = new ResultView();
    return instance;
  }

}
