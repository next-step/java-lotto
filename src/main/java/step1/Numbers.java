package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private Splitter splitter;
    private final String given;
    // TODO 사용하지 않는 변수 삭제
    private List<String> tokens = new ArrayList<>();
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String given){
        this.given = given;
        splitter = new StringSplitter();
        tokens = splitter.splitStringIntoList(given);
        listConvertedFromArray();
    }

    private void listConvertedFromArray(){
        for (String s : tokens) {
            isNotNumberOrNegativeNumber(s);
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
    }

    private void isNotNumberOrNegativeNumber(String s){
        try {
            if(Integer.parseInt(s)<0){
                throw new RuntimeException();
            }
        } catch (Exception e){
            throw new RuntimeException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
