import com.suai.laba5.Matrixes.*;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Objects;

public class Main {

    public static void main(String[] args){
        IMatrix sm = new SparseMatrix(3, 3);
        IMatrix us = new UsualMatrix(3, 3);
        us.setElement(0, 1, 5);
        us.setElement(1, 0, 2);
        us.setElement(2, 1, 9);
        us.setElement(2, 2, 7);
        System.out.println(us.toString());
        sm.setElement(0, 1, 5);
        sm.setElement(1, 0, 2);
        sm.setElement(2, 1, 9);
        sm.setElement(2, 2, 7);
        System.out.println(sm.product(us));
    }

}
