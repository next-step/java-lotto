package lotto.domain;

import lotto.view.Message;

import java.util.*;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int NUMBER_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;
    private final Random random = new Random();
    private List<Integer> lottos;
    private final Map<WinningType, Integer> matchResult = new HashMap<>();

    public LottoMachine() {
        initialMatchResult();
    }

    public int getLottoTicketNumber(Money money) {
        if (money.getValue() < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(Message.LOTTO_MINIMUM_MONEY.message);
        }
        return money.getValue() / LOTTO_TICKET_PRICE;
    }

    public int getAutoLottoTicketNumber(int allLottoTicketNumber, int manualLottoTicketNumber) {
        return allLottoTicketNumber - manualLottoTicketNumber;
    }


    public Lotto createLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> purchaseLottos(Money money, int numberOfManualLottoTicket, List<List<Integer>> manualLottoNumbers) {
        int lottoTicketNumber = getLottoTicketNumber(money);
        int numberOfAutoLottoTicket = getAutoLottoTicketNumber(lottoTicketNumber, numberOfManualLottoTicket);

        List<Lotto> lottos = new ArrayList<>();
        for ( List<Integer> manualLottoNumber : manualLottoNumbers) {
            lottos.add(createLotto(manualLottoNumber));
        }
        for (int i = 0; i < numberOfAutoLottoTicket; i++) {
            lottos.add(createLotto(generateLottoNumber()));
        }

        return lottos;
    }

    private List<Integer> generateLottoNumber() {
        lottos = new ArrayList<>();
        while (lottos.size() < LOTTO_LENGTH) {
            int candidateLottoNumber = random.nextInt(NUMBER_RANGE) + 1;
            lottoAdder(candidateLottoNumber);
        }

        lottos.sort(Integer::compareTo);

        return lottos;
    }

    private void lottoAdder(int number) {
        if (!lottos.contains(number)) {
            lottos.add(number);
        }
    }

    public Map<WinningType, Integer> calculateResult(WinningLotto winningLotto, List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            int count = winningBallMatchNumber(winningLotto, lotto);
            boolean isBonusBall = hasBonusBall(winningLotto.getBonusBall(), lotto.getLottoNumbers());

            WinningType winningType = WinningType.match(count, isBonusBall); // 이넘타입 반환

            updateCount(winningType);
        }

        return matchResult;
    }

    private void initialMatchResult() {
        for (WinningType winningType : WinningType.values()) {
            matchResult.put(winningType, 0);
        }
    }

    private void updateCount(WinningType winningType) {
        if (winningType.getValue() != 0) {
            matchResult.put(winningType, matchResult.get(winningType) + 1);
        }
    }

    public int winningBallMatchNumber(WinningLotto winningLotto, Lotto lotto) {
        return (int) winningLotto.getWinningLottoNumbers()
                .stream()
                .filter(lotto.getLottoNumbers()::contains)
                .count();
    }

    public Boolean hasBonusBall(int bonusBall, List<Integer> lotto) {
        return lotto.contains(bonusBall);
    }

    public static float getProfitRate(Map<WinningType, Integer> result, Money money) {
        long totalProfit = 0;

        for (WinningType winningType : result.keySet()) {
            Integer price = result.get(winningType);
            totalProfit += (long) winningType.getProfit().getValue() * price;
        }

        return (float) totalProfit / (float) money.getValue();
    }

    public Map<WinningType, Integer> getMatchResult() {
        return matchResult;
    }
}
