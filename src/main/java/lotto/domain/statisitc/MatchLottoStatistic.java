package lotto.domain.statisitc;

import lotto.domain.item.Item;
import lotto.domain.item.LottoTicket;
import lotto.domain.item.MatchLotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchLottoStatistic {

//    private List<MatchLotto> matchLottos;
//
//    public MatchLottoStatistic() {
//        this.matchLottos = new ArrayList<>();
//    }
//
//    public MatchLottoStatistic(MatchLotto other) {
//        List<MatchLotto> items = new ArrayList<>();
//        items.add(other);
//        this.matchLottos = items;
//    }
//
//    public void collectMatchLotto(List<LottoTicket> lottos, List<Integer> luckyNumber) {
//        List<MatchLotto> result = new ArrayList<>();
//        for (LottoTicket lotto : lottos) {
//            int count = lotto.getCompareLuckNumberMatchCount(luckyNumber);
//            addMatchItem(count, lotto);
//        }
//    }
//
//    private int getMatchLottoCount(int matchCount) {
//        List<MatchLotto> result = new ArrayList<>();
//        for (MatchLotto match : matchLottos) {
//            if (match.isMatchCountSame(matchCount)) {
//                return match.getItemsCount();
//            }
//        }
//        return 0;
//    }
//
//    private int findCountMatchItemIndex(int count) {
//        for (int i = 0; i < matchLottos.size(); i++) {
//            if (matchLottos.get(i).isMatchCountSame(count)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    public void addMatchItem(int machCount, Item other) {
//        int index = findCountMatchItemIndex(machCount);
//
//        if (index == -1) {
//            matchLottos.add(new MatchLotto(machCount, other));
//            return;
//        }
//
//        matchLottos.set(index, matchLottos.get(index).addItem(other));
//    }
//
//
//
//    public int size() {
//        return matchLottos.size();
//    }
//
//    public List<MatchLotto> getMatchLottos() {
//        return matchLottos;
//    }
}
