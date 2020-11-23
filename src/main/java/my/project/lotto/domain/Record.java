package my.project.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created : 2020-11-23 오후 12:10
 * Developer : Seo
 */
public class Record {
    private final List<Integer> result;

    public Record() {
        this.result = new ArrayList<>();
    }

    public void add(Integer number) {
        result.add(number);
        sort();
    }

    public void sort() {
        Collections.sort(result);
    }

    public List<Integer> get() {
        return this.result;
    }
}
