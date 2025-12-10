/** Соловйова Катерина, група ІС-31, №21 */
public class Main {
    public static void main(String[] args) {
        // Створюємо два числа у трійковій системі 
        NumberListImpl number1 = new NumberListImpl(3);
        number1.addDigit(1);
        number1.addDigit(0);
        number1.addDigit(2); 

        NumberListImpl number2 = new NumberListImpl(3);
        number2.addDigit(2);
        number2.addDigit(1);
        number2.addDigit(1); 

        System.out.println("Number1: " + number1); 
        System.out.println("Number2: " + number2); 

        // Додавання двох чисел
        NumberListImpl sum = number1.add(number2);
        System.out.println("Sum: " + sum); 

        // Зміна системи числення на вісімкову 
        NumberListImpl sumOctal = sum.changeScale(8);
        System.out.println("Sum in octal: " + sumOctal);
    }}