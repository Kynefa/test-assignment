class NumberListImpl {

    private static class Node {
        int digit;
        Node prev;
        Node next;

        Node(int digit) {
            this.digit = digit;
        }
    }

    private Node head;
    private Node tail;
    private int size;
    private int base; 
    public NumberListImpl(int base) {
        if (base < 2 || base > 16)
            throw new IllegalArgumentException("Base must be between 2 and 16");
        this.base = base;
        this.size = 0;
    }

    //Методи списку 
    public void addDigit(int digit) {
        if (digit < 0 || digit >= base)
            throw new IllegalArgumentException("Digit out of base range");
        Node node = new Node(digit);
        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        size++;
    }
 
    public int getDigit(int index) {  //Отримання цифри за індексом
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node current = head;
        for (int i = 0; i < index; i++)
            current = current.next;
        return current.digit;
    }

    public int size() {
        return size;
    }

    public int getBase() {
        return base;
    }

    //Перетворення системи числення ((C5+1)/ 5)
    public NumberListImpl changeScale(int newBase) {
        if (newBase < 2 || newBase > 16)
            throw new IllegalArgumentException("Base must be between 2 and 16");

        long number = toDecimal();
        NumberListImpl result = new NumberListImpl(newBase);

        if (number == 0) {
            result.addDigit(0);
            return result;
        }

        while (number > 0) {
            int digit = (int) (number % newBase);
            result.addDigitFront(digit);
            number /= newBase;
        }
        return result;
    }
    //Додає цифру на початок списку
    private void addDigitFront(int digit) {
        Node node = new Node(digit);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    //Перетворення у десяткову систему
    private long toDecimal() {
        long num = 0;
        Node current = head;
        while (current != null) {
            num = num * base + current.digit;
            current = current.next;
        }
        return num;
    }

    //Додаткові операції
    public NumberListImpl add(NumberListImpl other) {
        long a = this.toDecimal();
        long b = other.toDecimal();
        long sum = a + b;

        NumberListImpl result = new NumberListImpl(this.base);
        if (sum == 0) {
            result.addDigit(0);
            return result;
        }

        while (sum > 0) {
            result.addDigitFront((int) (sum % this.base));
            sum /= this.base;
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(Integer.toString(current.digit, base).toUpperCase());
            current = current.next;
        }
        return sb.toString();
    }

    public void clear() {
        head = tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}




