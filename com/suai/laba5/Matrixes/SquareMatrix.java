package com.suai.laba5.Matrixes;

import com.suai.laba5.Matrixes.UsualMatrix;

public class SquareMatrix extends UsualMatrix implements IMatrix {

    public SquareMatrix(int size) {
        super(size, size);
    }

    @Override
    public UsualMatrix sum(UsualMatrix m) {
        UsualMatrix res = new UsualMatrix(this.rows, this.columns);
        for (int i = 0; i < this.data.length; i++)
            for (int j = 0; j < this.columns; j++)
                res.data[i][j] = this.data[i][j] + m.data[i][j];
        return res;
    }
}

