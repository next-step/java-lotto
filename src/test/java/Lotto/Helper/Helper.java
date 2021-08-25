package Lotto.Helper;

import Lotto.Number.LottoNumber;
import Lotto.Number.LottoNumbers;
import Lotto.Number.WinningNumbers;
import Lotto.Ticket.LottoTicket;
import Lotto.Ticket.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    final static private int[] winningNumbers = {1, 2, 3, 4, 5, 6};
    final static private int[][] lottoNumbersPerTicket = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 7}, {1, 2, 3, 4, 8, 7}, {1, 2, 3, 9, 8, 7}, {12, 11, 10, 9, 8, 7}};

    static public List<LottoTicket> lottoTickets() {
        return Arrays.stream(lottoNumbersPerTicket).map(Helper::lottoTicket).collect(Collectors.toList());
    }

    static public List<LottoTicket> lottoTickets(int[][] lottoNumbersPerTicket) {
        return Arrays.stream(lottoNumbersPerTicket).map(Helper::lottoTicket).collect(Collectors.toList());
    }

    static public LottoTicket lottoTicket(int... lottoNumbers) {
        return new LottoTicket(lottoNumbers(lottoNumbers));
    }

    static public List<LottoNumber> lottoNumbers(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    static public LottoTicket lottoTicket(int index) {
        return new LottoTicket(lottoNumbers(lottoNumbersPerTicket[index]));
    }

    static public LottoNumbers lottoNumbers(int index) {
        return new LottoNumbers(lottoNumbers(lottoNumbersPerTicket[index]));
    }

    static public WinningNumbers winningNumbers() {
        return new WinningNumbers(lottoNumbers(winningNumbers));
    }

    static public int totalPrizeMoney() {
        return Arrays.stream(Prize.values()).mapToInt(Prize::getPrizeMoney).sum();
    }
}
