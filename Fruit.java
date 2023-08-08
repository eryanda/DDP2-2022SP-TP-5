/**
 * Representasi produk buah.
 */
public class Fruit extends Product {
    // Atribut spesifik untuk kelas Fruit
    private boolean isLocal; // Merupakan penanda apakah buah tersebut merupakan produk lokal atau impor.

    /**
     * Konstruktor untuk kelas Fruit.
     *
     * @param nama     Nama produk buah.
     * @param price    Harga produk buah.
     * @param stock    Jumlah stok produk buah.
     * @param isLocal  Status penanda apakah buah merupakan produk lokal atau impor.
     */
    public Fruit(String nama, int price, int stock, boolean isLocal) {
        super(nama, price, stock);
        this.isLocal = isLocal;
    }

    /**
     * Menghitung dan mengembalikan persentase diskon berdasarkan jumlah pembelian dan status lokal atau impor.
     *
     * @param quantity Jumlah pembelian buah.
     * @return Persentase diskon berdasarkan jumlah pembelian dan status lokal atau impor.
     */
    @Override
    public int checkDiscount(int quantity) {
        if (isLocal) {
            if (quantity >= 5) {
                return 30; // Diskon 30% untuk pembelian buah lokal minimal 5 kg
            } else if (quantity >= 3) {
                return 20; // Diskon 20% untuk pembelian buah lokal minimal 3 kg
            }
        } else {
            if (quantity >= 5) {
                return 20; // Diskon 20% untuk pembelian buah impor minimal 5 kg
            } else if (quantity >= 3) {
                return 15; // Diskon 15% untuk pembelian buah impor minimal 3 kg
            }
        }
        return 0; // Tidak ada diskon jika kuantitas tidak mencukupi
    }

    /**
     * Mengembalikan status apakah buah merupakan produk lokal atau impor.
     *
     * @return true jika buah merupakan produk lokal, false jika buah merupakan produk impor.
     */
    public boolean isLocal() {
        return isLocal;
    }

    /**
     * Mengatur status apakah buah merupakan produk lokal atau impor.
     *
     * @param local true jika buah merupakan produk lokal, false jika buah merupakan produk impor.
     */
    public void setLocal(boolean local) {
        isLocal = local;
    }
}
