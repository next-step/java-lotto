package lotto.helper;

import lotto.game.LottoGame;
import lotto.number.LottoNumber;
import lotto.number.LottoNumbers;
import lotto.number.WinningNumbers;
import lotto.ticket.LottoTicket;
import lotto.ticket.Prize;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Helper {

    private static final int[] winningNumbers = {1, 2, 3, 4, 5, 6};
    private static final int[][] lottoNumbersPerTicket = {{1, 2, 3, 4, 5, 6}, {1, 2, 3, 4, 5, 7}, {1, 2, 3, 4, 8, 7}, {1, 2, 3, 9, 8, 7}, {12, 11, 10, 9, 8, 7}};
    private static final int payment = getPayments(lottoNumbersPerTicket);

    public static LottoGame lottoGame() {
        return new LottoGame(payment) {
            @Override
            public List<LottoTicket> getLottoTickets() {
                return lottoTickets();
            }
        };
    }

    public static LottoGame lottoGame(int[][] lottoNumbersPerTicket) {
        return new LottoGame(getPayments(lottoNumbersPerTicket)) {
            @Override
            public List<LottoTicket> getLottoTickets() {
                return lottoTickets(lottoNumbersPerTicket);
            }
        };
    }

    private static int getPayments(int[][] lottoNumbersPerTicket) {
        return lottoNumbersPerTicket.length * LottoTicket.PRICE;
    }

    public static List<LottoTicket> lottoTickets() {
        return Arrays.stream(lottoNumbersPerTicket).map(Helper::lottoTicket).collect(Collectors.toList());
    }

    public static List<LottoTicket> lottoTickets(int[][] lottoNumbersPerTicket) {
        return Arrays.stream(lottoNumbersPerTicket).map(Helper::lottoTicket).collect(Collectors.toList());
    }

    public static LottoTicket lottoTicket(int... lottoNumbers) {
        return new LottoTicket(lottoNumbers(lottoNumbers));
    }

    public static List<LottoNumber> lottoNumbers(int... numbers) {
        return Arrays.stream(numbers).mapToObj(LottoNumber::new).collect(Collectors.toList());
    }

    public static LottoTicket lottoTicket(int index) {
        return new LottoTicket(lottoNumbers(lottoNumbersPerTicket[index]));
    }

    public static LottoNumbers lottoNumbers(int index) {
        return new LottoNumbers(lottoNumbers(lottoNumbersPerTicket[index]));
    }

    public static WinningNumbers winningNumbers() {
        return new WinningNumbers(lottoNumbers(winningNumbers));
    }

    public static int totalPrizeMoney() {
        return Arrays.stream(Prize.values()).mapToInt(Prize::getPrizeMoney).sum();
    }
}
