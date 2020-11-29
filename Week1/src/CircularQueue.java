import java.util.Arrays;
import java.util.Collection;
import java.util.Deque;
import java.util.Iterator;

/**
 * 循环双端队列
 *
 * @param <T>
 */
public class CircularQueue<T> implements Deque<T> {

    /**
     * 存储数据的数组
     */
    private Object[] data;

    /**
     * 队列的大小
     */
    private int n = 0;

    /**
     * 队列头
     */
    private int head = 0;

    /**
     * 队列尾
     */
    private int tail = 0;

    public CircularQueue(int capacity) {
        data = new Object[capacity];
        n = capacity;
    }


    /**
     * 判断该循环队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * 判断该循环队列是否满
     *
     * @return
     */
    private boolean isFull() {
        return (tail + 1) % n == head;
    }

    public void printAll() {
        System.out.println(Arrays.toString(data) + "head=" + head + ",tail=" + tail);
    }


    @Override
    public void addFirst(T t) {
        if (t == null) {
            throw new NullPointerException();
        }
        if (isFull()) {
            return;
        }
        if (head == 0) {
            head = n - 1;
        } else {
            head = head - 1;
        }
        data[head] = t;

    }

    @Override
    public void addLast(T t) {
        add(t);
    }

    @Override
    public boolean offerFirst(T t) {
        addFirst(t);
        return true;
    }

    @Override
    public boolean offerLast(T t) {
        return add(t);
    }

    @Override
    public T removeFirst() {
        return remove();
    }

    @Override
    public T removeLast() {
        // 如果head == tail 表示队列为空
        if (isEmpty()) {
            return null;
        }
        if (tail == 0) {
            tail = n - 1;
        } else {
            tail = tail - 1;
        }
        return (T) data[tail];
    }

    @Override
    public T pollFirst() {
        return remove();
    }

    @Override
    public T pollLast() {
        return removeLast();
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T peekFirst() {
        return null;
    }

    @Override
    public T peekLast() {
        return null;
    }

    @Override
    public boolean removeFirstOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean removeLastOccurrence(Object o) {
        return false;
    }

    @Override
    public boolean add(T t) {
        return offer(t);
    }

    @Override
    public boolean offer(T t) {
        // 队列满了
        if ((tail + 1) % n == head) {
            return false;
        }
        data[tail] = t;
        tail = (tail + 1) % n;
        return true;
    }


    @Override
    public T remove() {
        // 如果head == tail 表示队列为空
        if (isEmpty()) {
            return null;
        }
        Object result = data[head];
        head = (head + 1) % n;
        return (T) result;
    }

    @Override
    public T poll() {
        return remove();
    }

    @Override
    public T element() {
        return null;
    }

    @Override
    public T peek() {
        return null;
    }

    @Override
    public void push(T t) {

    }

    @Override
    public T pop() {
        return null;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    @Override
    public Iterator<T> descendingIterator() {
        return null;
    }


    public static void main(String[] args) {
        CircularQueue<String> circularQueue = new CircularQueue<>(4);
        System.out.println(circularQueue.add("1"));
        circularQueue.printAll();
        circularQueue.addFirst("2");
        circularQueue.printAll();
        circularQueue.addLast("3");
        circularQueue.printAll();
        circularQueue.addLast("4");
        circularQueue.printAll();

        circularQueue.addFirst("5");
        circularQueue.printAll();

        System.out.println(circularQueue.removeLast());
        circularQueue.printAll();
        System.out.println(circularQueue.removeFirst());
        circularQueue.printAll();
        System.out.println(circularQueue.removeLast());
        circularQueue.printAll();
        System.out.println(circularQueue.removeLast());
        circularQueue.printAll();

    }
}
