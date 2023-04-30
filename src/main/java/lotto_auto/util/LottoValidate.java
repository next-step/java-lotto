package lotto_auto.util;

import lotto_auto.domain.LottoNumber;

import java.util.Set;

public class LottoValidate {
    public static final int LOTTO_MIN_NUMBER = 1;
    public static final int LOTTO_MAX_NUMBER = 45;
    public static final int LOTTO_NUMBERS_COUNT = 6;
    public static final int LOTTO_PRICE = 1000;

    public static Set<LottoNumber> validateLottoNumbers(Set<LottoNumber> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호 " + LOTTO_NUMBERS_COUNT + " 자리 입력 필요");
        }

        return numbers;
    }

    public static int ticketCount(String purchaseAmount) {
        int ticketCount = 0;
        try {
            ticketCount = Integer.parseInt(purchaseAmount) / LOTTO_PRICE;
        } catch (Exception e) {
            throw new IllegalArgumentException("로또 수량 계산 중 오류 발생");
        }

        if (ticketCount == 0) {
            throw new IllegalArgumentException("로또 구입 금액이 부족합니다.");
        }

        return ticketCount;
    }

}
