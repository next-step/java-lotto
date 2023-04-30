package lotto.model;

import lotto.util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGames {
    public static final String COMMA = ", ";
    public static final int NUMBER_SIZE = 6;
    public static final int NUMBER_RANGE = 45;

    private List<Lotto> games;
    private List<Integer> winningNumbers;

    public LottoGames() {
        games = new ArrayList<>();
    }

    public LottoGames(int count) {
        this();
        this.setInitial(count);
    }

    private void setInitial(int count) {
        for (int i = 0; i < count; i++) {
            games.add(initLotto());
        }
    }

    private Lotto initLotto() {
        return new Lotto(RandomUtil.generateRandomList(NUMBER_SIZE,NUMBER_RANGE));
    }

    public int getGameCount(){ return games.size(); }

    public List<Lotto> getGames() {
        return Collections.unmodifiableList(games);
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = Arrays.stream(winningNumbers.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers(){
        return Collections.unmodifiableList(winningNumbers);
    }


    public void showAllTickets(){
        games.stream().forEach(g -> System.out.println(g.toString()));
        System.out.println("");
    }
}
