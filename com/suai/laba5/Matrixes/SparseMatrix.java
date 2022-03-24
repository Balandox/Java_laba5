package com.suai.laba5.Matrixes;
import java.util.LinkedList;
import java.util.ListIterator;


public class SparseMatrix implements IMatrix{

    private static class Node{
        private final int rowIdx;
        private final int colIdx;
        private int val;

        public Node(int row, int col, int value){
            this.rowIdx = row;
            this.colIdx = col;
            this.val = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null | ! (o instanceof Node)) return false;
            Node node = (Node) o;
            return this.rowIdx == node.rowIdx & this.colIdx == node.colIdx;
        }

    }

    private final int rows;
    private final int columns;
    private final LinkedList<Node> data = new LinkedList<>();

    public SparseMatrix(int row, int col){
        this.rows = row;
        this.columns = col;
    }

    public void setElement(int row, int col, int val){
        if (row > this.rows | col > this.columns | row < 0 | col < 0)
            throw new IllegalArgumentException("This position does not exist!");

        ListIterator<Node> it = this.data.listIterator();
        Node tmp = new Node(row, col, val);

        while(it.hasNext()){
            Node cmpObject = (Node)it.next();
            if(tmp.equals(cmpObject)) {
                it.previous().val = val;
                return;
            }
        }
        this.data.add(tmp);
    }

    public int getElement(int row, int col){
        if (row > this.rows | col > this.columns | row < 0 | col < 0)
            throw new IllegalArgumentException("This position does not exist!");

        ListIterator<Node> it = this.data.listIterator();
        Node tmp = new Node(row, col, 0);

        while(it.hasNext()){
            Node cmpObject = (Node)it.next();
            if(tmp.equals(cmpObject))
                return cmpObject.val;
        }
        return 0;

    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++)
                sb.append(this.getElement(i, j)).append("\t\t");
            sb.append("\n");
        }
        return sb.toString();
    }

    public IMatrix product(IMatrix m){

        if(m == null)
            throw new NullPointerException("Input matrix is a null parameter");
        if(this.columns != m.getRows())
            throw  new IllegalArgumentException("Amount of columns first matrix not equal amount of rows!");

        IMatrix res = new SparseMatrix(this.rows, m.getColumns());
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < m.getColumns(); j++) {
                for (int k = 0; k < this.columns; k++) {
                    int elem1 = this.getElement(i, k);
                    int elem2 = m.getElement(k, j);
                    if(elem1 != 0 & elem2 != 0)
                        res.setElement(i, j, elem1 * elem2);
                }
            }
        }
        return res;
    }

    public int getRows(){return this.rows;}
    public int getColumns(){return this.columns;}

    public IMatrix sum(IMatrix m){


        if(m == null)
            throw new NullPointerException("Input matrix is a null parameter");

        if(this.rows != m.getRows() | this.columns != m.getColumns()) {
            throw new IllegalArgumentException("Matrix sizes are not equals!");
        }

        IMatrix res = new SparseMatrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++)
            for (int j = 0; j < this.columns; j++) {
                int elem1 = this.getElement(i, j);
                int elem2 = m.getElement(i, j);
                if(elem1 != 0 & elem2 != 0)
                    res.setElement(i, j, elem1 + elem2);
            }
        return res;
    }

}
