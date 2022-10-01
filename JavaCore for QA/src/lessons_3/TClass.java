package lessons_3;

    public class TClass<T> {
        T tmp;

        public void ChangeArr(T[] a, int x, int y) {
            tmp = a[x];
            a[x] = a[y];
            a[y] = tmp;
        }
    }

