package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private static final String START_BRACKET = "[";
    private static final String END_BRACKET = "]";
    private static final String NEW_LINE = "\n";

    private List<Lotto> lottos = new ArrayList<>();

    public List<Integer> match(WinningLotto winningLotto) {
        List<Integer> matchCounts = new ArrayList<>();
        for (Lotto lotto : lottos) {
            matchCounts.add(lotto.match(winningLotto.getNumbers()));
        }

        return matchCounts;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public StringBuilder message() {
        StringBuilder message = new StringBuilder();
        message.append(NEW_LINE);
        for (Lotto lotto : lottos) {
            message.append(START_BRACKET);
            message.append(getLottoNumbers(lotto));
            message.append(END_BRACKET);
            message.append(NEW_LINE);
        }
        return message;
    }

    private String getLottoNumbers(Lotto lotto) {
        return lotto.getLottoNumbers();

    }
}
