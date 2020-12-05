package stringsumcalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separators {

    private static String regex = "//(.)\\\\n(.*)";
    private static Pattern pattern = Pattern.compile(regex);

    private final List<String> separators = new ArrayList<>();
    private String formula;

    public Separators(String string){

        Matcher matcher = pattern.matcher(string);
        formula = string;
        boolean isFind = matcher.find();

        if (isFind) {
            separators.add(matcher.group(1));
            formula = matcher.group(2);
        } else if (!isFind) {
            separators.add(",");
            separators.add(":");
        }

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
