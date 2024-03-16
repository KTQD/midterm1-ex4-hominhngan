public class Main {

    static int sum = 0;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 6, 2, 7, 8, 0, 4, 3, 9, 2, 8, 1, 0, 5, 7, 4, 6, 9, 3, 2, 1, 8, 4, 0, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0, 8, 4, 6, 7, 9, 5, 3, 2, 1, 0};
        Thread sumThread = new Thread(() -> {
            for (int number : numbers) {
                synchronized (Main.class) {
                    sum += number;
                }
            }
        });

        Thread maxThread = new Thread(() -> {
            for (int number : numbers) {
                synchronized (Main.class) {
                    if (number > max) {
                        max = number;
                    }
                }
            }
        });

        sumThread.start();
        maxThread.start();

        try {
            sumThread.join();
            maxThread.join();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Phần tử lớn nhất trong mảng là: " + max);
        System.out.println("Tổng của các phần tử trong mảng là: " + sum);

    }
}
