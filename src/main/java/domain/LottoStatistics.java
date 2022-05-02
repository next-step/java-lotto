package domain;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoStatistics {
    private static final int LOTTO_PRICE = 1000;
    private static final int FIRST_INDEX = 0;
    private static final String MAKE_LOTTO_LIST_REGEX = ", ";
    private static final String NEXT_LINE = "\n";
    private static final String LEFT_BRACKETS = "[";
    private static final String RIGHT_BRACKETS = "]";
    private final Lottos lottos;
    private final LottoWinningNumbers lottoWinningNumbers;
    private final DecimalFormat decimalFormat = new DecimalFormat("#.##");

    public LottoStatistics(BuyLotto buyLotto, LottoWinningNumbers lottoWinningNumbers) {
        this.lottos = buyLottoListToLottos(buyLotto.buyLottoList());
        this.lottoWinningNumbers = lottoWinningNumbers;
    }

    private Lottos buyLottoListToLottos(String buyLottoList) {
        return new Lottos(stringListToList(buyLottoList.split(NEXT_LINE)));
    }

    private List<Lotto> stringListToList(String[] lottoList) {
        return Arrays.stream(lottoList)
                .map(s -> new Lotto(makeStringToIntegerList(s.split(MAKE_LOTTO_LIST_REGEX))))
                .collect(Collectors.toList());
    }

    private List<LottoNumber> makeStringToIntegerList(String[] lottoList) {
        List<LottoNumber> result = new ArrayList<>();
        for (String str : lottoList) {
            result.add(makeNumber(str));
        }

        return result;
    }

    private LottoNumber makeNumber(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (str.contains(LEFT_BRACKETS)) {
            sb.deleteCharAt(FIRST_INDEX);
        }

        if (str.contains(RIGHT_BRACKETS)) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return new LottoNumber(Integer.parseInt(sb.toString()));
    }


    public double calculateNumbersCount(int count) {
        return lottos.calculateNumbers(lottoWinningNumbers, count);
    }

    public double calculateNumbersAndBonusNumberCount() {
        return lottos.calculateNumbersAndBonusNumber(lottoWinningNumbers.getWinningLotto()
                , lottoWinningNumbers.getBonusNumber());
    }

    public double statistics() {
        decimalFormat.setRoundingMode(RoundingMode.DOWN);
        return Double.parseDouble(decimalFormat.format(
                ((calculateNumbersCount(LottoRank.THREE_NUMBERS.getLottoRank()) * LottoRank.THREE_NUMBERS.getLottoRankMoney())
                        + (calculateNumbersCount(LottoRank.FOUR_NUMBERS.getLottoRank()) * LottoRank.FOUR_NUMBERS.getLottoRankMoney())
                        + (calculateNumbersCount(LottoRank.FIVE_NUMBERS.getLottoRank()) * LottoRank.FIVE_NUMBERS.getLottoRankMoney())
                        + (calculateNumbersAndBonusNumberCount() * LottoRank.FIVE_NUMBERS_AND_BONUS.getLottoRankMoney())
                        + (calculateNumbersCount(LottoRank.SIX_NUMBERS.getLottoRank()) * LottoRank.SIX_NUMBERS.getLottoRankMoney())) / (lottos.size() * LOTTO_PRICE)));
    }

}
