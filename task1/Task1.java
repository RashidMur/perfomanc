public class Task1 {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int m = Integer.parseInt(args[1]);
        int number = 1;
        do {
            System.out.print(number);
            number = (number + m - 2) % n + 1;
        } while (number != 1);
    }
}
