package edu.bloomu.homework1;


public class MatrixDriver {
    public static void main(String[] args) throws DimensionMismatch {
        Matrix m = new Matrix(3, 2);
        Matrix m2 = new Matrix(3, 2);
        System.out.println(m);

        m.setEntry(0 , 0, 2);
        m.setEntry(0 , 1, 5);
        m.setEntry(1 , 0, -3);
        m.setEntry(1 , 1, 8);
        m.setEntry(2 , 0, 7);
        m.setEntry(2 , 1, 5);

        m2.setEntry(0 , 0, -3);
        m2.setEntry(0 , 1, 10);
        m2.setEntry(1 , 0, 2);
        m2.setEntry(1 , 1, 8);
        m2.setEntry(2 , 0, 9);
        m2.setEntry(2 , 1, 0);

        System.out.println("Here is the first matrix:\n" + m + "\n" + "Here is the " +
                "second matrix:\n" + m2);

        if (m.equals(m2)) {
            System.out.println("The matrices are the same!");
        } else {
            System.out.println("The matrices are different!");
        }

        System.out.println("Here are the matrices added:\n" + m.add(m2));
        System.out.println("Here are the matrices subtracted\n" + m.subtract(m2) + "\n");

        Matrix m3 = new Matrix(2, 3);

        System.out.println("Here is new matrix:\n" + m3 + "\n" + "Here is the " +
                "second matrix from before:\n" + m);

        m3.setEntry(0, 0, 1);
        m3.setEntry(0, 1, 2);
        m3.setEntry(0, 2, 3);
        m3.setEntry(1, 0, 3);
        m3.setEntry(1, 1, 2);
        m3.setEntry(1, 2, 1);


        System.out.println("Here are the two matrices multiplied:\n" + m3.multiply(m));

        System.out.println(m3.transpose());
    }

}
