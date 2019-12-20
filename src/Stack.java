// Непрерывная реализация стека символов.
class Stack {
    private static final int DEFSIZE = 16;
    private char[] array;
    private int head;
    public Stack() {//первым пришел последним вышел
        System.out.println("сработал конструктор STACK ");
        array = new char[DEFSIZE];
        head = 0;
    }
    public final void push(char c) {
        System.out.println("сработал push(char c) в  STACK   "+ c);
        array[head++] = c; //если head++ стоит внутри другой инструкции ,то сначала то значение которое в хеад ,а потом увиличиваем его на единицу
    }//сдвигаем элемент ,а потом возвращаем

    public final char pop()
    {//final значит ,то мы не сможем переопределять метод
        System.out.println("сработал  pop() в STACK ");
        return array[--head];//
    }

    public final char top() {
        System.out.println("сработал top() в STACK ");
        return array[head-1];

    }
}
