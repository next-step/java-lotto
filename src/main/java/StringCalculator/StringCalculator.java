package StringCalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    void StringCalculator() {


    }

    public List split(String str) {
        String customDelimiter = null;
            Matcher m = Pattern.compile("//(.)\n(.*)").matcher(str);
            if (m.find()) {
                customDelimiter = m.group(1);

                System.out.println(m.group());
                System.out.println(m.group(1));
                System.out.println(m.group(2));

                String[] tokens= m.group(2).split(customDelimiter);
            }


        String reg = "[,"+customDelimiter+":]";

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
