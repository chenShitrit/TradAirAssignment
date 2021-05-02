    public class Searcher implements Runnable {
        private int[] array;
        private int element;
        private int leftIndex;
        private int rightIndex;

        static boolean isExist = false;

        public Searcher(int[] arr, int left, int right, int x) {
            array = arr;
            element = x;
            leftIndex = left;
            rightIndex = right;
        }

        public static boolean getIsExit() {
            return isExist;
        }

        //recursive function to find the given element
        public void recSearch() {
            if (rightIndex < leftIndex)
                return;
            if (array[leftIndex] == element) {
                System.out.println("Found x at index: " + leftIndex);
                isExist = true;
            }
            leftIndex++;
            recSearch();
        }

        public void run() {
            recSearch();
        }
    }