package lotto;

import java.util.*;

import static lotto.Lotto.CANDIDATE_LOTTO_NUMBER_SIZE;
import static lotto.Lotto.CORRECT_LOTTO_NUMBERS_SIZE;
import static lotto.Reward.*;
import static lotto.WinningLogic.*;
import static lotto.ui.Input.*;
import static lotto.ui.Output.*;
import static lotto.ui.TypeConvert.*;

public class LottoMachine {
    public static Integer LOTTERY_PRICE = 1000;

    public void purchaseStart() {
        printStartMessage();
        Integer purchaseAmount = inputMoneyForPurchase();
        Integer purchased = countPurchasable(purchaseAmount);
        printPurchasableMessage(purchased);
        List<Lotto> bunchOfLotto = makeBunchOfLotto(purchaseAmount);

        printBunchOfLottoNumbers(bunchOfLotto);
        printInputWinningNumber();
        TreeMap<Integer,Integer> prizes = makePrizes(makeRewards(bunchOfLotto, makeWinningNumbers()));

        print3Match(prizes.get(MATCH_3.getPrizeMoney()));
        print4Match(prizes.get(MATCH_4.getPrizeMoney()));
        print5Match(prizes.get(MATCH_5.getPrizeMoney()));
        print6MatchWithBonus(prizes.get(MATCH_6_WITH_BONUS.getPrizeMoney()));
        print6Match(prizes.get(MATCH_6.getPrizeMoney()));

        printYield(makeYield(purchaseAmount, makePrizeMoney(prizes)));
    }

    private List<Reward> makeRewards(List<Lotto> bunchOfLotto, List<Integer> winningNumbers) {
        List<Reward> rewards = new ArrayList<>();
        for (Lotto lotto : bunchOfLotto) {
            rewards.add(getReward(makeMatchCounts(lotto.getLottoNumbers(), winningNumbers)));
        }
        return rewards;
    }

    // private 로 하고싶은데 테스트에서 사용하려면 public 이어야하고 그렇다는건 메서드가 다른 클래스로 가야할지도..?
    public static List<Integer> makeLottoNumbers() {
        HashSet<Integer> lottoNumbers = new HashSet<>();
        while (lottoNumbers.size() < CORRECT_LOTTO_NUMBERS_SIZE) {
            lottoNumbers.add(makeLottoNumber());
        }
        List lottoNumberList = new ArrayList(lottoNumbers);
        return lottoNumberList;
    }

    private static Integer makeLottoNumber() {
        return (int) (Math.random() * CANDIDATE_LOTTO_NUMBER_SIZE) + 1;
    }

    public List<Lotto> makeBunchOfLotto(int purchaseAmount) {
        List<Lotto> bunchOfLotto = new ArrayList<>();
        int lottoCount = countPurchasable(purchaseAmount);
        for (int i = 0; i < lottoCount; i++) {
            bunchOfLotto.add(new Lotto(makeLottoNumbers()));
        }
        return bunchOfLotto;
    }

    public int countPurchasable(int purchaseAmount) {
        return purchaseAmount / LOTTERY_PRICE;
    }

    public List<Integer> makeWinningNumbers() {
        List<Integer> winningNumbers = convertStringListToIntegerList
                (convertStringToStringList
                        (inputWinningNumbers()
                        ));
        Collections.sort(winningNumbers);
        winningNumbers.add(convertStringToInteger(inputBonusNumber()));

        return winningNumbers;
    }
}
