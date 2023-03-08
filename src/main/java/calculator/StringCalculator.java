package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringCalculator {

    private StringObject separation(String text){
        StringObject textObj = new StringObject(text);
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(textObj.getText());
        if(m.find()){
            textObj = new StringObject(m.group(2),m.group(1));
        }
        return textObj;
    }
    public  int add(String text){
        StringObject textObj = separation(text);

        String[] tokens= textObj.getText().split(textObj.getSeparator());

        if(Arrays.stream(tokens).map(Integer::parseInt).anyMatch(integer -> integer < 0)) {  // 하나라도 -1 이하면
            throw new RuntimeException();
        }
        return Arrays.stream(tokens).map(Integer::parseInt).reduce(0,Integer::sum);
    }

}
