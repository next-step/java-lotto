package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SeparateStringExtractor {

    private String separator = ",|:";

    private String expression = null;


    public SeparateStringExtractor(String expression) {

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(expression);

        if(m.find()){
            separator = m.group(1);
            this.expression = m.group(2);
            return;
        }

        this.expression = expression;
    }

    public String getSeparator(){
        return separator;
    }

    public String getExpression(){
        return expression;
    }
}
