package step1;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private final Splitter splitter;
    private List<String> tokens;
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String given, Splitter splitter){
        this.splitter = splitter;
        tokens = splitter.splitStringIntoList(given);
        validationStringType(given);
        listConvertedFromArray();
    }

    private void validationStringType(String given){
        tokens = splitter.splitStringIntoList(given);
        for (String word : tokens) {
            throwsExceptionWhenNotNumberOrNegativeNumber(word);
        }
    }

    private void throwsExceptionWhenNotNumberOrNegativeNumber(String word){
        if(Integer.parseInt(word)<0){
            throw new RuntimeException();
        }
    }

    private void listConvertedFromArray(){
        for (String s : tokens) {
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
