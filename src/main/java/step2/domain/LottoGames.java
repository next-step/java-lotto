package step2.domain;

import java.util.*;

public class LottoGames {

    public LottoGames() {
    }

    public int calculateBuyingTicketCount(int money) {
        return new Integer(money / LottoCommonValue.DEFAULT_LOTTO_PRICE.value());
    }

    public List<LottoTicket> buyLottoGame(int gameCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>(gameCount);
        for (int i = 0; i < gameCount; i++) {
            lottoTickets.add(createLottoGame());
        }
        return lottoTickets;
    }

    private LottoTicket createLottoGame() {
        return new LottoTicket(RandomIntegersGenerator.createNumberList());
    }

    public LottoTicket readWinningNumber(String stringNumber) {
        String[] numbers = splitByDelimiter(stringNumber);
        Set<Integer> integers = toSet(numbers);
        if (integers.size() != LottoCommonValue.DEFAULT_LOTTO_NUMBER_COUNT.value()) {
            throw new IllegalArgumentException(stringNumber + " : 입력한 숫자를 확인해 주세요");
        }
        return new LottoTicket(integers);
    }

    private String[] splitByDelimiter(String stringNumber) {
        stringNumber = stringNumber.replaceAll(" ", "");
        return stringNumber.split(",");
    }

    private Set<Integer> toSet(String[] numbers) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (String number : numbers) {
            hashSet.add(toInt(number));
        }
        return hashSet;
    }

    private Integer toInt(String element) {
        try {
            return Integer.parseInt(element);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(element + " : 유효한 정수 값이 아닙니다.");
        }
    }
}
