package npbench3lu.arrayXD;

public class Array4Ddouble {
    protected int beginX;
    protected int beginY;
    protected int beginZ;
    protected int beginW;
    protected int endX;
    protected int endY;
    protected int endZ;
    protected int endW;
    protected int sizeX;
    protected int sizeY;
    protected int sizeZ;
    protected int sizeW;
    protected double data[];

    public Array4Ddouble(int sx, int sy, int sz, int sw) {
        sizeX = sx;
        sizeY = sy;
        sizeZ = sz;
        sizeW = sw;
        beginX = 1;
        beginY = 1;
        beginZ = 1;
        beginW = 1;
        endX = sx;
        endY = sy;
        endZ = sz;
        endW = sw;
        data = new double[sx * sy * sz * sw];
    }

    public Array4Ddouble(int bx, int ex, int by, int ey, int bz, int ez, int bw, int ew) {
        sizeX = ex - bx + 1;
        sizeY = ey - by + 1;
        sizeZ = ez - bz + 1;
        sizeW = ew - bw + 1;
        beginX = bx;
        beginY = by;
        beginZ = bz;
        beginW = bw;
        endX = ex;
        endY = ey;
        endZ = ez;
        endW = ew;
        data = new double[sizeX * sizeY * sizeZ * sizeW];
    }

    public void set(int x, int y, int z, int w, double value) {
        data[(x - beginX) + (y - beginY) * sizeX + (z - beginZ) * sizeX * sizeY
                + (w - beginW) * sizeX * sizeY * sizeZ] = value;
    }

    public double get(int x, int y, int z, int w) {
        return data[(x - beginX) + (y - beginY) * sizeX + (z - beginZ) * sizeX * sizeY
                + (w - beginW) * sizeX * sizeY * sizeZ];
    }

    public void copy(int x, int y, int z, int w, double[] values, int size) {
        int copyto;
        copyto = (x - beginX) + (y - beginY) * sizeX + (z - beginZ) * sizeX * sizeY
                + (w - beginW) * sizeX * sizeY * sizeZ;
        for (int i = 0; i < size; i++) {
            data[copyto + i] = values[i];
        }
    }

    public double[] getData() {
        return data;
    }

    public int getDataSize() {
        return sizeX * sizeY * sizeZ * sizeW;
    }

}
