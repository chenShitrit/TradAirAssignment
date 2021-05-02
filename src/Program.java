import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] arr = {5, 8, 2, 2, 7, 32, 240, 24, 70, 4, 2, 2, 2, 13, 1, 6};
        System.out.println("Please enter the number of threads: ");
        int threadsNum = s.nextInt();
        System.out.println("Please enter the number you wish to find in the array: ");
        int element = s.nextInt();
        searchElement(arr, threadsNum, element);

        if(!Searcher.getIsExit()) {
            System.out.println("The number does not exist in the array");
        }
    }

    private static void searchElement(int[] arr, int threadsNum, int x) {
        int arraySize = arr.length;
        int searchRange = arraySize / threadsNum;
        for (int i = 0; i <= threadsNum - 1; i++) {
            Thread thread;
            if (i == threadsNum-1) {
                thread = new Thread(new Searcher(arr, i*searchRange, arraySize-1, x));
            } else {
                thread = new Thread(new Searcher(arr, i*searchRange, searchRange*(i+1) -1, x));
            }
            thread.start();
        }
    }
}

