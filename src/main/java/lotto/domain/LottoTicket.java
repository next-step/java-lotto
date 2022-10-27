package lotto.domain;

import java.util.List;

public class LottoTicket {

    public static final long TICKET_PRICE = 1000L;
    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<LottoNumber> numbers;

    public LottoTicket(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public LottoTicket(int...args) {
        if (args.length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException(LOTTO_NUMBER_COUNT + "개의 숫자를 입력해주세요");
        }

        this.numbers = LottoNumber.createLottoNumbers(args);
    }

    public LottoRank getRank(List<LottoNumber> winningNumbers, LottoNumber bonusBall) {
        int matchCount = 0;
        for (LottoNumber winningNumber : winningNumbers) {
            matchCount += checkMatchNumber(winningNumber);
        }

        boolean bonusMatch = checkMatchNumber(bonusBall) == 1;

        return LottoRank.getRank(matchCount, bonusMatch);
    }

    public int checkMatchNumber(LottoNumber lottoNumber) {
        if (numbers.contains(lottoNumber)) {
            return 1;
        }

        return 0;
    }

    public static int getLottoTicketCount(long paidAmount) {
        if (paidAmount < 1000) {
            return 0;
        }

        return (int) (paidAmount / TICKET_PRICE);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
