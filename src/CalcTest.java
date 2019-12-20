import java.util.Scanner;

// Тест для калькулятора формул.
public class CalcTest {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);
        Calc c = new Calc();
        while (true) {
            System.out.print("Введите формулу -> ");
            String readt = in.nextLine();
            c.compile(readt.toCharArray());
        }

    }
}