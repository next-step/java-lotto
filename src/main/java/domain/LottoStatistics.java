package domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;
    private static final int EQUAL_THREE_NUMBERS = 5000;
    private static final int EQUAL_FOUR_NUMBERS = 50000;
    private static final int EQUAL_FIVE_NUMBERS = 1500000;
    private static final int EQUAL_SIX_NUMBERS = 2000000000;
    private static final int THREE_WINNING = 3;
    private static final int FOUR_WINNING = 4;
    private static final int FIVE_WINNING = 5;
    private static final int ALL_WINNING = 6;
    private static final int FIRST_INDEX = 0;
    private static final String SPLIT_REGEX = ",";
    private static final String MAKE_LOTTO_LIST_REGEX = ", ";
    private static final String NEXT_LINE = "\n";
    private static final String LEFT_BRACKETS = "[";
    private static final String RIGHT_BRACKETS = "]";
    private final Lottos lottos;
    private final Lotto winningLotto;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public LottoStatistics(BuyLotto buyLotto, String winningNumbers) {
        this.lottos = buyLottoListToLottos(buyLotto.buyLottoList());
        this.winningLotto = new Lotto(Arrays.stream(winningNumbers.split(SPLIT_REGEX))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
    }

    private Lottos buyLottoListToLottos(String buyLottoList) {
        return new Lottos(stringListToList(buyLottoList.split(NEXT_LINE)));
    }

    private List<Lotto> stringListToList(String[] lottoList) {
       return Arrays.stream(lottoList)
                .map(s -> new Lotto(makeStringToIntegerList(s.split(MAKE_LOTTO_LIST_REGEX))))
                .collect(Collectors.toList());
    }

    private List<Integer> makeStringToIntegerList(String[] lottoList) {
        List<Integer> result = new ArrayList<>();
        for (String str : lottoList) {
            result.add(makeNumber(str));
        }

        return result;
    }

    private Integer makeNumber(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if(str.contains(LEFT_BRACKETS)) {
            sb.deleteCharAt(FIRST_INDEX);
        }

        if(str.contains(RIGHT_BRACKETS)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return Integer.parseInt(sb.toString());
    }


    public double calculateNumbersCount(int count) {
        return lottos.calculateNumbers(winningLotto, count);
    }

    public double statistics() {
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(decimalFormat.format(
                ((calculateNumbersCount(THREE_WINNING) * EQUAL_THREE_NUMBERS)
                        + (calculateNumbersCount(FOUR_WINNING) * EQUAL_FOUR_NUMBERS)
                        + (calculateNumbersCount(FIVE_WINNING) * EQUAL_FIVE_NUMBERS)
                        + (calculateNumbersCount(ALL_WINNING) * EQUAL_SIX_NUMBERS)) / (lottos.size() * LOTTO_PRICE)));
    }

}
