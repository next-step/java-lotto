package lottogame.controller.spi;

import java.math.BigInteger;
import java.util.List;
import java.util.Set;

public interface Inputer {

    BigInteger inputMoney();

    int inputPassiveLottoTicketCount();

    List<Set<Integer>> inputPassiveLottoTickets(int count);

    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();

}
