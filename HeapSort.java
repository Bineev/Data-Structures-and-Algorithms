import java.io.IOException;
import java.util.ArrayList;

public class HeapSort {
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
        ArrayList<Integer> utilityList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            insert(utilityList, list.get(i));
        }
        int n = list.size();
        list.clear();
        for (int i = 0; i < n; i++) {
            list.add(remove_min(utilityList));
        }
    }
}
