package lotto.tool;

import lotto.domain.LottoBall;
import lotto.domain.LottoTicket;

import java.util.List;

public interface LottoGenerator {
    List<LottoTicket> generate();
    List<LottoBall> sort(List<LottoBall> lottoBalls);
}
