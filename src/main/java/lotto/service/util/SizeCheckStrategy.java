package lotto.service.util;

public interface SizeCheckStrategy {

    int LOTTO_SIZE = 6;
    String FORM_ERROR_MSG = "당첨번호는 6자리 입니다!!!!";

    boolean isSizeOverCheck(int lottoSize);
}
