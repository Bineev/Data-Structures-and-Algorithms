
import java.io.IOException;
import java.util.ArrayList;

public class HeapSortUpgrade {
    public static void main(String[] args) throws IOException {
        System.out.println("Heap Sort");
        ArrayList<Integer> list = new ArrayList<>();
        System.out.println("Before sort");
        for (int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * 100);
            System.out.println(rand);
            list.add(rand);
        }
        heapSort(list);
        System.out.println("After sort");
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void insert(ArrayList<Integer> list, int a) {
        list.add(a);
        int n = list.size();
        int j = n - 1;
        while (j > 0 && list.get((j - 1)/ 2) > list.get(j)) {
            // swap
            int temp = list.get((j - 1)/ 2);
            list.set((j - 1)/ 2, list.get(j));
            list.set(j, temp);
            j = (j - 1)/ 2;
        }
    }

    public static int remove_min(ArrayList<Integer> list) {
        int result = list.get(0);
        int n = list.size();
        list.set(0, list.get(n - 1));
        list.remove(n - 1);
        int j = 0, i = 0;
        while (true) {
            if (2 * i + 1 < list.size() && list.get(2 * i + 1) < list.get(j)) {
                j = 2 * i + 1;
            }
            if (2 * i + 2 < list.size() && list.get(2 * i + 2) < list.get(j)) {
                j = 2 * i + 2;
            }
            if (j == i) {
                break;
            }
            int temp = list.get(j);
            list.set(j, list.get(i));
            list.set(i, temp);
            i = j;
        }
        return result;
    }

    public static void heapSort(ArrayList<Integer> list) {
        int n = list.size();
        // transform list to heap
        for (int i = n - 1; i >= 0; i--) {
            int j = 0, k = i;
            while (k < n) {
                j = k;
                if (2 * k + 1 < n && list.get(2 * k + 1) < list.get(j)) {
                    j = 2 * k + 1;
                }
                if (2 * k + 2 < n && list.get(2 * k + 2) < list.get(j)) {
                    j = 2 * k + 2;
                }
                if (j == k) {
                    break;
                }
                int temp = list.get(j);
                list.set(j, list.get(k));
                list.set(k, temp);
                k = j;
            }
        }
        //transform heap to list with sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = list.get(i);
            list.set(i, list.get(0));
            list.set(0, temp);
            int j = 0, k = 0;
            while (j < i) {
                if (2 * k + 1 < i && list.get(2 * k + 1) < list.get(j)) {
                    j = 2 * k + 1;
                }
                if (2 * k + 2 < i && list.get(2 * k + 2) < list.get(j)) {
                    j = 2 * k + 2;
                }
                if (j == k) {
                    break;
                }
                int temp1 = list.get(j);
                list.set(j, list.get(k));
                list.set(k, temp1);
                k = j;
            }
        }
    }
}
