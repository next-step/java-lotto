package pluscal;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public int add(String text) {

        int totalValue = 0;

        if(text == null || text.isEmpty()){
            text = "0";
        }

        String[] str = seperate(text);
        for(int i = 0; i < str.length; i++){
            int toIntValue = checkMinusNum(toInt(str[i]));
            totalValue = totalValue + toIntValue;
        }

        return totalValue;
    }

    public int checkMinusNum(int number){

        if(number < 0)
            throw new IllegalArgumentException("음수 입니다.");

        return number;
    }

    public String[] seperate(String text) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            return tokens;
        }

        String[] tokens = text.split(",|:");
        return tokens;
    }

    public int toInt(String str){

        int result;

        try{
            result = Integer.parseInt(str);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 구분자가 들어왔습니다.");
        }

        return result;
    }

}
