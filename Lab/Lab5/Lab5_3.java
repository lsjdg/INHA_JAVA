package Lab5;
import java.util.Scanner;

abstract class Stack {
    public abstract int length();
    public abstract int capacity();
    public abstract String pop();
    public abstract boolean push(String str);
}

class StringStack extends Stack {
    int tos = -1;
    String arr[];

    StringStack(int size) {
        arr = new String[size];
    }

    @Override
    public int length() {
        return this.tos + 1;
    }

    @Override
    public int capacity() {
        return arr.length;
    }

    @Override
    public String pop() {
        if (tos == -1) {
            return null;
        } else {
            tos--;
            return arr[tos + 1];
        }
    }

    @Override
    public boolean push(String str) {
        if (length() >= capacity()) {
            return false;
        } else {
            tos++;
            arr[tos] = str;
            return true;
        }
    }
}

public class Lab5_3 {
    public static void main(String args[]) {
        System.out.print("size of stack: ");
        Scanner sizeScanner = new Scanner(System.in);
        int size = sizeScanner.nextInt();
        sizeScanner.nextLine(); // Consume the newline character

        StringStack ss = new StringStack(size);
        Scanner inputScanner = new Scanner(System.in);

        while (true) {
            System.out.print("input: ");
            String input = inputScanner.nextLine();

            if (input.equals("exit")) {
                System.out.print("pop all strings: ");
                while (ss.length() > 0) {
                    System.out.print(ss.pop() + " ");
                }
                break;
            } else if (ss.length() >= ss.capacity()) {
                System.out.println("stack is full!");
            } else {
                ss.push(input);
            }
        }
        inputScanner.close();
        sizeScanner.close();
    }
}
