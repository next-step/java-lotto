package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private final String DEFAULT_DELIMITERS = ",|:";
    private final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private String given;
    private List<String> tokens = new ArrayList<>();

    private List<Integer> numbers = new ArrayList<>();

    public Numbers(String given){
        this.given = given;
        tokens = splitString();
        listConvertedFromArray();
    }

    public List<String> splitString(){
        Matcher custom_matcher = CUSTOM_PATTERN.matcher(given);
        Matcher default_matcher = Pattern.compile(DEFAULT_DELIMITERS).matcher(given);

        if(custom_matcher.find()){
            String custom_delimiter = custom_matcher.group(1);
            tokens = Arrays.asList(custom_matcher.group(2).split(custom_delimiter));
        }
        if(default_matcher.find()){
            tokens = Arrays.asList(given.split(DEFAULT_DELIMITERS));
        }
        if(given.length()==1){
            tokens.add(given);
        }
        return tokens;
    }

    public void listConvertedFromArray(){
        for (String s : tokens) {
            isNotNumberOrNegativeNumber(s);
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
    }

    public void isNotNumberOrNegativeNumber(String s){
        try {
            if(Integer.parseInt(s)<0){
                throw new RuntimeException();
            }
        } catch (NumberFormatException e){
            throw new RuntimeException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
