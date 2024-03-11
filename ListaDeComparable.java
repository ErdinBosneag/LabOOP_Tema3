import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class ListaDeComparable <T extends Comparable<T>> {
    private T [] elemente;
    private int size;
    public ListaDeComparable (int length, Class<T> tip) {
        elemente = (T []) Array.newInstance(tip,length);
        this.size = 0;
    }
    public String afisareElemente() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++) {
            sb.append(elemente[i]);
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public void adaugareElement(T element) throws ExceptieListaPlina {
        if(size >= elemente.length)throw new ExceptieListaPlina();
        else {
            elemente [size++] = element;
        }
    }

    public T eliminareElement() throws ExceptieListaGoala {
        if(size == 0)throw new ExceptieListaGoala();
        else {
            T c = elemente[0];
            for(int i = 0; i < size - 1; i++)
                elemente[i] = elemente[i+1];
            size--;
            return c;
        }
    }

    public void sortareElemente() {
        Arrays.sort(elemente, 0, size, Collections.reverseOrder());
    }
}
