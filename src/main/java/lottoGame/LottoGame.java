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

    public void buyLotto(String inputMoney) {

        int money = Integer.parseInt(inputMoney);
        buyCount = validInputAmt(money);

        // 구매 매수만큼 로또번호를 생성한다
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = new Lotto();
            lottoTickets.add(lotto);
        }

        InputView.printTicket(lottoTickets);
    }

    private int validInputAmt(int buyAmt) {
        int buyAmount = buyAmt / LOTTO_ONE_GAME_AMT;
        if (buyAmount < 1) {
            throw new IllegalArgumentException(LOTTO_ONE_GAME_AMT + "이상이어야 로또를 구입할 수 있습니다.");
        }
        return buyAmount;
    }

    public int matchingLotto(List<Integer> userLotto, Set<Integer> winningNumbers, int bonusNumber) {

        // winningLotto 와 맞는 번호를 찾는다.
        int matchCount = match(userLotto, winningNumbers);
        if (matchCount == 6) {
            return 1;
        }
        boolean matchBonus = userLotto.contains(bonusNumber);
        if (matchCount == 5 && matchBonus) {
            return 2;
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2;
        }
        return 0;
    }

    private int match(List<Integer> buyLotto, Set<Integer> winningLotto) {
        return (int) buyLotto.stream()
            .filter(lotto -> winningLotto.contains(lotto))
            .count();
    }

    public void inputWinningNumbers(String input) {
        List<String> numberList = List.of(input.split(","));

        int inputNumber = 0;
        for (String n : numberList) {
            inputNumber = Integer.parseInt(n);
            validInputLottoNumber(inputNumber);
            winningNumbers.add(inputNumber);
        }

        if (winningNumbers.size() != Lotto.LOTTO_NUMBERS) {
            throw new RuntimeException("입력된 숫자는 중복 없는 6자리 숫자여야 합니다.");
        }
    }

    private void validInputLottoNumber(int number) {
        if(number < Lotto.LOTTO_MIN_NUMBER_RANGE || number > Lotto.LOTTO_MAX_NUMBER_RANGE) {
            throw new IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.");
        }
    }

    public void inputBonusNumber(String inputNumber) {
        bonusNumber = Integer.parseInt(inputNumber);
    }

    public void run() {
        for (Lotto lotto : lottoTickets) {
            List<Integer> userLotto = new ArrayList<>(lotto.getLottoNumber());
            int result = matchingLotto(userLotto, winningNumbers, bonusNumber);

            machingResult(result);
        }
    }

    private void machingResult(int result) {
        if (result == 1) {
            firstMatchingLottoCount++;
            return;
        }
        if (result == 2) {
            secondMatchingLottoCount++;
            return;
        }
        if (result == 3) {
            thirdMatchingLottoCount++;
            return;
        }
        if (result == 4) {
            fourthMatchingLottoCount++;
            return;
        }
        if (result == 5) {
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
        return (float) (5000 * fifthMatchingLottoCount
            + 50000 * fourthMatchingLottoCount
            + 1500000 * thirdMatchingLottoCount
            + 30000000 * secondMatchingLottoCount
            + 2000000000 * firstMatchingLottoCount) / (buyCount * 1000);
    }

    public String getResult() {
        int result =
            5000 * fifthMatchingLottoCount
                + 50000 * fourthMatchingLottoCount
                + 1500000 * thirdMatchingLottoCount
                + 30000000 * secondMatchingLottoCount
                + 2000000000 * firstMatchingLottoCount;
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
}
