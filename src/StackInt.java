// Непрерывная реализация стека целых чисел.
class StackInt {
    private static final int DEFSIZE = 16;
    private float[] array;
    private int head;
    public StackInt() {//инициализация массива для цифр
        System.out.println(" compile(char[] str) {StackInt() ");
        array = new float[DEFSIZE];
        head = 0;
    }
    public final void push(float val) {
        System.out.println(" push(int val) { StackInt() "+val);
        array[head++] = val;
    }
    public final float pop() {
        System.out.println("pop() { StackInt()" );
        return array[--head];
    }
    public final float top() {
        System.out.println(" top() { StackInt() ");
        return array[head-1];
    }

}