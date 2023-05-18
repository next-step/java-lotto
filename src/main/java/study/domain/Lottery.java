package study.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottery {
    
    private List<Integer> lottery = new ArrayList<>();
    private List<Integer> winNumbers;
    private int matchCount = 0;

    public Lottery() {
        List<Integer> mockNumbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            mockNumbers.add(i);
        }

        Collections.shuffle(mockNumbers);

        this.lottery = mockNumbers.subList(0, 6);
        Collections.sort(this.lottery);
    }

    public List<Integer> getLottery() {
        return this.lottery;
    }

    public int getMatchCount() {
        if (this.winNumbers == null) {
            throw new IllegalArgumentException("당첨 번호 확인이 안되었습니다");
        }
        return this.matchCount;
    }

    public void setWinNumbers(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;

        if (this.winNumbers == null) {
            throw new IllegalArgumentException("당첨 번호를 입력해주세요");
        }

        if (this.winNumbers.size() != 6) {
            throw new IllegalArgumentException("당첨 번호 6자리를 입력해주세요");
        }

        for (Integer winNumber : this.winNumbers) {
            countMatching(winNumber);
        }
    }

    private void countMatching(Integer winNumber) {
        if (this.lottery.contains(winNumber)) {
            this.matchCount++;
        }
    }

}
