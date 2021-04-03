package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Numbers {
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private final String given;
    // TODO 사용하지 않는 변수 삭제
    private List<String> tokens = new ArrayList<>();
    private final List<Integer> numbers = new ArrayList<>();

    public Numbers(String given){
        this.given = given;
        tokens = splitString();
        listConvertedFromArray();
    }

    // TODO 생성자에서만 사용되는 메서드의 접근제한자 수정
    public List<String> splitString(){
        // TODO 자바 코드컨벤션 준수
        Matcher custom_matcher = CUSTOM_PATTERN.matcher(given);
        // TODO Pattern을 상수로 변경
        Matcher default_matcher = Pattern.compile(DEFAULT_DELIMITERS).matcher(given);

        if(custom_matcher.find()){
            // TODO 자바 코드컨벤션 준수
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

    // TODO 생성자에서만 사용되는 메서드의 접근제한자 수정
    public void listConvertedFromArray(){
        for (String s : tokens) {
            isNotNumberOrNegativeNumber(s);
            int number = Integer.parseInt(s);
            numbers.add(number);
        }
    }

    // TODO 생성자에서만 사용되는 메서드의 접근제한자 수정
    public void isNotNumberOrNegativeNumber(String s){
        try {
            if(Integer.parseInt(s)<0){
                throw new RuntimeException();
            }
            // TODO 예외 상속구조 고려하여 리팩토링
        } catch (NumberFormatException e){
            throw new RuntimeException();
        }
    }

    public List<Integer> getNumbers(){
        return numbers;
    }
}
