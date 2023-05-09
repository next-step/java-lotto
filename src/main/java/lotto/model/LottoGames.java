package lotto.model;

import lotto.model.enums.MatchingStrategy;
import lotto.util.RandomUtil;

import java.util.*;

public class LottoGames {
    public static final int NUMBER_SIZE = 6;
    public static final int NUMBER_RANGE = 45;
    private List<Lotto> games;
    private Set<Integer> winningNumbers;
    private Integer bonusNumber;
    private Map<MatchingStrategy, List<Lotto>> aggregatedGames = new LinkedHashMap<>();

    public LottoGames() {
        games = new ArrayList<>();
        this.initResult();
    }

    public LottoGames(int count) {
        this();
        this.initGames(count);
    }

    private void initResult() {
//        aggregatedGames.put(MatchingStrategy.SIX, new ArrayList<>());
//        aggregatedGames.put(MatchingStrategy.FIVE_WITH_BONUS, new ArrayList<>());
//        aggregatedGames.put(MatchingStrategy.FIVE, new ArrayList<>());
//        aggregatedGames.put(MatchingStrategy.FOUR, new ArrayList<>());
//        aggregatedGames.put(MatchingStrategy.THREE, new ArrayList<>());
    }

    private void initGames(int count) {
        for (int i = 0; i < count; i++) {
            addLotto(initLotto());
        }
    }


    private Lotto initLotto() {
        return new Lotto(RandomUtil.generateRandomList(NUMBER_SIZE,NUMBER_RANGE));
    }

    public void addLotto(Lotto lotto) {
        games.add(lotto);
    }

    public int getGameCount(){ return games.size(); }

    public void setWinningNumbers(Set<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public Set<Integer> getWinningNumbers(){ return winningNumbers;}

    public List<Lotto> getGames(){ return games; }

    public void aggregate() {
        games.forEach(this::calculateEqualCount);
    }

    private void calculateEqualCount(Lotto ticket) {
        int count = WinningStatistic.getEqualCount(ticket.getNumbers(), winningNumbers);
        boolean isContained = WinningStatistic.isContains(ticket.getNumbers(), bonusNumber);

        if(isContained) {
            count+=1;
        }

        Optional.ofNullable(MatchingStrategy.find(count, isContained))
                .ifPresent((result)->  {
                        List<Lotto> elements = aggregatedGames.getOrDefault(result, List.of(ticket));
                        aggregatedGames.put(result, elements);
                    }
                );
    }

    public Map<MatchingStrategy, List<Lotto>> getStatistic(){
        return Collections.unmodifiableMap(aggregatedGames);
    }

    public void setBonusNumber(int input) {
        this.bonusNumber = input;
    }

    public Integer getBonusNumber() {
        return this.bonusNumber;
    }
}
