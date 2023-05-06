package lotto.domian;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Store {

    private static final int PURCHASE_UNIT = 1000;
    private static final String SPLIT_DELIMITER = ",";

    public static LottoBundle order(Money money) {
        return createLotto(decideCount(money));
    }

    public static Lotto pickWinNumber(String answerNumbers) {
        String[] splitedNumbers = splitNumbers(answerNumbers);
        List<Integer> numberList = getIntegers(splitedNumbers);
        return new Lotto(makeLottoNumber(numberList));
    }

    public static Record extractRecord(LottoBundle lottoBundle, WinNumber winNumber) {
        Map<Rank, Integer> rankMap = new HashMap<>();
        List<Lotto> lottoList = lottoBundle.unfoldLottoBundle();
        for (Lotto lotto : lottoList) {
            int matchingCount = winNumber.distinguish(lotto);
            putRankMap(matchingCount, rankMap);
        }
        return new Record(rankMap);
    }

    private static void putRankMap(int matchingCount, Map<Rank, Integer> rankMap) {
        if (matchingCount >= 3) {
            Rank rank = Rank.find(matchingCount);
            rankMap.put(rank, rankMap.getOrDefault(rank, 0) + 1);
        }
    }

    private static LottoBundle createLotto(int count) {
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottoList.add(makeRandomLotto());
        }
        return new LottoBundle(lottoList);
    }

    private static Lotto makeRandomLotto() {
        List<Integer> lottoNumberBox = makeLottoBox();
        Collections.shuffle(lottoNumberBox);

        return new Lotto(makeLottoNumber(lottoNumberBox.subList(0, 6)));
    }

    private static int decideCount(Money money) {
        return money.amount() / PURCHASE_UNIT;
    }

    private static List<LottoNumber> makeLottoNumber(List<Integer> numberList) {
        return numberList.stream()
                .map(number -> new LottoNumber(number))
                .collect(Collectors.toList());
    }

    private static List<Integer> makeLottoBox() {
        return IntStream.range(1, 45)
                .boxed()
                .collect(Collectors.toList());
    }

    private static List<Integer> getIntegers(String[] splitedNumbers) {
        return Stream.of(splitedNumbers)
                .map(string -> {
                    string = string.trim();
                    isNumeric(string);
                    return Integer.parseInt(string);
                })
                .collect(Collectors.toList());
    }

    private static String[] splitNumbers(String winnerNumbers) {
        return winnerNumbers.trim().split(SPLIT_DELIMITER);
    }

    private static void isNumeric(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("로또 번호는 숫자형태만 가능합니다.");
        }
    }

    public static ProfitRate calculateProfit(int purchaseMoney, Record record) {
        double allPrize = 0;
        for (Rank rank : record.getRecord().keySet()) {
            int prize = rank.getPrize();
            int matchingCount = record.getRecord().get(rank);
//            allPrize += rank.getPrize() * rank.getMatchingCount();
            allPrize += prize * matchingCount;
        }

        return new ProfitRate(allPrize / purchaseMoney);
    }
}
