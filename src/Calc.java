// Калькулятор арифметических формул.


public class Calc extends Compf {
    private StackInt s;
    public static int schetSymbolzn=0;
    public static int schetSymbolznP=0;
    private static int char2int(char c) {

       System.out.println("char2int(char c) { Calc");
        return (int)c - (int)'0';
    }
    protected int symOther(char c) {
        System.out.println(" symOther(char c) { Calc");
        if ((c < '0' || c > '9') && (c!=('.'))) {
            System.out.println("Недопустимый символ: " + c);
            System.exit(0);
        }
        return SYM_OTHER;
    }
    protected void nextOper(char c) {
        System.out.println("nextOper(char c) { Calc");

        float second = s.pop();

        float first = s.pop();

        switch (c) {
            case '+':
                s.push(first + second); break;
            case '-':
                s.push(first - second); break;
            case '*':
                s.push(first * second); break;
            case '/':
                s.push(first / second); break;
            case '%':
                s.push(first % second); break;
        }
    }
    protected void nextOther(char c) {
        System.out.println(" nextOther(char c) {Calc");
        if(c!='.') {
            if (Razdelitel) {


                float spop = s.pop();
                float chislo;

                if(KolZnakPosleTochki!=0)
                {
                    chislo= (spop * (float)Math.pow(10,KolZnakPosleTochki)) + char2int(c);
                    chislo=chislo/((float)Math.pow(10,KolZnakPosleTochki));
                    KolZnakPosleTochki++;
                }else {
                    chislo = (spop * 10) + char2int(c);
                }
                s.push(chislo);
                System.out.println("chislo" + chislo + " spop" + spop + "  c" + c);
                Razdelitel = true;


            } else {
                s.push(char2int(c));
                Razdelitel = true;
            }

        }
    }

    public Calc() {//тут видно и эррэй
        System.out.println("     public Calc() { Calc");
        s = new StackInt();
    }

    @Override
    public final void compile(char[] str) {
        System.out.println(" compile(char[] str) { Calc");
        super.compile(str);//super значит что мы обращаемся к методу родительского класса
        System.out.println("" + s.top());
        Razdelitel=false;
    }

}
