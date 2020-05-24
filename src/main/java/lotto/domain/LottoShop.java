package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private final static int LOTTO_PRICE = 1000;
    private final static int ZERO_NUMBER = 0;

    private int inputMoney;

    private LottoShop(int inputMoney) {
        validateMoney(inputMoney);
        this.inputMoney = inputMoney;
    }

    public static LottoShop putMoney(int money) {
        return new LottoShop(money);
    }

    public static void matchLottoTicket(String winningNumbers) {

    }

    private void validateMoney(int inputMoney) {
        if (inputMoney <= ZERO_NUMBER) {
            throw new IllegalArgumentException("0원 이하는 로또를 살 수 없습니다.");
        }

        if (inputMoney % LOTTO_PRICE != ZERO_NUMBER) {
            throw new IllegalArgumentException("이 구매기는 거스름돈이 없습니다. 1000원 단위로 입력하세요");
        }
    }

    private static int getLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }

    public List<LottoTicket> buyLottoTickets() {
        int lottoTicketCount = getLottoTicketCount(inputMoney);
        List<LottoTicket> lottoTicketList = new ArrayList<>();

        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTicketList.add(LottoTicket.create());
        }

        return lottoTicketList;
    }
}
