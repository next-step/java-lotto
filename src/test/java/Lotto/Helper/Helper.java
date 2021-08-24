package Lotto.Helper;

import Lotto.Number.LottoNumber;
import Lotto.Ticket.LottoTicket;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    final static private int[][] datas = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 7}, {1, 2, 3, 4, 8, 7}, {1, 2, 3, 9, 8, 7}};

    static public List<LottoTicket> lottoTickets() {
        return Arrays.stream(datas).map(Helper::lottoTicket).collect(Collectors.toList());
    }

    static public LottoTicket lottoTicket(int... lottoNumbers) {
        return new LottoTicket(lottoNumbers(lottoNumbers));
    }

    static public List<LottoNumber> lottoNumbers(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }
}
