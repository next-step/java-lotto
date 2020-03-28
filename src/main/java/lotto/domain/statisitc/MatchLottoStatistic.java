package lotto.domain.statisitc;

import lotto.domain.item.Item;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.MatchLotto;

import java.util.ArrayList;
import java.util.List;

public class MatchLottoStatistic {
    private static final int LOTTO_MATCH_NUMBER_COUNT3 = 3;
    private static final int LOTTO_MATCH_NUMBER_COUNT4 = 4;
    private static final int LOTTO_MATCH_NUMBER_COUNT5 = 5;
    private static final int LOTTO_MATCH_NUMBER_COUNT6 = 6;

    private List<MatchLotto> matchLottos;

    public MatchLottoStatistic() {
        this.matchLottos = new ArrayList<>();
    }

    public MatchLottoStatistic(MatchLotto other) {
        List<MatchLotto> items = new ArrayList<>();
        items.add(other);
        this.matchLottos = items;
    }

    public void collectMatchLotto(List<LottoTicket> lottos, List<Integer> luckyNumber) {
        List<MatchLotto> result = new ArrayList<>();
        for (LottoTicket lotto : lottos) {
            int count = lotto.getCompareLuckNumberMatchCount(luckyNumber);
            addMatchItem(count, lotto);
        }
    }

    public int findMatchCount3Lottos() {
        return getMatchLottoCount(LOTTO_MATCH_NUMBER_COUNT3);
    }

    public int findMatchCount4Lottos() {
        return getMatchLottoCount(LOTTO_MATCH_NUMBER_COUNT4);
    }

    public int findMatchCount5Lottos() {
        return getMatchLottoCount(LOTTO_MATCH_NUMBER_COUNT5);
    }

    public int findMatchCount6Lottos() {
        return getMatchLottoCount(LOTTO_MATCH_NUMBER_COUNT6);
    }

    private int getMatchLottoCount(int matchCount) {
        List<MatchLotto> result = new ArrayList<>();
        for (MatchLotto match : matchLottos) {
            if (match.isMatchCountSame(matchCount)) {
                return match.getItemsCount();
            }
        }
        return 0;
    }

    private int findCountMatchItemIndex(int count) {
        for (int i = 0; i < matchLottos.size(); i++) {
            if (matchLottos.get(i).isMatchCountSame(count)) {
                return i;
            }
        }
        return -1;
    }

    public void addMatchItem(int machCount, Item other) {
        int index = findCountMatchItemIndex(machCount);

        if (index == -1) {
            matchLottos.add(new MatchLotto(machCount, other));
            return;
        }

        matchLottos.set(index, matchLottos.get(index).addItem(other));
    }

    public int size() {
        return matchLottos.size();
    }

    public List<MatchLotto> getMatchLottos() {
        return matchLottos;
    }
}
