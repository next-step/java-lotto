package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int count) {
        lottos = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            lottos.add(Lotto.createQuickPick());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>();
        for (int i = 0; i < lottos.size(); ++i) {
            this.lottos.add(lottos.get(i));
        }
    }

    public Map<Division, Integer> compareNumbers(Lotto comparingLotto) {
        Map<Division, Integer> winnerCountMap = initializeWinnerCountMap();
        List<Division> divisions = new ArrayList<>();
        for (Lotto lotto: lottos) {
            Division division = lotto.compareNumbers(comparingLotto);
            divisions.add(division);
        }
        divisions.removeAll(Collections.singletonList(null));

        for (Division division: divisions) {
            winnerCountMap.put(division, winnerCountMap.getOrDefault(division, 0) + 1);
        }
        return winnerCountMap;
    }

    private Map<Division, Integer> initializeWinnerCountMap() {
        Map<Division, Integer> winnerCountMap = new EnumMap<>(Division.class);
        winnerCountMap.put(Division.FIFTH, 0);
        winnerCountMap.put(Division.FOURTH, 0);
        winnerCountMap.put(Division.THIRD, 0);
        winnerCountMap.put(Division.FIRST, 0);
        return winnerCountMap;
    }


    public int size() {
        return lottos.size();
    }

    public List<List<Integer>> getLottos() {
        List<List<Integer>> returnLottos = new ArrayList<>();
        for (Lotto lotto: lottos) {
            returnLottos.add(lotto.getNumbers());
        }
        return returnLottos;
    }
}
