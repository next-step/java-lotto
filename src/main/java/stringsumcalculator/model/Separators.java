package stringsumcalculator.model;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separators {

    private final List<Separator> separators = new ArrayList<>();
    private final String REGEX = "//(.)\\\\n(.*)";
    private final Pattern pattern = Pattern.compile(REGEX);
    private String formula;

    public Separators(String string){

        Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            separators.add(new Separator(matcher.group(1)));
            formula = matcher.group(2);
        }

        separators.add(new Separator(","));
        separators.add(new Separator(":"));
    }

    public int getCount(){
        return separators.size();
    }

    public Separator getSeparator(int index){
        return separators.get(index);
    }

    public String getFormula(){
        return formula;
    }


}
