package view;

import domain.*;

import java.util.List;

public class ConsoleOutputView implements OutputView
{
    private static final String SEPARATOR_OF_LOTTO = "\n";
    private static final String STARTING_BRACKET ="[";
    private static final String LAST_BRACKET ="]";
    private static final String SPLITERATOR_OF_LOTTO_NUMBERS = ", ";
    private static final int STARTING_INDEX_STRING = 0;
    private static final int STARTING_INDEX_FOR_INSERTING_SPLITERATOR = 1;

    @Override
    public void showTotalNumberOfLottos(int numberOfLottos) {
        System.out.printf("You purchased %d lottos.\n", numberOfLottos);
    }

    @Override
    public void showRandomGeneratedLottos(Lottos lottos) {
        System.out.println(lottosAsString(lottos));
    }

    @Override
    public void showLottoResult(Prizes prizes) {
        for (PrizeCondition prizeCondition : PrizeCondition.values()) {
            System.out.printf("%d matched (￦%d) - %d\n",
                    prizeCondition.getMatchingNumber(),
                    prizeCondition.getReward(),
                    prizes.match(prizeCondition));
        }
    }

    @Override
    public void showProfitRate(double profitRate) {
        System.out.printf("Total Profit Rate is %.2f\n", profitRate);
    }

    private String lottosAsString(Lottos lottos) {
        return lottos.stream()
                .map(this::provideNumbers)
                .reduce("", (acc, lotto) -> acc + SEPARATOR_OF_LOTTO + lotto);
    }

    private String provideNumbers(Lotto lotto) {
        List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STARTING_BRACKET);
        stringBuilder.append(lottoNumbers.get(STARTING_INDEX_STRING));

        for (int i = STARTING_INDEX_FOR_INSERTING_SPLITERATOR; i < lottoNumbers.size(); i++) {
            stringBuilder.append(SPLITERATOR_OF_LOTTO_NUMBERS);
            stringBuilder.append(lottoNumbers.get(i));
        }
        stringBuilder.append(LAST_BRACKET);

        return stringBuilder.toString();
    }
}
