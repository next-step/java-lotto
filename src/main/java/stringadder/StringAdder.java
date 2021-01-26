package stringadder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdder {
    private String input;

    public StringAdder (String input) {
        this.input = input;

    }

    public int add() throws RuntimeException{
        // string 받기
        String temp = this.input;

        // string 잘못됐는지 확인하기
        String[] numsString = validate(temp);
        if(numsString==null){
            return 0;
        }

        // 숫자 더해 결과 반환하기
        int res = 0;
        for(String s : numsString) {
            int num = Integer.parseInt(s);
            if (num < 0) {
                throw new RuntimeException();
            }
            res += Integer.parseInt(s);
        }
        return res;
    }

    private String[] validate (String temp) {
        if(temp == null || temp.length() == 0) {
            return null;
        }

        String Delimiter = ",|:";
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(temp);
        if (m.find()) {
            Delimiter = m.group(1);
            temp = m.group(2);
        }
        String[] numsString = temp.split(Delimiter);

        return numsString;
    }
}
