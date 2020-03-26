package sum;

public class Sum {
	public static int sum(String sumParam) {
		ValueList values = new ValueList(sumParam.split("[,:]",-1));
		return values.sum();
	}
}
