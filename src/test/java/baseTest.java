interface Operationable {
    int calculate(int x, int y);
}

public class baseTest {
    public static void main(String[] args) {

        Operationable operation = (x, y) -> x + y;
        int result = operation.calculate(10, 20);
        System.out.println(result); //30
    }
}
