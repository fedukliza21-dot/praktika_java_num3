package praktika09.task03;

public class MergeStudents {

    // Объединяет два списка студентов в один отсортированный (по iDNumber)
    // с помощью сортировки слиянием.
    public static Student[] mergeLists(Student[] first, Student[] second) {
        // 1) каждый список сортируем слиянием (рекурсивно делим пополам)
        Student[] a = copy(first);
        Student[] b = copy(second);
        mergeSort(a, 0, a.length - 1);
        mergeSort(b, 0, b.length - 1);

        // 2) сливаем два отсортированных списка в один
        return merge(a, b);
    }

    // Сортировка слиянием части массива arr[low..high]
    private static void mergeSort(Student[] arr, int low, int high) {
        if (low >= high) {                 // базовый случай: 0 или 1 элемент
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);          // левая половина
        mergeSort(arr, mid + 1, high);     // правая половина

        // сливаем две отсортированные половины arr[low..mid] и arr[mid+1..high]
        Student[] left = part(arr, low, mid);
        Student[] right = part(arr, mid + 1, high);
        Student[] merged = merge(left, right);
        for (int k = 0; k < merged.length; k++) {
            arr[low + k] = merged[k];
        }
    }

    // Слияние двух уже отсортированных массивов в один отсортированный
    private static Student[] merge(Student[] a, Student[] b) {
        Student[] result = new Student[a.length + b.length];
        int i = 0;   // позиция в a
        int j = 0;   // позиция в b
        int k = 0;   // позиция в result

        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) <= 0) {   // берём меньший из двух текущих
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }
        while (i < a.length) {                 // остаток первого списка
            result[k++] = a[i++];
        }
        while (j < b.length) {                 // остаток второго списка
            result[k++] = b[j++];
        }
        return result;
    }

    // Копия части массива arr[from..to]
    private static Student[] part(Student[] arr, int from, int to) {
        Student[] result = new Student[to - from + 1];
        for (int i = 0; i < result.length; i++) {
            result[i] = arr[from + i];
        }
        return result;
    }

    private static Student[] copy(Student[] arr) {
        return part(arr, 0, arr.length - 1);
    }
}