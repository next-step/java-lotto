package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringCalculator {

    void StringCalculator() {


    }

    public List split(String str) {
        String reg = "[,:]";

        List<Integer> strcharList = new ArrayList<>();
        for (String c : str.split(reg)) {
            strcharList.add(Integer.valueOf(c));
        }

        return strcharList;
    }

    public int add(List<Integer> strcharList) {
        return strcharList.stream().reduce((a, b) -> Integer.sum(a, b)).get();
    }
}
