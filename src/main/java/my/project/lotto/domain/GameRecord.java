package my.project.lotto.domain;

import my.project.utils.IntUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class GameRecord {
    private final List<Integer> result;

    public GameRecord() {
        this.result = new ArrayList<>();
    }

    public void add(Integer number) {
        IntUtils.isQualified(number);
        result.add(number);
        sort();
    }

    public void sort() {
        Collections.sort(result);
    }

    public List<Integer> get() {
        return this.result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Integer i : result) {
            sb.append(", ");
            sb.append(i);
        }
        sb.append("]");
        return sb.toString().replaceFirst(", ", "");
    }
}
