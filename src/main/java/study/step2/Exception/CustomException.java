package study.step2.Exception;

import static study.step2.utils.MessageUtil.BONUS_NUMBER_INVALID_MESSAGE;
import static study.step2.utils.MessageUtil.LOTTO_NUMBER_DUPLICATED;
import static study.step2.utils.MessageUtil.LOTTO_NUMBER_INVALID_RANGE;

public class CustomException extends RuntimeException {

  private CustomException(String message){
    super(message);
  }

  public static final CustomException LOTTO_NUMBER_DUPLICATED_EXCEPTION = new CustomException(LOTTO_NUMBER_DUPLICATED);
  public static final CustomException LOTTO_NUMBER_INVALID_RANGE_EXCEPTION = new CustomException(LOTTO_NUMBER_INVALID_RANGE);
  public static final CustomException BONUS_NUMBER_INVALID_MESSAGE_EXCEPTION = new CustomException(BONUS_NUMBER_INVALID_MESSAGE);
}
