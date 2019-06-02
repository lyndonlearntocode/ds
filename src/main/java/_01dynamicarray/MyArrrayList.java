package _01dynamicarray;

/**
 * @Author: Lyndon_Mi
 * @Date: 6/1/2019 14:59
 * @Description:
 */
public class MyArrrayList<T> {

    private int size;

    private int capacity;

    private T[] data;

    private static final int defaultCapacity = 16;

    private static final float factor = 0.75f;

    public MyArrrayList(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.data = (T[]) new Object[capacity];
    }

    public MyArrrayList() {
        this(defaultCapacity);
    }

    public int size() {
        return size;
    }

    public void add(T element) {
        checkAndGrow();

        data[size] = element;
        size++;
    }

    public void add(int index, T element) {
        checkIndex(index);
        T loopEle = data[index];
        data[index] = element;
        for (int i = index + 1; i < size; i++) {
            T tmp = data[i];
            data[i] = loopEle;
            loopEle = tmp;
        }
        add(loopEle);
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T tmp = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size] = null;
        size--;
        return tmp;
    }

    public T set(int index, T element) {
        checkIndex(index);
        T tmp = data[index];
        data[index] = element;
        return tmp;
    }

    public void clear() {
        size = 0;
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }


    private void checkAndGrow() {
        if (size + 1 > (capacity)) {
            T[] newData = (T[]) new Object[(int) (capacity * (1 + factor))];
            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }
            data = newData;
            capacity = capacity * 2;
        }
    }
}
