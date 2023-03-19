package exception;

import configuration.LottoConfiguration;

public class CasinoException {

    public static void validateManualTicketsCounts(int count, int manualLottoLength) {
        if (count != manualLottoLength) {
            throw new IllegalArgumentException("수동 티켓 장수와 입력한 로또 장수가 동일하지 않습니다.");
        }
    }

    public static void validatePay(int money) {
        if (money < LottoConfiguration.LOTTO_UNIT) {
            throw new IllegalArgumentException("로또는 1장에 1000원입니다");
        }
    }

}
