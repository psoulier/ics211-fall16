import java.util.Comparator;

public class MyArrayList<E> implements List211<E> {
    protected       E[] data;
    private         int size;
    private final   int INIT_SIZE=4;

    MyArrayList() {
        size = 0;
        data = (E[]) new Object[INIT_SIZE];
    }

    void resize(int newSize) {
        E[] tmpArr = (E[]) new Object[newSize];

        System.arraycopy(data, 0, tmpArr, 0, data.length);
        data = tmpArr;
    }

    public boolean add(E item) {
        if (size == data.length) {
            resize(size * 2);
        }

        data[size] = item;
        size++;

        return true;
    }

    public void add(int index, E item) {
        int pos;


        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            if (size == data.length) {
                resize(size*2);
            }

            pos = size;
            while (pos > index) {
                data[pos] = data[pos - 1];
                pos--;
            }

            data[index] = item;
            size++;
        }
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        else {
            return data[index];
        }
    }

    public E remove(int index) {
        E   item;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        item = data[index];
        while (index < size-1) {
            data[index] = data[index + 1];
            index++;
        }

        size--;

        return item;
    }

    public E set(int index, E item) {
        E   oldItem;

        if (index >= size) {
            throw new IndexOutOfBoundsException();
        }

        oldItem = data[index];
        data[index] = item;

        return oldItem;
    }

    public int size() {
        return size;
    }

    public void bubbleSort(Comparator<? super E> cmp) {
        ArraySort<E>    as = new ArraySort<E>();

        as.bubbleSort(data, cmp);
    }

    public void selectionSort(Comparator<? super E> cmp) {
        ArraySort<E>    as = new ArraySort<E>();

        as.bubbleSort(data, cmp);
    }

    public void insertionSort(Comparator<? super E> cmp) {
        ArraySort<E>    as = new ArraySort<E>();

        as.bubbleSort(data, cmp);
    }

}

