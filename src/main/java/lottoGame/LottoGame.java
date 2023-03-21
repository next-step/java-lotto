package lottoGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGame {

    private final int LOTTO_ONE_GAME_AMT = 1000;
    private final int FIRST_GRADE = 1;
    private final int SECOND_GRADE = 2;
    private final int THIRD_GRADE = 3;
    private final int FOURTH_GRADE = 4;
    private final int FIFTH_GRADE = 5;
    private List<Lotto> lottoTickets;
    private Set<Integer> winningNumbers;
    private int firstMatchingLottoCount = 0;
    private int secondMatchingLottoCount = 0;
    private int thirdMatchingLottoCount = 0;
    private int fourthMatchingLottoCount = 0;
    private int fifthMatchingLottoCount = 0;

    private int bonusNumber;


    private int buyCount;

    public LottoGame() {
        this.lottoTickets = new ArrayList<>();
        this.winningNumbers = new HashSet<>();
        this.bonusNumber = 0;
    }

    public int buyLotto(int money) {
        buyCount = validInputAmt(money);

        // 구매 매수만큼 로또번호를 생성한다
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto();
            lottoTickets.add(lotto);
        }

        return buyCount;
    }

    private int validInputAmt(int buyAmt) {
        int buyAmount = buyAmt / LOTTO_ONE_GAME_AMT;
        if (buyAmount < 1) {
            throw new IllegalArgumentException(LOTTO_ONE_GAME_AMT + "이상이어야 로또를 구입할 수 있습니다.");
        }
        return buyAmount;
    }

    public Rank matchingLotto(List<Integer> userLotto, Set<Integer> winningNumbers,
        int bonusNumber) {

        int matchCount = match(userLotto, winningNumbers);
        boolean matchBonus = userLotto.contains(bonusNumber);

        // winningLotto 와 맞는 번호를 찾는다.
        return Rank.getRank(matchCount, matchBonus);
    }

    private int match(List<Integer> buyLotto, Set<Integer> winningLotto) {
        return (int) buyLotto.stream()
            .filter(lotto -> winningLotto.contains(lotto))
            .count();
    }

    public void inputWinningNumbers(Set<Integer> inputWinningNumber) {
        winningNumbers.clear();
        winningNumbers.addAll(inputWinningNumber);

        if (winningNumbers.size() != Lotto.LOTTO_NUMBERS) {
            throw new RuntimeException("입력된 숫자는 중복 없는 6자리 숫자여야 합니다.");
        }
    }

    private void validInputLottoNumber(int number) {
        if (number < Lotto.LOTTO_MIN_NUMBER_RANGE || number > Lotto.LOTTO_MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public void inputBonusNumber(int inputNumber) {
        bonusNumber = inputNumber;
    }

    public void run() {
        for (Lotto lotto : lottoTickets) {
            List<Integer> userLotto = new ArrayList<>(lotto.getLottoNumber());
            Rank rank = matchingLotto(userLotto, winningNumbers, bonusNumber);
            matchingResult(rank);
        }
    }

    private void matchingResult(Rank rank) {
        if (rank == Rank.FIRST) {
            firstMatchingLottoCount++;
            return;
        }
        if (rank == Rank.SECOND) {
            secondMatchingLottoCount++;
            return;
        }
        if (rank == Rank.THIRD) {
            thirdMatchingLottoCount++;
            return;
        }
        if (rank == Rank.FOURTH) {
            fourthMatchingLottoCount++;
            return;
        }
        if (rank == Rank.FIFTH) {
            fifthMatchingLottoCount++;
            return;
        }
    }

    public int getFirstGrade() {
        return firstMatchingLottoCount;
    }

    public int getSecondGrade() {
        return secondMatchingLottoCount;
    }

    public int getThirdGrade() {
        return thirdMatchingLottoCount;
    }

    public int getFourthGrade() {
        return fourthMatchingLottoCount;
    }

    public int getFifthGrade() {
        return fifthMatchingLottoCount;
    }

    public float getRate() {
        return (float) (
            Rank.getPrize(Rank.FIFTH, fifthMatchingLottoCount)
                + Rank.getPrize(Rank.FOURTH, fourthMatchingLottoCount)
                + Rank.getPrize(Rank.THIRD, thirdMatchingLottoCount)
                + Rank.getPrize(Rank.SECOND, secondMatchingLottoCount)
                + Rank.getPrize(Rank.FIRST, firstMatchingLottoCount))
            / (buyCount * 1000);
    }

    public String getResult() {
        int result =
            Rank.getPrize(Rank.FIFTH, fifthMatchingLottoCount)
                + Rank.getPrize(Rank.FOURTH, fourthMatchingLottoCount)
                + Rank.getPrize(Rank.THIRD, thirdMatchingLottoCount)
                + Rank.getPrize(Rank.SECOND, secondMatchingLottoCount)
                + Rank.getPrize(Rank.FIRST, firstMatchingLottoCount);
        if (result > buyCount * 1000) {
            return "이익";
        }

        return "손해";
    }

    public Lotto getLottoList(int i) {
        return lottoTickets.get(i);
    }

    public int getLottoListCount() {
        return lottoTickets.size();
    }

    public List<Lotto> getLottoTicket() {
        return lottoTickets;
    }
}
