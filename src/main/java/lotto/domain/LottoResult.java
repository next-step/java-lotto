package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class LottoResult {
    private static final String BUY_MESSAGE = "개를 구매했습니다.";
    private static final String COMMA_SEPARATOR = ",";
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String NEW_LINE = "\n";

    private Lottos lottos;
    private LottoCount lottoCount;
    private StringBuilder lottosView;

    public LottoResult(Lottos lottos, LottoCount lottoCount) {
        this.lottos = lottos;
        this.lottoCount = lottoCount;
    }

    public void reportLottos() {
        lottosView = new StringBuilder();
        lottosView.append(getLottoBuyMessage());
        lottosView.append(getCreateLottoNumber());
    }

    private StringBuilder getLottoBuyMessage() {
        StringBuilder message = new StringBuilder();
        message.append(Integer.toString(lottoCount.count()));
        message.append(BUY_MESSAGE);
        return message;
    }

    public StringBuilder getCreateLottoNumber() {
        StringBuilder message = new StringBuilder();
        message.append(NEW_LINE);
        for (Lotto lotto : lottos.getLottos()) {
            message.append(START_BRACKET);
            message.append(getLottoNumbers(lotto.getLotto()));
            message.append(END_BRACKET);
            message.append(NEW_LINE);
        }
        return message;
    }

    public String getLottoNumbers(List<LottoNumber> lotto) {
        return lotto.stream()
                .map(lottoNumber -> Integer.toString(lottoNumber.number()))
                .collect(Collectors.joining(COMMA_SEPARATOR));
    }


    public StringBuilder getLottosView() {
        return lottosView;
    }

    public StringBuilder getStatisticsView(List<Integer> matchCounts) {
        LottoStatistic lottoStatistic = new LottoStatistic(matchCounts, lottoCount);
        return lottoStatistic.message();
    }
}
