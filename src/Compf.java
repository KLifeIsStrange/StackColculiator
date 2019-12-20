// Стековый компилятор формул.
//когда появится интерпретатор ,мы сделаем на основе компилятора ,с полупыстыми методами . Трю выделенных методов будет в нем
public class Compf extends Stack {
    public static int KolZnakPosleTochki=0;
    public static boolean Razdelitel;
    // Типы символов (скобки, знаки операции, ин1ое).
    protected final static int SYM_LEFT = 0,//стек для операций
            SYM_RIGHT = 1,
            SYM_OPER = 2,
            SYM_OTHER = 3;

    private int symType(char c) {
        System.out.println("сработал symType(char c) в Compf наследник Stack ");
        switch (c) {
            case '(':
            case '[':
            case '{':
                System.out.println("сработал symType(char c) case '(':ВОЗВРАЩАЕМ SYM_LEFT "); return SYM_LEFT;
            case ')':
            case ']':
            case '}':
                System.out.println("сработал symType(char c)   case ')': ВОЗВРАЩАЕМ SYM_RIGHT"); return SYM_RIGHT;
            case '+': case '-': case '*': case '/':case '%':
                System.out.println("сработал symType(char c)  case '+': case '-': case '*': case '/': ВОЗВРАЩАЕМ SYM_OPER"); return SYM_OPER;
            case '.':
                KolZnakPosleTochki++;return SYM_OTHER;
            default:
                System.out.println("сработал symType(char c) default ВОЗВРАЩАЕМ  symOther(c)"); return symOther(c);
        }
    }
    private void processSymbol(char c) {
        System.out.println("сработал processSymbol(char c)  В COMPF");
        switch (symType(c)) {
            case SYM_LEFT:
                System.out.println("SYM_LEFT В COMPF");push(c); break;//добавляем скобку фиктивную на первый элемент стека и сдвигаем голову
            case SYM_RIGHT:
                System.out.println("SYM_RIGHT:  В COMPF");KolZnakPosleTochki=0; processSuspendedSymbols(c); pop(); break;
            case SYM_OPER://плюс будет обрататываться тут
                System.out.println("SYM_OPER  В COMPF");KolZnakPosleTochki=0;processSuspendedSymbols(c);  push(c); Razdelitel=false; break;//обработка подвешанного символа,а потом мы загоним его в стек
            case SYM_OTHER:         //тут будет двойка                         //подвешанный значит ,что определяется приоритет сначала в стек кладутся скобки потом  умножения потом плюсы
                System.out.println("сработал SYM_OTHER  В COMPF");nextOther(c); break;//когда будет обрабатывать двойку ,то пойдет не тут в функцию,а в calc из-за метода super
        }
    }
    private void processSuspendedSymbols(char c) {
        while (precedes(top(), c))//верхушка стека и подвешанный символ
        {  System.out.println("processSuspendedSymbols(char c) В COMPF");
            nextOper(pop());
            //присвоить
        }
    }
    private int priority(char c) {
        System.out.println("priority(char c) В COMPF");
        return c == '+' || c == '-' ? 1 : 2;
    }
    private boolean precedes(char a, char b) {
        System.out.println("precedes(char a, char b)  В COMPF");
        if(symType(a) == SYM_LEFT) return false;//если преред опирацией скобка
        if(symType(b) == SYM_RIGHT) return true;// б мы вывели и пришел плюс
        return priority(a) >= priority(b);//
    }
    protected int symOther(char c) {
        System.out.println(" symOther(char c)  В COMPF");

            if ((c < ('a') || c > ('z')) && (c!=('.'))) {
                System.out.println("Недопустимый символ: " + c);
                System.exit(0);
            }

        return SYM_OTHER;
}
    protected void nextOper(char c) {

        System.out.println("" + c + " ");
        System.out.println("  nextOper(char c) {  В COMPF");
    }
    protected void nextOther(char c) {

        System.out.println("  nextOther(char c) { {  В COMPF");
        nextOper(c);

    }
    public void compile(char[] str) {//
        System.out.println("   compile(char[] str) {  В COMPF");
        processSymbol('(');
        for(int i = 0; i < str.length; i++) {

            processSymbol(str[i]);

        }
        processSymbol(')');

        System.out.print("\n");
    }
}