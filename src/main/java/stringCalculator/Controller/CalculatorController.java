package stringCalculator.Controller;

import stringCalculator.message.Message;
import stringCalculator.service.StringCalculator;
import stringCalculator.view.InputView;
import stringCalculator.view.ResultView;

public class CalculatorController {

  public static void main(String[] args) {

    StringCalculator stringCalculator = new StringCalculator(InputView.getInputScannerWithMessage(Message.MSG_INPUT_VALUE));

    ResultView.getResultWithMessage(Message.MSG_RESULT_FORMAT,stringCalculator.getCustomSplitSum());
  }
}
