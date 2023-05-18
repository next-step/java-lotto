package study.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import study.domain.generator.NumberGenerator;

public class Lottery {
    
    private List<Integer> lottery;
    private boolean isWinnerCheck = false;
    private int matchCount = 0;

    public Lottery(NumberGenerator generator) {
        this.lottery = generator.fetch();
    }

    public List<Integer> getLottery() {
        return this.lottery;
    }

    public int getMatchCount() {
        if (!this.isWinnerCheck) {
            throw new IllegalArgumentException("당첨 번호 확인이 안되었습니다");
        }
        return this.matchCount;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.isWinnerCheck = true;

        for (Integer winNumber : winNumbers) {
            countMatching(winNumber);
        }
    }

    private void countMatching(Integer winNumber) {
        if (this.lottery.contains(winNumber)) {
            this.matchCount++;
        }
    }

}
