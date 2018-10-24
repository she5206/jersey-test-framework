/**
 * Created by mchsieh on 3/22/17.
 */
public class ClassWithStatics {
    public static String getString() {
        return "String";
    }

    public int getPrivate() {
        int rst = getInt();
        return rst;
    }

    private int getInt() {
        return 1;
    }
}
