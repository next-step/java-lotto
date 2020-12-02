package stringsumcalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separators {

    private static final String REGEX = "//(.)\\\\n(.*)";
    private static final Pattern pattern = Pattern.compile(REGEX);

    private final List<String> separators = new ArrayList<>();
    private String formula;

    public Separators(String string){

        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            separators.add(matcher.group(1));
            formula = matcher.group(2);
        }

        separators.add(",");
        separators.add(":");
    }

    public int getCount(){
        return separators.size();
    }

    public String getSeparator(int index){
        return separators.get(index);
    }

    public String getFormula(){
        return formula;
    }


}
