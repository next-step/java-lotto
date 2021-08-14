/*
 * AutoTicketMaker.java
 *
 * v0.1   2021.08.15
 */

package edu.nextstep.lottoauto.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AutoNumberMaker implements NumberMaker {
    private static final List<Integer> TOTAL_NUMBERS = new ArrayList<>();

    static{
        initTotalNumbers();
    }

    private static void initTotalNumbers() {
        for (int i = 1; i <= 45; i++) {
            TOTAL_NUMBERS.add(i);
        }
    }

    /**
     * 주의사항 : TOTAL_NUMBERS.subList(0, 6) 를 직접 반환하게되면 같은 참조값에 값만 갱신된다.
     *         그래서, 여러값들을 반환해도 다 같은 값을 가리키게 되기 때문에 주의가 필요하다.
     */
    @Override
    public List<Integer> makeNumbers() {
        flushingTotalNumbers();
        return new ArrayList<>(TOTAL_NUMBERS.subList(0, 6));
    }

    protected void flushingTotalNumbers(){
        Collections.shuffle(TOTAL_NUMBERS);
    }

    protected static void sortTotalNumbers(){
        Collections.sort(TOTAL_NUMBERS);
    }
}
