package lotto.domain;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class Winners {
    public static final int FINAL_LINE_BREAK = 1;
    public static final int FIRST_STRING = 0;

    private Map<String, Integer> winners = new LinkedHashMap<>();

    public Winners() {
        for (int i = 3; i <= 6; i++) {
            winners.put(i + "개", 0);
        }
    }

    public void addWinner(int count) {
        winners.put(count + "개", winners.get(count + "개") + 1);
    }

    public double revenue(int money) {
        double amount = 0;
        for (String winner : winners.keySet()) {
            amount += Winnings.selectWinnings(winner) * winners.get(winner);
        }
        return amount / money;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Winners winners1 = (Winners) o;
        return Objects.equals(winners, winners1.winners);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winners);
    }

    @Override
    public String toString() {
        String resultString = "";
        for (String winner : winners.keySet()) {
            resultString += winner + " 일치 (" + Winnings.selectWinnings(winner) + "원)- " + winners.get(winner) + "개" + "\n";
        }

        return resultString.substring(FIRST_STRING, resultString.length() - FINAL_LINE_BREAK);
    }


}
