package lotto.model;

import lotto.model.enums.Ranking;
import lotto.util.RandomUtil;

import java.util.*;

public class LottoGames {
    public static final int NUMBER_SIZE = 6;
    public static final int NUMBER_RANGE = 45;

    private List<Lotto> games;
    private List<Integer> winningNumbers;
    private Map<Ranking, List<Lotto>> aggregatedGames = new LinkedHashMap<>();

    public LottoGames() {
        games = new ArrayList<>();
    }

    public LottoGames(int count) {
        this();
        this.initGames(count);
        this.initResult();
    }

    private void initResult() {
        aggregatedGames.put(Ranking.FIRST, new ArrayList<>());
        aggregatedGames.put(Ranking.SECOND, new ArrayList<>());
        aggregatedGames.put(Ranking.THIRD, new ArrayList<>());
        aggregatedGames.put(Ranking.FOURTH, new ArrayList<>());
    }

    private void initGames(int count) {
        for (int i = 0; i < count; i++) {
            games.add(initLotto());
        }
    }

    private Lotto initLotto() {
        return new Lotto(RandomUtil.generateRandomList(NUMBER_SIZE,NUMBER_RANGE));
    }

    public int getGameCount(){ return games.size(); }

    public void setWinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> getWinningNumbers(){ return winningNumbers;}

    public List<Lotto> getGames(){ return games; }

    public void aggregate() {
        for (Lotto ticket : games) {
            int count = WinningStatistic.getEqualCount(ticket.getNumbers(), winningNumbers);

            Ranking ranking = Ranking.findRanking(count);

            if(ranking != null){
                List<Lotto> elements = aggregatedGames.getOrDefault(ranking,
                                List.of(ticket));
                aggregatedGames.put(ranking, elements);
            }
        }
    }

    public Map<Ranking, List<Lotto>> getStatistic(){
        return Collections.unmodifiableMap(aggregatedGames);
    }
}
