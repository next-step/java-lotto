package lotto.service.util;

public interface DigitCheckStrategy {

    String NUMBER_CHECK_ERROR_MSG = "숫자만 입력 가능합니다!!!!";

    boolean isDigitCheck(String inputData);
}
