package sum;

public class Sum {
	public static int sum(String sumParam) {
		if(sumParam == null){
			return 0;
		}
		ValueList values = new ValueList(sumParam.split("[,:]"));
		return values.sum();
	}
}
