import com.suai.laba5.Matrixes.*;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Random;
import java.util.Objects;

public class Main {

    public static void main(String[] args){
        int size = 100;
        /*IMatrix us1 = new UsualMatrix(size, size);
        IMatrix sm1 = new SparseMatrix(size, size);
        int seed = 1;
        for(int i = 0, j = 0; i < size; i++, j++){
            sm1.setElement(i, j, seed);
            us1.setElement(i, j, seed);
            seed++;
        }*/
        Random rand = new Random();
        IMatrix sm1 = new SparseMatrix(size, size);
        IMatrix us1 = new UsualMatrix(size, size);
        for(int i = 0; i < size; i++){
            int val = rand.nextInt(9) + 1;
            int rowIdx = rand.nextInt(size - 1);
            int colIdx = rand.nextInt(size - 1);
            if (sm1.getElement(rowIdx, colIdx) == 0) {
                sm1.setElement(rowIdx, colIdx, val);
                us1.setElement(rowIdx, colIdx, val);
            }
        }
       // System.out.println(sm1);
        IMatrix us2 = new UsualMatrix(size, size);
        IMatrix sm2 = new SparseMatrix(size, size);
        for(int i = 0; i < size; i++){
            int val = rand.nextInt(9) + 1;
            int rowIdx = rand.nextInt(size - 1);
            int colIdx = rand.nextInt(size - 1);
            if (us2.getElement(rowIdx, colIdx) == 0) {
                us2.setElement(rowIdx, colIdx, val);
                sm2.setElement(rowIdx, colIdx, val);
            }
        }
        System.out.println(us1.equals(sm1));
        System.out.println(us2.equals(sm2));
        System.out.println((us1.product(us2).equals(sm1.product(sm2))));

        // System.out.println(sm1);
        //System.out.println((sm1.product(sm1)).equals(us1.product(us1)));
    }

}
