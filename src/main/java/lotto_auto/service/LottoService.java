package lotto_auto.service;

import lotto_auto.domain.Lotto;
import lotto_auto.domain.LottoNumber;
import lotto_auto.domain.LottoTickets;

import java.util.*;

public class LottoService {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;
    private static final int LOTTO_PRICE = 1000;

    public Lotto generateTicket() {
        List<Integer> lottoNumberBound = new ArrayList<>();
        for (int i = LOTTO_MIN_NUMBER; i <= LOTTO_MAX_NUMBER; i++) {
            lottoNumberBound.add(i);
        }

        Collections.shuffle(lottoNumberBound);
        List<Integer> selectedNumbers = lottoNumberBound.subList(0, LOTTO_NUMBERS_COUNT);
        Collections.sort(selectedNumbers);

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (Integer number : selectedNumbers) {
            lottoNumbers.add(new LottoNumber(number));
        }

        return new Lotto(lottoNumbers);
    }

    public LottoTickets generateTickets(int ticketCount) {
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(generateTicket());
        }

        return new LottoTickets(tickets);
    }

    public int ticketCount(String purchaseAmount) {
        int ticketCount;
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

    public static Set<Integer> validateLottoNumbers(Set<Integer> numbers) {
        if (numbers == null || numbers.size() != LOTTO_NUMBERS_COUNT) {
            throw new IllegalArgumentException("로또 번호 " + LOTTO_NUMBERS_COUNT + " 자리 입력 필요");
        }

        for (Integer number : numbers) {
            validateLottoBound(number);
        }

        return numbers;
    }

    public static void validateLottoBound(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException("올바르지 않은 로또의 범위 : " + LOTTO_MIN_NUMBER + "과 " + LOTTO_MAX_NUMBER + "사이의 값을 입력필요");
        }
    }

    public static Set<Integer> validateLottoWinner(String input) {
        String[] splitNumbers = input.split(",");
        Set<Integer> winnerNumbers = new HashSet<>();

        for (String number : splitNumbers) {
            winnerNumbers.add(parseLottoNumber(number));
        }

        return validateLottoNumbers(winnerNumbers);
    }

    private static Integer parseLottoNumber(String input) {
        int number = 0;

        try {
            number = Integer.parseInt(input.trim());
        } catch (Exception e) {
            throw new IllegalArgumentException("올바르지 않은 당첨번호입니다");
        }

        return number;
    }
}
