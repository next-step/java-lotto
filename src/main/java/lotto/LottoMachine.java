package lotto;

public interface LottoMachine {

    int DEFAULT_LOTTO_SIZE = 6;
    int MIN_NUMBER = 0;
    int MAX_NUMBER = 45;


    LottoTicket publish();

}
