package lotto.domain;

public interface LottoMachine {
    String DELIMITER = ", ";
    String NUMBER_FORMAT_EXCEPTION_MESSAGE = "로또 번호는 숫자만 가능합니다. (입력 예시 : 1, 2, 3, 4, 5, 6)";
    String NUMBER_COUNT_EXCEPTION_MESSAGE = "로또 번호는 %d개만 가능합니다.";
    int ONE_LOTTO_PRICE = 1000;
    int LOTTO_START_NUMBER = 1;
    int LOTTO_END_NUMBER = 45;
    int NUMBER_COUNT = 6;
    int BASE_INDEX = 0;
    LottoTicket generate();
    LottoTickets generates();
}
