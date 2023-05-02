package lotto_second.util;

import lotto_second.domain.LottoNumber;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

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

    public static int maxTicketCount(String purchaseAmount) {
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

    public static int manualTicketCount(Integer maxTicketAmount, String manualPurchaseAmount) {
        int manualTicketCount = 0;

        try {
            manualTicketCount = Integer.parseInt(manualPurchaseAmount);
        } catch (Exception e) {
            throw new IllegalArgumentException("수동 로또 수 오류");
        }

        if (maxTicketAmount < manualTicketCount) {
            throw new IllegalArgumentException("구입금액보다 큰 수동 로또 수 입력.");
        }

        return manualTicketCount;
    }

    public static int autoTicketCount(Integer maxTicketCount, Integer manualTicketCount) {
        return maxTicketCount - manualTicketCount;
    }

    public static Set<LottoNumber> parseLottoNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
    }

    public static Integer parseLottoNumber(String input) {
        return Integer.parseInt(input.trim());
    }

}
