package lotto.domain;

import lotto.view.Message;

import java.util.*;

public class LottoMachine {
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int NUMBER_RANGE = 45;
    private static final int LOTTO_LENGTH = 6;
    private final Random random = new Random();
    private List<LottoNumber> lottoNumbers;
    private List<Lotto> lottos;
    private final Map<WinningType, Integer> matchResult = new HashMap<>();

    public LottoMachine() {
        lottos = new ArrayList<>();
        initialMatchResult();
    }

    public int getLottoTicketNumber(Money money) {
        if (money.getValue() < LOTTO_TICKET_PRICE) {
            throw new IllegalArgumentException(Message.LOTTO_MINIMUM_MONEY.message);
        }
        return money.getValue() / LOTTO_TICKET_PRICE;
    }

    public int getAutoLottoTicketNumber(LottoPaper lottoPaper) {
        return lottoPaper.getNumberOfAllLottoTicket()-lottoPaper.getNumberOfManualLottoTicket();
    }

    public Lotto createLotto(List<LottoNumber> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    public List<Lotto> purchaseLottos(LottoPaper lottoPaper) {
        int numberOfAutoLottoTicket = getAutoLottoTicketNumber(lottoPaper);

        createManualLottos(lottoPaper);
        createAutoLottos(numberOfAutoLottoTicket);

        return lottos;
    }

    private void createAutoLottos(int numberOfAutoLottoTicket) {
        for (int i = 0; i < numberOfAutoLottoTicket; i++) {
            lottos.add(createLotto(generateLottoNumber()));
        }
    }

    private void createManualLottos(LottoPaper lottoPaper) {
        for (List<LottoNumber> manualLottoNumber : lottoPaper.getManualLottoNumbers()) {
            lottos.add(createLotto(manualLottoNumber));
        }
    }

    private List<LottoNumber> generateLottoNumber() {
        lottoNumbers = new ArrayList<>();
        for (int i=1; i<=NUMBER_RANGE; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        Collections.shuffle(lottoNumbers);
        lottoNumbers = lottoNumbers.subList(0, 6);

        return lottoNumbers;
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

    public Boolean hasBonusBall(LottoNumber bonusBall, List<LottoNumber> lotto) {
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

    public void isValidNumberOfManualLottoTicket(int numberOfAllLottoTicket, int numberOfManualLottoTicket) {
        if (numberOfAllLottoTicket < numberOfManualLottoTicket || numberOfManualLottoTicket < 0) {
            throw new IllegalArgumentException();
        }
    }
}
