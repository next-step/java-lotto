package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoTicket {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_BOUND = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static Random random = new Random();

    private LottoTicket() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static List<List<Integer>> issue(final int totalPurchasePrice) {
        validatePurchasePrice(totalPurchasePrice);
        int totalLottoCount = getTotalLottoCount(totalPurchasePrice);
        List<List<Integer>> ticket = new ArrayList<>(totalLottoCount);
        for (int i = 0; i < totalLottoCount; i++) {
            ticket.add(issueLotto());
        }
        return ticket;
    }

    private static List<Integer> issueLotto() {
        List<Integer> lotto = new ArrayList<>(LOTTO_NUMBER_COUNT);
        for (int j = 0; j < LOTTO_NUMBER_COUNT; j++) {
            lotto.add(generateUniqueLottoNumber(lotto));
        }
        lottoSort(lotto);
        return lotto;
    }

    private static void lottoSort(final List<Integer> lotto) {
        Collections.sort(lotto);
    }

    private static int generateUniqueLottoNumber(final List<Integer> lotto) {
        int lottoNumber = generateLottoNumber();
        while (lotto.contains(lottoNumber)) {
            lottoNumber = generateLottoNumber();
        }
        return lottoNumber;
    }

    private static int generateLottoNumber() {
        return random.nextInt(LOTTO_BOUND) + 1;
    }

    private static int getTotalLottoCount(final int totalPurchasePrice) {
        return totalPurchasePrice / LOTTO_TICKET_PRICE;
    }

    private static void validatePurchasePrice(final int totalPurchasePrice) {
        if (totalPurchasePrice % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }
}
